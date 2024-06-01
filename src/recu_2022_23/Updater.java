package recu_2022_23;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Updater extends CommandLineProgram {

    private static final String CLIENTS = "clients.dat";
    private static final String PRODUCTS = "products.dat";
    private static final String PURCHASES = "purchases.txt";
    private ClientDB clientsDB;
    private ProductDB productsDB;
    private BufferedReader purchases;
    public void run() {
        try {
            openFiles();
            processPurchases();
            closeFiles();
        } catch (IOException ex) {
            println("Ha habido un error");
        }
    }
    private void openFiles() throws IOException {
        clientsDB = new ClientDB(CLIENTS);
        productsDB = new ProductDB(PRODUCTS);
        purchases = new BufferedReader(new FileReader(PURCHASES));
    }
    private void closeFiles() throws IOException {
        clientsDB.close(); productsDB.close(); purchases.close();
    }
    private void updateClient(Client client, long idProduct, int quantity) throws IOException {
        // Precondición: client != null
        if(existProduct(idProduct) && quantity >= 0){
            Product p = productsDB.read(idProduct);
            client.add(quantity, p.getPrice());
        }
    }

    private boolean existProduct(long idProduct) throws IOException {
        return 0 < idProduct && idProduct <= productsDB.numProducts();
    }

    private void processPurchases() throws IOException {
        String line = purchases.readLine();
        while(line != null){
            processPurchases(line);
            line = purchases.readLine();
        }
    }

    public void processPurchases(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(line, ";");
        long idClient = Long.parseLong(st.nextToken());
        if(existClient(idClient)){
            Client c = clientsDB.read(idClient);
            while(st.hasMoreTokens()){
                long idProduct = Long.parseLong(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());

                updateClient(c, idProduct, quantity);
            }
            clientsDB.write(c);
        }
    }

    private boolean existClient(long idClient) throws IOException {
        return 0 < idClient && idClient <= clientsDB.numClients();
    }

}
