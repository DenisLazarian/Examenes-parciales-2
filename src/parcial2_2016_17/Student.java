package parcial2_2016_17;

import utils.PackUtils;

public class Student {
    public static final int NUM_SUBJECTS = 6; // número de asignaturas
    private static final int NAME_LIMIT = 20;
    public static final int SIZE = 8+NAME_LIMIT*2+4*NUM_SUBJECTS;

    private long id; // identificador
    private String name; // nombre
    private float[] grades; // notas

    public Student(long id, String name, float[] grades) {
// this.grades.length == NUM_SUBJECTS
// 0.0 <= grades[i] <= 10.0 for all index i in the array
        this.id = id; this.name = name; this.grades = grades;
    }
    public long getId() {
        return this.id;
    }
    public void setGrade(int idSubject, float grade) {
// 1 <= idSubject <= NUM_SUBJECTS && 0.0 <= grade <= 10.0
        grades[idSubject - 1] = grade;
    }
    public float getGrade(int idSubject) {
// 1 <= idSubject <= NUM_SUBJECTS
        return grades[idSubject - 1];
    }
    public byte[] toBytes() {
        int offset = 0;
        byte[] record = new byte[SIZE];
        PackUtils.packLong(id, record, offset);
        offset += 8;
        PackUtils.packLimitedString(name, NAME_LIMIT, record, offset);
        offset += NAME_LIMIT*2;

        for (int i = 0; i < NUM_SUBJECTS; i++) {
            PackUtils.packFloat(grades[i], record, offset);
            offset += 4;
        }
        return record;
    }
    public static Student fromBytes(byte[] record) {
        int offset = 0;
        long id = PackUtils.unpackLong(record, offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += NAME_LIMIT*2;

        float[] grades = new float[NUM_SUBJECTS];
        for (int i = 0; i < grades.length; i++) {
            grades[i] = PackUtils.unpackFloat(record, offset);
            offset += 4;
        }

        return new Student(id, name,grades);
    }
}
