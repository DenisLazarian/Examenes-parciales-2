package parcial2_2016_17;

import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Grader extends ConsoleProgram {
    private static final String STUDENTS = "students.dat";
    private static final String GRADES = "grades.txt";
    private RandomAccessFile students;
    private BufferedReader grades;
    public void run() {
        try {
            openFiles();
            grade();
            closeFiles();
        } catch (IOException ex) {
            println("Hi ha hagut un error");
        }
    }
    private void openFiles() throws IOException {
        students = new RandomAccessFile(STUDENTS, "rw");
        grades = new BufferedReader(new FileReader(GRADES));
    }

    private void closeFiles() throws IOException {
        students.close(); grades.close();
    }
    private Student read(long id) throws IOException {
        students.seek((id-1)*Student.SIZE);
        byte[] record = new byte[Student.SIZE];
        students.read(record);
        return Student.fromBytes(record);
    }
    private void write(Student p) throws IOException {
        students.seek((p.getId()-1)*Student.SIZE);
        byte[] record = p.toBytes();
        students.write(record);
    }

    private void grade() throws IOException {
        String line = grades.readLine();
        while(line != null){
            grade(line);
            line = grades.readLine();
        }
    }

    private void grade(String line) throws IOException{
        StringTokenizer st = new StringTokenizer(line, ",");
        long idAlumne = Long.parseLong(st.nextToken());
        Student s = read(idAlumne);
        while(st.hasMoreTokens()){
            int idAsign = Integer.parseInt(st.nextToken());
            float nota = Float.parseFloat(st.nextToken());
            s.setGrade(idAsign, nota);
        }
        write(s);
    }
}

