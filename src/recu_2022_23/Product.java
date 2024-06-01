package recu_2022_23;

public class Product {

    private static final int NAME_LIMIT = 20; // In chars

    private long id; // identificador
    private String name; // nombre
    private int price; // precio en € (siempre > 0)

    public static final int SIZE = 8+NAME_LIMIT*2+4; // In bytes
    public Product(long id, String name, int price) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    // getters
    public byte[] toBytes() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public static Product fromBytes(byte[] bytes) {
        throw new UnsupportedOperationException("Not implemented yet");

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
