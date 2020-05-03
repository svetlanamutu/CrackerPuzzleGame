package com.trainingUNT;

public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public String toString() {
        return "[" + row + "," + col + "]";
    }

    public int hashCode() {
        int result = 2;

        result = 3*result + row;
        result = 3*result + col;

        return result;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;

        if (this.row != that.row)
            return false;

        return this.col == that.col;
    }
}
