package Model;

import java.util.Objects;

public class Trophy {
    private String figure;
    private int value;

    public Trophy(String figure, int value) {
        this.figure = figure;
        this.value = value;
    }

    public Trophy() {
        this("",0);
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trophy trophy = (Trophy) o;
        return Objects.equals(figure, trophy.figure);
    }

    @Override
    public String toString() {
        return figure;
    }
}
