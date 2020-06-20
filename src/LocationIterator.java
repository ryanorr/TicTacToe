import java.util.Iterator;

public class LocationIterator implements Iterator<Location> {
    private int rowIncrement, colIncrement, size;
    private Location current;

    LocationIterator(Location l, int rowIncrement, int colIncrement, int size) {
        this.rowIncrement = rowIncrement;
        this.colIncrement = colIncrement;
        this.size = size;
        current = new Location(l.row - rowIncrement, l.col - colIncrement);
    }

    @Override
    public boolean hasNext() {
        return current.row + rowIncrement < size && current.col + colIncrement < size;
    }

    @Override
    public Location next() {
        current = new Location(current.row + rowIncrement, current.col + colIncrement);
        return current;
    }
}
