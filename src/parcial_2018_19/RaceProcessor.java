package parcial_2018_19;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RaceProcessor extends CommandLineProgram {
    private static int[] POINTS = new int[] {
            25, 18, 15, 10, 8, 6, 5, 3, 2, 1
    };
    private static final String PILOTS = "pilots.dat";
    private static final String RACES = "races.txt";
    private PilotFile pilots;
    private BufferedReader races;
    public void run() {
        try {
            openFiles();
            processRaces();
            closeFiles();
        } catch (IOException ex) {
            println("Houston, Houston, we have a problem");
        }
    }
    private void openFiles() throws IOException {
        pilots = new PilotFile(PILOTS);
        races = new BufferedReader(new FileReader(RACES));
    }
    private void closeFiles() throws IOException {
        pilots.close(); races.close();
    }
    private void processRaces() throws IOException {
        String line = races.readLine();
        while(line != null){
            processRaces(line);
            line = races.readLine();
        }
    }

    private void processRaces(String line) throws IOException {
        StringTokenizer tk = new StringTokenizer(line, ",");
        int i = 0;
        while(tk.hasMoreTokens() && i< POINTS.length){
            int id = Integer.parseInt(tk.nextToken());
            Pilot p = pilots.read(id);
            p.setFinished(p.getFinished()+1);
            p.setPoints(p.getPoints()+POINTS[i]);
            
            pilots.write(p);
            i++;
        }

    }


}
