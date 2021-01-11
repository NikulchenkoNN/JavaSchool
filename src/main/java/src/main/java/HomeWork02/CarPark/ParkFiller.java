package HomeWork02.CarPark;

import java.util.ArrayList;
import java.util.List;

public class ParkFiller {
    public static List<Car> init() {
        List<Car> park = new ArrayList<>();
        park.add(new Car("Lada", "sedan"));
        park.add(new Car("Lada", "hatchback"));
        park.add(new Car("Mercedes", "sedan"));
        park.add(new Car("BMW", "sedan"));
        park.add(new Car("Ford", "hatchback"));
        park.add(new Car("Ford", "sedan"));
        park.add(new Car("Mercedes", "crossover"));
        park.add(new Car("Peugeot", "sedan"));
        return park;
    }
}
