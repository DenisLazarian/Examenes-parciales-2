package parcial2_2020_21;

public class Duration {
    public static final int SIZE = 4 + 4;
    private final int hours; // 0 <= hours
    private final int minutes; // 0 <= minutes <= 59

    public Duration(int hours, int minutes) {
// Precondición: 0 <= hours && 0 <= minutes
        hours = hours + minutes / 60;
        minutes = minutes % 60;
        this.hours = hours;
        this.minutes = minutes;
    }

    public static Duration add(Duration d1, Duration d2) {
        Duration resu = new Duration(d1.hours+d2.hours, d1.minutes+ d2.minutes);
        return resu;
    }

    public void packDuration(byte[] record, int offset) {
// Empaqueta la información de una Duration en los bytes del
// registro record a partir de la posición offset (ocupando
// SIZE bytes). Como en PackUtils, suponemos que en el array
// existe suficiente espacio para empaquetar.
        throw  new UnsupportedOperationException("Not implemented yet");

    }

    public static Duration unpackDuration(byte[] record, int offset) {
// Desempaqueta la información de una Duration en los bytes
// del registro record a partir de la posición offset y que
// ocupan SIZE bytes y los devuelve en forma de una instancia
// de Duration. Como en PackUtils, suponemos que en el array
// existe suficiente espacio para desempaquetar.
        throw  new UnsupportedOperationException("Not implemented yet");
    }


    public String toString() {
// Devuelve un String con los datos de la duration
        return String.format("%dh:%dm", this.hours, this.minutes);
    }
}

