package recu_parcial2_2019_20;

import utils.PackUtils;

public class Runner {

    private static final int NAME_LIMIT = 30;
    public static final int SIZE = 8+NAME_LIMIT*2+4+Duration.SIZE;

    private long id; // identificador del corredor
    private String name; // nombre del corredor
    private int numFinished; // número de etapas que ha acabado
    private Duration total; // tiempo total empleado en la carrera

    public Runner(long id, String name) {
        this.id = id; this.name = name;
        this.numFinished = 0;
        this.total = new Duration(0, 0);
    }
    public long getId() {
        return this.id;
    }
    public void addFinished(Duration duration) {
        numFinished += 1;
        total.add(duration);
    }
    public byte[] toBytes() {
        int offset = 0;
        byte[] record = new byte[SIZE];
        PackUtils.packLong(id, record, offset);
        offset += 8;
        PackUtils.packLimitedString(name, NAME_LIMIT, record, offset);
        offset += NAME_LIMIT * 2;
        PackUtils.packInt(numFinished, record, offset);
        offset += 4;
        total.packDuration(record, offset);

        return record;
    }
    public static Runner fromBytes(byte[] record) {
        int offset = 0;
        long id = PackUtils.unpackLong(record, offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset+=NAME_LIMIT*2;
        int nf = PackUtils.unpackInt(record, offset);
        Duration d = Duration.unpackDuration(record,offset);

        Runner r = new Runner(id, name);
        r.numFinished = nf;
        r.total = d;
        return r;
    }
    public String toString() {
// Devuelve un String con los datos del corredor
        return String.format("(%d) %s [%d - %s]",
        this.id, this.name,
                this.numFinished, this.total);
    }


}
