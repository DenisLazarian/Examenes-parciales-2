package recu_2022_23;

import utils.PackUtils;

public class Client {
    private static final int NAME_LIMIT = 20; // In chars

    private long id; // identificador
    private String name; // nombre
    private int total; // total de compras en €

    public static final int SIZE = 8+NAME_LIMIT*2+4; // In bytes

    public Client(long id, String name) {
        this.id = id; this.name = name; this.total = 0;
    }
    // getters
    public void add(int quantity, int price) {
// Precondición: quantity > 0 && price > 0
        this.total += quantity * price;
    }
    public byte[] toBytes() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
    public static Client fromBytes(byte[] bytes) {
        int offset = 0;
        long id = PackUtils.unpackLong(bytes, offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, bytes, offset);
        offset += NAME_LIMIT*2;
        int total = PackUtils.unpackInt(bytes, offset);

        Client c = new Client(id, name);
        c.total = total;
        return c;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }
}
