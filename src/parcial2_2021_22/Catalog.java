package parcial2_2021_22;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class Catalog {
    private RandomAccessFile raf;
    public Catalog(String name) throws IOException {
        raf = new RandomAccessFile(name, "rw");
    }
    public void close() throws IOException { raf.close(); }
    public Product read(long id) throws IOException {
        throw new UnsupportedEncodingException("No implemented");
    }
    public void write(Product product) throws IOException {
        raf.seek((product.getId()-1) * Product.SIZE);
        byte[] record = product.toBytes();
        raf.write(record);
    }
    public long nextId() throws IOException {
        return (raf.length()/Product.SIZE)+1;
    }
    public boolean contains(long id) throws IOException {
        return id>0 && id<=(raf.length()/Product.SIZE);
    }
}
