package HomeWork15.Tractor;

public class MovingStrategy implements Move {
    int[] position = new int[]{0, 0};

    @Override
    public int[] moveNorth() {
        return new int[]{position[0], position[1] + 1};
    }

    @Override
    public int[] moveSouth() {
        return new int[]{position[0], position[1] - 1};
    }

    @Override
    public int[] moveEast() {
        return new int[]{position[0] + 1, position[1]};
    }

    @Override
    public int[] moveWest() {
        return new int[]{position[0] - 1, position[1]};
    }
}
