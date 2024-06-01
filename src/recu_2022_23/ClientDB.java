package recu_2022_23;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class ClientDB {
    private RandomAccessFile raf;
    public ClientDB(String fname) throws IOException {
        throw new UnsupportedEncodingException("Not implemented yet");
    }
    public void close() throws IOException {
        throw new UnsupportedEncodingException("Not implemented yet");
    }
    public Client read(long id) throws IOException {
        raf.seek((id-1)*Client.SIZE);
        byte[] record = new byte[Client.SIZE];
        raf.read(record);
        return Client.fromBytes(record);
    }

    public void write(Client client) throws IOException {
        throw new UnsupportedEncodingException("Not implemented yet");

    }
    public long numClients() throws IOException {
        throw new UnsupportedEncodingException("Not implemented yet");

    }

}
