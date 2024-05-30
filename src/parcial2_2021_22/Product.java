package parcial2_2021_22;

import utils.PackUtils;

public class Product {
    public static final int SIZE = 8+ 25*2 + 4;
    private static final int NAME_LIMIT = 25;

    private long id; // identificador del producto
    private String name; // nombre del producto
    private int units; // cantidad de producto disponible (siempre >= 0)

    public Product(long id, String name) {
// Precondición: id >= 1L
        this.id = id; this.name = name; this.units = 0;
    }

    // getters: getId(), getName(), getUnits()
    public void incrementUnits(int amount) {
// Precondición: amount > 0
// incrementa las unidades de producto según el valor de amount
        units += amount;
    }
    public boolean decrementUnits(int amount) {
// Precondición: amount > 0
// si es posible (es decir, si hay suficientes unidades), decrementa
// el número de unidades de producto según el valor de amount y
// devuelve true; si no, devuelve false y no modifica nada

        if(units >= amount){
            units -= amount;
            return true;
        }
        return false;
    }
    public byte[] toBytes() {
        throw new UnsupportedOperationException("not implemented");
    }
    public static Product fromBytes(byte[] record) {
        int offset = 0;
        long id = PackUtils.unpackLong(record,offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset+= NAME_LIMIT*2;
        int units = PackUtils.unpackInt(record, offset);

        Product p = new Product(id, name);
        p.units = units;
        return p;
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
}

