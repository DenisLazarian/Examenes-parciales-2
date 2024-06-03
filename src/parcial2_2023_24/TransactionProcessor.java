package parcial2_2023_24;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TransactionProcessor extends CommandLineProgram {
    private static final String VEHICLES = "vehicles.dat";
    private static final String CLIENTS = "clients.dat";
    private static final String TRANSACTIONS = "transactions.txt";

    private BufferedReader transactions;
    private VehiclesDB vehiclesDB;
    private ClientsDB clientsDB;

    public void run(){
        try{
            openFiles();
            executeTransactions();
            closeFiles();
        }catch (IOException e){
            println("Ha havido un error");
        }
    }

    private void executeTransactions() throws IOException {
        String line = transactions.readLine();
        while(line != null){
            executeTransactions(line);
            line = transactions.readLine();
        }
    }

    private void executeTransactions(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(line , ";");
        String mode = st.nextToken();

        if(mode == "ENTREGAT"){
            bringVehicle(st);
        }else if(mode == "DEVOLVER"){
            returnVehicle(st);
        }
    }

    private void returnVehicle(StringTokenizer st) throws IOException {
        int idv = Integer.parseInt(st.nextToken());
        double kms = Double.parseDouble(st.nextToken());

        if(vehiclesDB.isValid(idv)){
            Vehicle v = vehiclesDB.read(idv);

            if(v.getIdClient() != -1 &&  kms > 0.0){
                Client c = clientsDB.read(v.getIdClient());
                v.finishUse(kms);
                c.finishUse();

                vehiclesDB.write(v);
                clientsDB.write(c);
            }
        }
    }

    private void bringVehicle(StringTokenizer st) throws IOException {
        int idv = Integer.parseInt(st.nextToken());
        int idc = Integer.parseInt(st.nextToken());

        if(vehiclesDB.isValid(idv) && clientsDB.isValid(idc)){
            Vehicle v = vehiclesDB.read(idv);
            Client c = clientsDB.read(idc);

            if(v.getIdClient() == -1 && c.getIdVechicle() == -1){
                v.beginUse(idv);
                c.beginUse();

                vehiclesDB.write(v);
                clientsDB.write(c);
            }
        }
    }

    private void openFiles() throws IOException {
        this.vehiclesDB = new VehiclesDB(VEHICLES);
        this.clientsDB = new ClientsDB(CLIENTS);
        this.transactions = new BufferedReader(new FileReader(TRANSACTIONS));
    }

    private void closeFiles() throws IOException {
        this.vehiclesDB.close();
        this.clientsDB.close();
        this.transactions.close();
    }

}
