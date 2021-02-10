package HomeWork15.Tractor;

public class Trator {

    int[] position = new int[]{0, 0};
    int[] field = new int[]{5, 5};
    Orientation orientation = Orientation.NORTH;
    MovingStrategy move;
    TurningStrategy turn;

    public void move(String command) {
        if (command == "F") {
            moveForwards();
        } else if (command == "T") {
            turnClockwise();
        }
    }

    public void moveForwards() {

        switch (orientation) {
            case NORTH:
                position = move.moveNorth();
                break;
            case EAST:
                position = move.moveEast();
                break;
            case SOUTH:
                position = move.moveSouth();
                break;
            case WEST:
                position = move.moveWest();
                break;
        }
        if (position[0] > field[0] || position[1] > field[1]) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        switch (orientation) {
            case NORTH:
                turn.turnFromNorthToEast();
                break;
            case EAST:
                turn.turnFromEastToSouth();
                break;
            case SOUTH:
                turn.turnFromSouthToWest();
                break;
            case WEST:
                turn.turnFromWestToNorth();
                break;
        }
    }

    public int getPositionX() {
        return position[0];
    }

    public int getPositionY() {
        return position[1];
    }

    public Orientation getOrientation() {
        return orientation;
    }

}