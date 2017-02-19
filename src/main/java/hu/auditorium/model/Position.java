package hu.auditorium.model;

import hu.auditorium.service.Resources;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Position {
    private static final int LEFT_SIDE = Resources.LEFT_SIDE;
    private static final int RIGHT_SIDE = Resources.RIGHT_SIDE;

    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean hasLeftNeighbour() {
        return column > LEFT_SIDE;
    }

    public boolean hasRightNeighbour() {
        return column < RIGHT_SIDE;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (column != other.column)
            return false;
        if (row != other.row)
            return false;
        return true;
    }

}
