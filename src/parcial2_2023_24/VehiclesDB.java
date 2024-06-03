package parcial2_2023_24;

import java.io.IOException;
import java.io.RandomAccessFile;

public class VehiclesDB {
    private final RandomAccessFile raf;


    public VehiclesDB(String name) throws IOException {
        this.raf = new RandomAccessFile(name, "rw");
    }

    public Vehicle read(int id) throws IOException{
        raf.seek((id-1)*Vehicle.SIZE);
        byte[] record = new byte[Vehicle.SIZE];
        raf.read(record);
        return Vehicle.fromBytes(record);
    }

    public void write(Vehicle vehicle) throws IOException{
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public boolean isValid(int id) throws IOException{
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public void close() throws IOException{
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
