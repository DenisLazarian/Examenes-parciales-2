package parcial2_2022_23;

import utils.PackUtils;

public class Team {

    private static final int POINTS_FOR_WIN = 3; // puntos por ganar
    private static final int POINTS_FOR_DRAW = 1; // puntos por empate
    private static final int NAME_LIMIT = 20;


    public static final int SIZE = 8+NAME_LIMIT*2+4+StatVar.SIZE;

    private long id;
    private String name;
    private int points;
    private StatVar goalsScored; // goles que ha marcado
    private StatVar goalsConceded; // goles que han recibido
    public Team(long id, String name) {
        this.id = id;
        this.name = name;
        this.points = 0;
        this.goalsScored = new StatVar();
        this.goalsConceded = new StatVar();
    }
    public byte[] toBytes() {
        int offset = 0;
        byte[] record = new byte[SIZE];
        PackUtils.packLong(id,record,offset);
        offset += 8;
        PackUtils.packLimitedString(name,NAME_LIMIT,record, offset);
        offset += NAME_LIMIT*2;
        PackUtils.packInt(points, record, offset);
        offset += 4;
        goalsScored.pack(record, offset);
        offset += StatVar.SIZE;
        goalsConceded.pack(record, offset);

        return record;
    }
    public static Team fromBytes(byte[] record) {
        int offset = 0;
        long id = PackUtils.unpackLong(record, offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record,offset);
        offset += 2*NAME_LIMIT;
        Team t = new Team(id,name);
        t.points = PackUtils.unpackInt(record, offset);
        offset += 4;
        t.goalsScored = StatVar.unpack(record, offset);
        offset += StatVar.SIZE;
        t.goalsConceded = StatVar.unpack(record,offset);
        return t;
    }
    public void addGameResult(int scored, int conceded) {
        if(scored>conceded){
            this.points += POINTS_FOR_WIN;
        }else if(scored == conceded){
            this.points += POINTS_FOR_DRAW;
        }
        this.goalsScored.addObservation(scored);
        this.goalsConceded.addObservation(scored);
    }
    public long getId() { return this.id; }

}
