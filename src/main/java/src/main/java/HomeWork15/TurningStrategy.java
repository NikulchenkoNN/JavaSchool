package HomeWork15;

public class TurningStrategy implements Turn{
    Orientation orientation;
    @Override
    public void turnFromNorthToEast() {
        orientation = Orientation.EAST;
    }

    @Override
    public void turnFromEastToSouth() {
        orientation = Orientation.SOUTH;
    }

    @Override
    public void turnFromWestToNorth() {
        orientation = Orientation.NORTH;
    }

    @Override
    public void turnFromSouthToWest() {
        orientation = Orientation.WEST;
    }
}
