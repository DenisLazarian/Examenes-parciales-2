package parcial2_2023_24;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ClientsDB {
    private final RandomAccessFile raf;


    public ClientsDB(String name) throws IOException {
        this.raf = new RandomAccessFile(name, "rw");
    }

    public Client read(int id) throws IOException{
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void write(Client client) throws IOException{
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public boolean isValid(int id) throws IOException{
        return id > 0 && raf.length()/Client.SIZE >= id;
    }
    public void close() throws IOException{
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
