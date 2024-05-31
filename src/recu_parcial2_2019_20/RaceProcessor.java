package recu_parcial2_2019_20;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RaceProcessor extends CommandLineProgram {

    private static final String RACE = "race.csv";
    private static final String RUNNERS = "runners.dat";
    private Participants participants;
    private BufferedReader race;
    public void run() {
        try {
            openFiles();
            processRace();
            closeFiles();
        } catch (IOException ex) {
            println("Houston, Houston, we have a problem");
        }
    }
    private void openFiles() throws IOException {
        participants = new Participants(RUNNERS);
        race = new BufferedReader(new FileReader(RACE));
    }
    private void closeFiles() throws IOException {
        participants.close(); race.close();
    }
    private void processRace() throws IOException {
        String line = race.readLine();
        while(line != null){
            processRace(line);
            line = race.readLine();
        }
    }

    public void processRace(String line) throws IOException {
        StringTokenizer st = new StringTokenizer(line, ";");
        String mode = st.nextToken();

        if(mode == "TIEMPOS"){
            processTime(st);
        }else{
            processClasifications(st);
        }
    }

    private void processClasifications(StringTokenizer st) throws IOException {
        while(st.hasMoreTokens()){
            long id = Long.parseLong(st.nextToken());
            if(exist(id)){
                Runner r = participants.read(id);
                println(r.toString());
            }else{
                println("El corredor con id "+id+" no existe.");
            }
        }
    }

    private void processTime(StringTokenizer st) throws IOException {
        long id = Long.parseLong(st.nextToken());
        if(exist(id)){
            Runner r = participants.read(id);
            while(st.hasMoreTokens()){
                int h = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                r.addFinished(new Duration(h,m));
            }
            participants.write(r);
        }

    }

    private boolean exist(long id) throws IOException {
        return participants.numRunners() <= id && id>=0;
    }

}
