package parcial2_2020_21;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Updater extends CommandLineProgram {
    private static final String RAIN = "rain.csv";
    private static final String STATS = "stats.dat";
    private Stats stats;
    private BufferedReader rain;

    public void run() {
        try {
            openFiles();
            updateStats();
            closeFiles();
        } catch (IOException ex) {
            println("Houston, Houston, we have a problem");
        }
    }
    private void openFiles() throws IOException {
        stats = new Stats(STATS);
        rain = new BufferedReader(new FileReader(RAIN));
    }
    private void closeFiles() throws IOException {
        stats.close(); rain.close();
    }
    private void updateStats() throws IOException {
        String line = rain.readLine();
        while(line != null){
            updateStats(line);
            line = rain.readLine();
        }
    }

    private void updateStats(String line) throws IOException {
        StringTokenizer st = new StringTokenizer( line, ",");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        double l = Double.parseDouble(st.nextToken());

        if(cordsRange(x,y) && timeRange(h,m) && l>0){
            Record s = stats.read(x,y);
            s.addRainEvent(new Duration(h,m), l);
            stats.write(s);
        }
    }

    private boolean timeRange(int h, int m) {
        return !(h<0 || m<0) && !(h==0 && m==0) ;
    }

    private boolean cordsRange(int x, int y) {
        return x>=0 && x<Record.GRID_SIZE && y>=0 && y<Record.GRID_SIZE;
    }

}
