package step3.view;

import java.util.Scanner;

public class InputView {
    private final static String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private final static String ASK_NUMBER_OF_TRIALS = "시도할 횟수는 몇 회 인가요?";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String getCarNames() {
        System.out.println(ASK_CAR_NAMES);
        return scanner.nextLine();
    }

    public int getNumberOfTrials() {
        System.out.println(ASK_NUMBER_OF_TRIALS);
        final int numberOfTrials = scanner.nextInt();
        scanner.close();
        printEmptyLine();
        return numberOfTrials;
    }

    private void printEmptyLine() {
        System.out.println();
    }
}