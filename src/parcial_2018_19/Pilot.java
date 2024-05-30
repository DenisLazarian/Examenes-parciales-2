package parcial_2018_19;

import utils.PackUtils;

public class Pilot {
    private static final int NAME_LIMIT = 30;
    public static final int SIZE = 4+NAME_LIMIT*2+4+4;

    private int id; // identificador
    private String name; // nombre
    private int points; // puntos en el campeonato
    private int finished; // carreras finalizadas

    public Pilot(int id, String name, int points, int finished) {
        this.id = id; this.name = name;
        this.points = points; this.finished = finished;
    }


    // getters: getId, getName getPoints, getFinished
// setters: setPoints, setFinished
    public byte[] toBytes() {
        int offset = 0;
        byte[] record = new byte[SIZE];
        PackUtils.packInt(id, record, offset);
        offset+=4;
        PackUtils.packLimitedString(name, NAME_LIMIT, record, offset);
        offset+=NAME_LIMIT*2;
        PackUtils.packInt(points, record, offset);
        offset+=4;
        PackUtils.packInt(finished,record,offset);
        return record;
    }
    public static Pilot fromBytes(byte[] record) {
        int offset = 0;
        int id = PackUtils.unpackInt(record, offset);
        offset += 4;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += NAME_LIMIT*2;
        int points = PackUtils.unpackInt(record,offset);
        offset += 4;
        int finished = PackUtils.unpackInt(record, offset);
        return new Pilot(id, name, points, finished);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getFinished() {
        return finished;
    }
}
