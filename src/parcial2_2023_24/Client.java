package parcial2_2023_24;

import utils.PackUtils;

public class Client {
    private static final int NAME_LIMIT = 20;
    public static final int SIZE = 4+NAME_LIMIT*2+4;

    private final int id;
    private final String name;
    private int idVechicle;


    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        this.idVechicle = -1;
    }
    public void finishUse(){
        // prec: this.idVechicle != -1
        this.idVechicle = -1;
    }

    public void beginUse(){
        // Prec: this.idVehicle != -1
        this.idVechicle = -1;
    }

    public byte[] toByte(){
        int offset = 0;
        byte[] record = new byte[SIZE];
        PackUtils.packInt(id, record, offset);
        offset += 4;
        PackUtils.packLimitedString(name, NAME_LIMIT, record, offset);
        offset += NAME_LIMIT*2;
        PackUtils.packInt(idVechicle, record, offset);
        return record;
    }

    public static Client fromBytes(byte[] record){
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIdVechicle() {
        return idVechicle;
    }
}
