package step3.view;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Winners;

public class OutputView {
    private static final String POSITION_OF_CAR = "-";

    public void showResultTitle() {
        System.out.println("실행 결과");
    }

    public void showResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCars(car);
        }
        printEmptyLine();
    }

    public void printWinners(Winners winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private void printCars(Car car) {
        printCarName(car.getCarName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_OF_CAR);
        }
        printEmptyLine();
    }

    private void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
