package HomeWork02.CarPark;

import java.util.*;

public class CarPark {
    public static void main(String[] args) {
        List<Car> park = ParkFiller.init();
        Map<String, List<Car>> cars = SplitCar.split(park);
        for (String type : cars.keySet()) {
            System.out.println(type + " " + cars.get(type));
        }
    }

}
