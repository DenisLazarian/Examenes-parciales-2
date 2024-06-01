package parcial2_2015_16;

import utils.PackUtils;

public class Product {

    private static final int NAME_LIMIT = 20; // In chars
    public static final int SIZE = 8+NAME_LIMIT*2+4+8;

    private long id;
    private String name;
    private int units;
    private double price;

    public Product(long id, String name, int units, double price) {
        this.id = id;
        this.name = name;
        this.units = units;
        this.price = price;
    }

    public byte[] toBytes() {
        int offset = 0;
        byte[] record = new byte[SIZE];
        PackUtils.packLong(id,record,offset);
        offset += 8;
        PackUtils.packLimitedString(name,NAME_LIMIT,record, offset);
        offset += NAME_LIMIT*2;
        PackUtils.packInt(units, record, offset);
        offset += 4;
        PackUtils.packDouble(price, record, offset);
        return record;
    }
    public static Product fromBytes(byte[] register) {
        int offset = 0;
        long id = PackUtils.unpackLong(register,offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT,register, offset);
        offset += NAME_LIMIT*2;
        int units = PackUtils.unpackInt( register, offset);
        offset += 4;
        double price = PackUtils.unpackDouble( register, offset);

        return new Product(id, name, units, price);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // getters i setters



}
