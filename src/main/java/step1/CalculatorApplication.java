package step1;

import java.util.Scanner;

public class CalculatorApplication {

    private Validator validator = new Validator();

    public static void main(String[] args) {

        CalculatorApplication app = new CalculatorApplication();
        System.out.println("연산하고 싶은 문자열을 입력하세요.");

        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();

        String result = app.runCalculatorApplication(inputString);
        System.out.println("연산 결과 : " + result);
    }

    public String runCalculatorApplication(String inputString) {

        try {
            validator.stringValidation(inputString);
            return operate(inputString);

        } catch (IllegalArgumentException e) {
            return "공백을 입력하셨거나, 연산자 기호가 아닌 기호를 입력하셨습니다.";
        } catch (ArithmeticException e) {
            return "0으로 나눌 수 없습니다.";
        }
    }

    public String operate(String inputString) {

        String[] inputElements = inputString.split(" ");
        int calculationResult = Integer.parseInt(inputElements[0]);

        for(int i=1; i<inputElements.length; i+=2) {
            validator.operatorTypeValidation(inputElements[i]);
            calculationResult = calculate(inputElements[i], calculationResult, inputElements[i+1]);
        }
        return String.valueOf(calculationResult);
    }

    public int calculate(String operator, int leftValue, String rightValueInString) {

        int rightValue = Integer.parseInt(rightValueInString);

        if("+".equals(operator)) return Calculator.add(leftValue, rightValue);
        if("-".equals(operator)) return Calculator.subtract(leftValue, rightValue);
        if("*".equals(operator)) return Calculator.multiple(leftValue, rightValue);
        if("/".equals(operator)) return Calculator.divide(leftValue, rightValue);

        return -1;
    }





}
