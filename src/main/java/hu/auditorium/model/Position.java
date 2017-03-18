package hu.auditorium.model;

import hu.auditorium.view.Resources;

/**
 * @author Peter_Fazekas on 2017.02.19..
 */
public class Position {

    private final int row;
    private final int column;

    public Position(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public boolean hasLeftNeighbour() {
        return column > Resources.LEFT_SIDE;
    }

    public boolean hasRightNeighbour() {
        return column < Resources.RIGHT_SIDE;
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
    public boolean equals(final Object obj) {
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
