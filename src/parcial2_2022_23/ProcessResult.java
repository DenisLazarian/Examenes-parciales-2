package parcial2_2022_23;

import acm.program.CommandLineProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProcessResult extends CommandLineProgram {

    private static final String TEAMS = "teams.dat";
    private static final String RESULTS = "results.csv";
    private League league;
    private BufferedReader results;
    public void run() {
        try {
            openFiles();
            processResults();
            closeFiles();
        } catch (IOException ex) {
            println("Error");
        }
    }
    private void openFiles() throws IOException {
        league = new League(TEAMS);
        results = new BufferedReader(new FileReader(RESULTS));
    }
    private void closeFiles() throws IOException {
//        league.close(); results.close();
    }
    private void processResults() throws IOException {
        String line = results.readLine();
        while(line != null){
            processResults(line);
            line = results.readLine();
        }
// Trata las líneas del fichero de resultados, actualizando los
// equipos del fichero de equipos en función de los resultados.
// Debéis descomponerlo en métodos auxiliares.
    }

    private void processResults(String line) throws  IOException{
        StringTokenizer st = new StringTokenizer(" ", line);
        long id1 = Long.parseLong(st.nextToken());
        long id2 = Long.parseLong(st.nextToken());
        int goals1 = Integer.parseInt(st.nextToken());
        int goals2 = Integer.parseInt(st.nextToken());


        if(isValidData(id1, id2, goals1, goals2)){
            Team t1 = league.readTeam(Long.parseLong(st.nextToken()));
            Team t2 = league.readTeam(Long.parseLong(st.nextToken()));

            t1.addGameResult(goals1, goals2);
            t2.addGameResult(goals2, goals1);

            league.writeTeam(t1);
            league.writeTeam(t2);
        }
    }

    private boolean isValidData(long t1, long t2, int goals1, int goals2) throws IOException {
        return league.exists(t1) && league.exists(t2) && goals1 >= 0 && goals2 >= 0;
    }


    public static void main(String[] args) {
        new ProcessResult().start(args);
    }
}
