package parcial2_2021_22;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class MovementProcessor extends CommandLineProgram {
    private static final String CATALOG = "catalog.dat";
    private static final String OPERATIONS = "operations.csv";
    private Catalog catalog;
    private BufferedReader operations;

    public void run() {
        try {
            openFiles();
            processMovements();
            closeFiles();
        } catch (IOException ex) {
            println("Error");
        }
    }

    private void processMovements() throws IOException {
        String line = operations.readLine();
        while(line != null){
            processMovements(line);
            line = operations.readLine();
        }
    }

    private void processMovements(String line) throws IOException{
        StringTokenizer st = new StringTokenizer(",", line);
        String mode = st.nextToken();
        switch (mode){
            case "ALTA":{
                altaProduct(st);
                break;
            }
            case "VENTA":{
                ventaProduct(st);
                break;
            }
        }
    }

    private void altaProduct(StringTokenizer st) throws IOException {
        String name = st.nextToken();
        int stock = Integer.parseInt(st.nextToken());

        if(stock > 0){
            Product p = new Product(catalog.nextId(), name);
            p.incrementUnits(stock);
            catalog.write(p);
        }
    }

    private void ventaProduct(StringTokenizer st) throws IOException {
        long id = Long.parseLong(st.nextToken());
        int unity = Integer.parseInt(st.nextToken());

        if(catalog.contains(id) && unity > 0){
            Product p = catalog.read(id);

            if(p.getUnits() >= unity){
                p.decrementUnits(unity);
                catalog.write(p);
            }
        }

    }

    private void openFiles() throws IOException {
        catalog = new Catalog(CATALOG);
        operations = new BufferedReader(new FileReader(OPERATIONS));
    }

    private void closeFiles() throws IOException {
        catalog.close();
        operations.close();
    }
}
