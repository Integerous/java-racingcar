package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static Cars makeCars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }
}