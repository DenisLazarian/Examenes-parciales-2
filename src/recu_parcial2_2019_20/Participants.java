package recu_parcial2_2019_20;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Participants {
    private RandomAccessFile raf;
    public Participants(String name) throws IOException {
        this.raf = new RandomAccessFile(name, "rw");
    }
    public Runner read(long id) throws IOException {
        raf.seek(id*Runner.SIZE);
        byte[] record = new byte[Runner.SIZE];
        raf.read(record);
        return Runner.fromBytes(record);
    }
    public void write(Runner runner) throws IOException {
        raf.seek(runner.getId()*Runner.SIZE);
        byte[] record = runner.toBytes();
        raf.write(record);
    }

    public long numRunners() throws IOException {
        return this.raf.length() / Runner.SIZE;
    }
    public void close() throws IOException {
        this.raf.close();
    }

}
