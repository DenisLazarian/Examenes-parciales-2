package parcial2_2020_21;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class Stats {
    private final RandomAccessFile raf;

    public Stats(String name) throws IOException {
        this.raf = new RandomAccessFile(name, "rw");
    }

    public Record read(int x, int y) throws IOException {
        raf.seek((x*Record.GRID_SIZE +y)*Record.SIZE);
        byte[] record = new byte[Record.SIZE];
        raf.read(record);
        return Record.fromBytes(record);
    }
    public void write(Record record) throws IOException {
        throw new UnsupportedEncodingException("Not implemented yet");
    }
    public void close() throws IOException {
        this.raf.close();
    }

}
