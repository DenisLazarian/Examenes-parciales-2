package recu_2017_18;

import utils.PackUtils;

public class StatVar {

    public static final int SIZE = 4*5;
    private int count, sum, sumSquares, min, max;

    public StatVar() {
        count = 0;
        sum = 0;
        sumSquares= 0;
        min = 0;
        max = 0;
    }

    public void add(int value) {
        count += 1;
        sum += value;
        sumSquares += value*value;
    }

    public double mean() {
        return sum/count;
    }

    public double variance() {
        throw new UnsupportedOperationException("Pendiente para implementar");
    }

    public void pack(byte[] record, int offset) {
        PackUtils.packInt(count, record, offset);
        offset += 4;
        PackUtils.packInt(sum, record, offset);
        offset += 4;
        PackUtils.packInt(sumSquares, record, offset);
        offset += 4;
        PackUtils.packInt(min, record, offset);
        offset += 4;
        PackUtils.packInt(max,record,offset);
    }

    public static StatVar unpack(byte[] record, int offset) {
        int c = PackUtils.unpackInt(record, offset);
        offset+=4;
        int s = PackUtils.unpackInt(record, offset);
        offset+=4;
        int sq = PackUtils.unpackInt(record, offset);
        offset+=4;
        int min = PackUtils.unpackInt(record, offset);
        offset+=4;
        int max = PackUtils.unpackInt(record, offset);

        StatVar st = new StatVar();
        st.count = c;
        st.sum = s;
        st.sumSquares = sq;
        st.min = min;
        st.max = max;

        return st;
    }
}

