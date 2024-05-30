package recu_2017_18;

import utils.PackUtils;

public class Product {

    private static final int NAME_LIMIT = 20;
    public static final int SIZE = 8+NAME_LIMIT*2+StatVar.SIZE;

    private long id;
    private String name;
    private StatVar quantityStats;

    public Product(long id, String name, StatVar quantityStats) {
        this.id = id; this.name = name;
        this.quantityStats = quantityStats;
    }

    public long getId() { return id; }
    public void addQuantity(int measure) {
        quantityStats.add(measure);
    }
    public byte[] toBytes() {
        byte[] r = new byte[SIZE];
        int off = 0;
        PackUtils.packLong(id, r, off);
        off += 8;
        PackUtils.packLimitedString(name, NAME_LIMIT,r, off);
        off += NAME_LIMIT*2;
        this.quantityStats.pack(r, off);
        return r;
    }

    public static Product fromBytes(byte[] record) {
        int off = 0;
        long id = PackUtils.unpackLong(record, off);
        off += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, off);
        off+= NAME_LIMIT * 2;
        StatVar st = StatVar.unpack(record, off);
        return new Product(id, name, st);
    }
}
