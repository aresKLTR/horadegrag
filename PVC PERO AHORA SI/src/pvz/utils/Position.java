package pvz.utils;

import java.util.Objects;

public class Position {
	private int row;
	private int col;
	
public Position(int row, int col) {
	this.row=row;
	this.col=col;
}

public int row() {
	return row;
}

public int col() {
	return col;
}
@Override
public int hashCode() {
	return Objects.hash(Integer.valueOf(col), Integer.valueOf(row));
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
	return col == other.col && row == other.row;
}
@Override
public String toString() {
	return "Position [row=" + row + ", col=" + col + "]";
}
public boolean isInsideBoard(int numRows, int numCols) { //nuevo
    return row >= 0 && row < numRows && col >= 0 && col < numCols;
}
}