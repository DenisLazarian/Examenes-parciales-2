package recu_2022_23;

import java.io.IOException;
import java.io.RandomAccessFile;

public class ProductDB {

    private RandomAccessFile raf;

    public ProductDB(String fname) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void close() throws IOException {
        throw new UnsupportedOperationException("Not implemented yet");

    }
    public Product read(long id) throws IOException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void write(Product product) throws IOException {
        raf.seek(product.getId()*Product.SIZE);
        byte[] record = product.toBytes();
        raf.write(record);
    }
    public long numProducts() throws IOException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
