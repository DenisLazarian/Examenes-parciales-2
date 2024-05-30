package parcial2_2020_21;

import utils.PackUtils;

public class Record {
    public static final int GRID_SIZE = 500;
    public static final int SIZE = 4+4+Duration.SIZE+8;

    private final int x; // 0 <= x < GRID_SIZE
    private final int y; // 0 <= y < GRID_SIZE
    private Duration totalDuration;
    private double totalLiters; // 0.0 <= totalLiters

    public Record(int x, int y) {
        // Precondición: 0 <= x < GRID_SIZE && 0 <= y < GRID_SIZE
        this.x = x; this.y = y;
        this.totalDuration = new Duration(0, 0);
        this.totalLiters = 0.0;
    }

    // getters: getX, getY

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addRainEvent(Duration duration, double liters) {
        totalDuration = Duration.add(totalDuration, duration);
        totalLiters += liters;
    }
    public byte[] toBytes() {
        throw  new UnsupportedOperationException("Not implemented yet");
    }
    public static Record fromBytes(byte[] record) {
        int offset = 0;
        int x = PackUtils.unpackInt(record, offset);
        offset += 4;
        int y = PackUtils.unpackInt(record, offset);
        offset += 4;
        Duration d = Duration.unpackDuration(record, offset);
        offset += Duration.SIZE;
        double tLiters = PackUtils.unpackDouble(record, offset);

        Record r = new Record(x, y);
        r.totalDuration = d;
        r.totalLiters = tLiters;
        return r;
    }


}
