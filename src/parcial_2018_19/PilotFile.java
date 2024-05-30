package parcial_2018_19;

import java.io.IOException;
import java.io.RandomAccessFile;

public class PilotFile {
    private RandomAccessFile raf;
    public PilotFile(String fname) throws IOException {
        this.raf = new RandomAccessFile(fname, "rw");
    }
    public void close() throws IOException { this.raf.close(); }
    public Pilot read(int id) throws IOException {
        raf.seek((id-1) * Pilot.SIZE);
        byte[] record = new byte[Pilot.SIZE];
        raf.read(record);
        return Pilot.fromBytes(record);
    }
    public void write(Pilot pilot) throws IOException {
        raf.seek((pilot.getId()-1) * Pilot.SIZE);
        byte[] record = pilot.toBytes();
        raf.write(record);
    }
    public boolean contains(int id) throws IOException {
        return raf.length()/Pilot.SIZE >=id && id>0;
    }
}

