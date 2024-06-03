package parcial2_2023_24;

import utils.PackUtils;

public class Vehicle {
    private static final int BRAND_LIMIT = 10;
    private static final int MODEL_LIMIT = 10;
    public static final int SIZE = 4 + BRAND_LIMIT*2+MODEL_LIMIT*2+4+8+4;

    private final int id;
    private final String brand;
    private final String model;
    private int numUses;
    private double totalKms;
    private int idClient;


    public Vehicle(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.numUses = 0; this.totalKms = 0.0; this.idClient = -1;
    }

    public void beginUse(int clientId){
        // Prec: this.clientId == -1 && clentId > 0
        this.idClient = clientId;
    }
    public void finishUse(double kms){
        // Prec: this.clientId != -1 && kms > 0.0
        this.numUses += 1;
        this.totalKms += kms;
        this.idClient = -1;
    }

    public byte[] toBytes(){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static Vehicle fromBytes(byte[] record){
        int offset = 0;
        int id = PackUtils.unpackInt(record, offset);
        offset += 4;
        String brand = PackUtils.unpackLimitedString(BRAND_LIMIT,record, offset);
        offset += BRAND_LIMIT*2;
        String model = PackUtils.unpackLimitedString(MODEL_LIMIT,record, offset);
        offset += MODEL_LIMIT *2;

        int nu = PackUtils.unpackInt(record, offset);
        offset += 4;
        double tk = PackUtils.unpackDouble(record, offset);
        offset += 8;
        int idc= PackUtils.unpackInt(record, offset);
        Vehicle v = new Vehicle(id, brand, model);
        v.totalKms = tk;
        v.numUses = nu;
        v.idClient = idc;

        return v;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getNumUses() {
        return numUses;
    }

    public double getTotalKms() {
        return totalKms;
    }

    public int getIdClient() {
        return idClient;
    }
}
