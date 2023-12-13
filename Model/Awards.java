package Model;

import java.util.Arrays;
import java.util.Objects;

public class Awards {
    private Trophy[] trophies;

    public Awards(Trophy[] trophies) {
        this.trophies = trophies;
    }

    public Awards() {
        this(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Awards awards = (Awards) o;
        return Arrays.equals(trophies, awards.trophies);
    }

    @Override
    public String toString() {
        return "Awards{" +
                "trophies=" + Arrays.toString(trophies) +
                '}';
    }

    public Trophy[] getTrophies() {
        return trophies;
    }

    public void setTrophies(Trophy[] trophies) {
        this.trophies = trophies;
    }

    /**
     * Este método no recibe nada, crea un array de
     * 5 trofeos y genera unos trofeos determinados
     */
    public void createTrophies() {
        this.trophies = new Trophy[5];
        iniciateTrophies();
        this.trophies[0].setValue(1000);
        this.trophies[1].setValue(2000);
        this.trophies[2].setValue(3000);
        this.trophies[3].setValue(4000);
        this.trophies[4].setValue(10000);
        for (int i = 0; i < trophies.length; i++) {
            this.trophies[i].setFigure(trophyRepresent(this.trophies[i].getValue()));
        }
    }

    /**
     * Este método inicializa los trofeos del
     * array de trofeos a unos valores por defecto.
     */
    public void iniciateTrophies(){
        for (int i = 0; i < this.trophies.length; i++) {
            this.trophies[i]=new Trophy("",1);
        }
    }

    /**
     * Este método recibe un valor entero y devuelve un
     * string con la figura de un trofeo con el valor entero representado
     * @param value Recibe un valor entero que es el valor del trofeo
     * @return Devuelve la figura en forma de String con el valor representado
     */
    public String trophyRepresent(int value) {
        String trophy = "";
        if (value < 10000) {
            trophy = "\\             /\n" +
                    " \\           /\n" +
                    "  \\_________/\n" +
                    "  |   " + value + "  |\n" +
                    "  |_________|\n" +
                    "  /         \\ \n" +
                    " /___________\\\n" +
                    "|    TROPHY   |\n" +
                    "|_____________|";
        } else {
            trophy = "\\             /\n" +
                    " \\           /\n" +
                    "  \\_________/\n" +
                    "  |  " + value + "  |\n" +
                    "  |_________|\n" +
                    "  /         \\ \n" +
                    " /___________\\\n" +
                    "|    TROPHY   |\n" +
                    "|_____________|";
        }
        return trophy;
    }

    /**
     * Este método asigna un valor por defecto a la figura del trofeo insertado por parámetro
     * @param trophyToRemove Recibe un trofeo que queremos eliminar.
     */
    public void removeTrophy(Trophy trophyToRemove) {
        for (int i = 0; i < this.trophies.length; i++) {
            if (trophyToRemove.getValue() == trophies[i].getValue() &&
                    Objects.equals(trophyToRemove.getFigure(), trophies[i].getFigure())) {
                this.trophies[i].setFigure("");
            }
        }
    }
}
