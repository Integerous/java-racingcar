package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차들이 생성되지 않았습니다.");
        }
        this.cars = new ArrayList<>(cars);
    }

    public static Cars of(CarNames carNames) {
        return new Cars(carNames.getCarNames()
                .stream()
                .map(Car::new)
                .collect(toList()));
    }

//    public Cars move() {
//        for (Car car : cars) {
//            car.move(RandomNumber.generate());
//        }
//        return new Cars(cars);
//    }

    public Cars move() {
        return new Cars(
                cars.stream()
                        .map(car -> car.move(RandomNumber.generate()))
                        .collect(toList()));
    }

    public int findWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
