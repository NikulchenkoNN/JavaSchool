package HomeWork02.CarPark;

import java.util.*;
import java.util.stream.Collectors;

public class SplitCar {
    public static Map<String, List<Car>> split(List<Car> list) {
        Set<String> types = new HashSet<>();
        for (Car car : list) {
            types.add(car.getType());
        }

        Map<String, List<Car>> map = new HashMap<>();
        for (String type : types) {
            List<Car> oneType = new ArrayList<>();
            for (Car car : list) {
                if (car.getType().equals(type)) {
                    oneType.add(car);
                }
            }
            map.put(type, oneType);
        }
        return map;
    }
}
