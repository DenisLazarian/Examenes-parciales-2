package parcial2_2022_23;


import utils.PackUtils;

public class StatVar  {

    public static final int SIZE = 4 + 4 + 8;
    private int count;
    private int sum;
    private long sumSquares;

    public StatVar() {
        this.count = 0;
        this.sum = 0;
        this.sumSquares = 0L;
    }

    public void addObservation(int value) {
        this.sum += value;
        this.count += 1;
        this.sumSquares += (long) value * value;
    }

    public double mean() {
        return (double) sum / count;
    }

    public void pack(byte[] record, int offset) {
        PackUtils.packInt(count, record, offset);
        offset += 4;
        PackUtils.packInt(sum, record,offset);
        offset+=4;
        PackUtils.packLong(sumSquares, record, offset);
    }

    public static StatVar unpack(byte[] record, int offset) {
        StatVar st = new StatVar();
        int sum = PackUtils.unpackInt(record,offset);
        st.addObservation(sum);
        return st;
    }
}