package step4.controller;


import step4.domain.Cars;
import step4.domain.ResultSheet;
import step4.domain.Round;
import step4.domain.Winners;
import step4.view.InputView;
import step4.view.OutputView;

public class CarRaceController {

    public static void main(String[] args) {
        CarRaceController controller = new CarRaceController();
        controller.readyRace();
    }

    private void readyRace() {
        Cars newCars = Cars.of(InputView.getCarNames());
        Round round = InputView.getRound();
        startRace(newCars, round);
    }

    private void startRace(Cars cars, Round round) {
        ResultSheet resultSheet = new ResultSheet();
        for (int i = 0; i < round.getRound(); i++) {
            resultSheet.addResult(cars.move());
        }
        wrapUpRace(resultSheet, round);
    }

    private void wrapUpRace(ResultSheet raceResult, Round round) {
        OutputView.readResultSheet(raceResult);
        Cars lastRoundResult = raceResult.getLastRoundResult(round);
        OutputView.printWinners(Winners.from(lastRoundResult));
    }
}