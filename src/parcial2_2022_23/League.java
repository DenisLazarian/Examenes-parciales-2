package parcial2_2022_23;


import java.io.IOException;
import java.io.RandomAccessFile;

public class League {
    private final RandomAccessFile raf;
    public League(String fileName) throws IOException {
        this.raf = new RandomAccessFile(fileName, "rw");
    }
    public Team readTeam(long id) throws IOException {
        raf.seek((id-1) * Team.SIZE);
        byte[] rec = new byte[Team.SIZE];
        raf.read(rec);
        return Team.fromBytes(rec);
    }
    public boolean exists(long id) throws IOException {  throw new UnsupportedOperationException("Not work");}
    public void writeTeam(Team team) throws IOException {  throw new UnsupportedOperationException("Implementar mas tarde");}
    public int numTeams() throws IOException {  throw new UnsupportedOperationException("Not work"); }
    public void close() throws IOException {  throw new UnsupportedOperationException("Not work"); }
}