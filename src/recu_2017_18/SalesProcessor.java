package recu_2017_18;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class SalesProcessor extends CommandLineProgram {
    private static final String PRODUCTS = "products.dat";
    private static final String SALES = "sales.csv";
    private RandomAccessFile products; // Fichero de productos
    private BufferedReader sales; // Fichero de ventas
    public void run() {
        try {
            openFiles();
            processSales();
            closeFiles();
        } catch (IOException ex) {
//            println("Error");
            print(ex.getMessage());
        }
    }
    private void openFiles() throws IOException {
        products = new RandomAccessFile(PRODUCTS, "rw");
        sales = new BufferedReader(new FileReader(SALES));
    }
    private void closeFiles() throws IOException {
        products.close(); sales.close();
    }
    private long numProducts() throws IOException {
// Devuelve el número de productos que hay en el fichero.
        return products.length() / Product.SIZE;
    }

    private void writeProduct(Product product) throws IOException {
// Guarda el producto dado en el fichero de productos en el
// lugar que le corresponde según su id (los ids empiezan
// desde 1). Podéis suponer que el producto tiene un id válido
// dentro del fichero
        products.seek((product.getId() - 1) * Product.SIZE);
        byte[] record = product.toBytes();
        products.write(record);
    }

    private Product readProduct(long id) throws IOException {
// Devuelve el producto que está en la posición correspondiente
// al id. Podéis suponer que el id es válido en el fichero.
        products.seek((id - 1) * Product.SIZE);
        byte[] record = new byte[Product.SIZE];
        products.read(record);
        return Product.fromBytes(record);
    }
    private void processSales() throws IOException {
// Trata las líneas del fichero de ventas, actualizando los
// productos del fichero de productos en función de las
// cantidades vendidas. Los identificadores de productos que
// no son válidos, se ignoran.
        String line = sales.readLine();
        while(line != null){
            processSales(line);
            line = sales.readLine();
        }
    }

    private void processSales(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(";",line);

        while(st.hasMoreTokens()){
            long id = Long.parseLong(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());

            if(quantity >= 1){
                try{
                    Product product = readProduct(id);
                    product.addQuantity(quantity);
                    writeProduct(product);
                }catch (IOException e){
                    println("Producto no valido");
                }
            }
        }
    }

    public static void main(String[] args) {
        new SalesProcessor().start(args);
    }
}
