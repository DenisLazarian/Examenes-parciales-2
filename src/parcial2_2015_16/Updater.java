package parcial2_2015_16;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Updater extends CommandLineProgram {
    private static final String CATALOG = "catalog.dat";
    private static final String CHANGES = "changes.txt";
    private RandomAccessFile catalog;
    private BufferedReader changes;
    public void run() {
        try {
            openFiles();
            processChanges();
            closeFiles();
        } catch (IOException ex) {
            println("Hi ha hagut un error");
        }
    }
    private void openFiles() throws IOException {
        catalog = new RandomAccessFile(CATALOG, "rw");
        changes = new BufferedReader(new FileReader(CHANGES));
    }
    private void closeFiles() throws IOException {
        catalog.close(); changes.close();
    }
    private void processChanges() throws IOException {
        String line = changes.readLine();
        while(line != null){
            processChanges(line);
            line = changes.readLine();
        }
    }

    private void processChanges(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(line, ",");
        long id = Long.parseLong(st.nextToken());
        Product p = readProduct(id);
        makeChanges(p, st);
        writeProduct(p);
    }

    private void makeChanges(Product p, StringTokenizer st) {
        while(st.hasMoreTokens()){
            String atr = st.nextToken();
            switch (atr){
                case "name":{
                    p.setName(st.nextToken());
                    break;
                }
                case "units":{
                    p.setUnits(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "price":{
                    p.setPrice(Double.parseDouble(st.nextToken()));
                    break;
                }
            }
        }
    }

    private Product readProduct(long id) throws IOException {
        catalog.seek((id-1)*Product.SIZE);
        byte[] record = new byte[Product.SIZE];
        catalog.read(record);
        return Product.fromBytes(record);
    }
    private void writeProduct(Product p) throws IOException {
        catalog.seek((p.getId()-1)*Product.SIZE);
        byte[] record = p.toBytes();
        catalog.write(record);
    }
}
