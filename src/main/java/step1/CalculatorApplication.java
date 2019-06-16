package step1;

import spark.utils.StringUtils;

import java.util.Scanner;

public class CalculatorApplication {

    public static void main(String[] args) {

        System.out.println("연산하고 싶은 문자열을 입력하세요.");

        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();

        String result = operateCalculator(inputString);
        System.out.println("연산 결과 : " + result);
    }

    public static String operateCalculator(String inputString) {

        try {
            stringValidation(inputString);
            String[] inputElements = inputString.split(" ");
            int calculationResult = Integer.parseInt(inputElements[0]);

            for(int i=1; i<inputElements.length; i+=2) {
                operatorTypeValidation(inputElements[i]);
                calculationResult = calculate(inputElements[i], calculationResult, inputElements[i+1]);
            }
            return String.valueOf(calculationResult);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "공백을 입력하셨거나, 연산자 기호가 아닌 기호를 입력하셨습니다.";
        } catch (ArithmeticException e) {
            e.printStackTrace();
            return "0으로 나눌 수 없습니다.";
        }
    }

    public static int calculate(String operator, int leftValue, String rightValueInString) {

        int rightValue = Integer.parseInt(rightValueInString);

        if("+".equals(operator)) return Calculator.add(leftValue, rightValue);
        if("-".equals(operator)) return Calculator.subtract(leftValue, rightValue);
        if("*".equals(operator)) return Calculator.multiple(leftValue, rightValue);
        if("/".equals(operator)) return Calculator.divide(leftValue, rightValue);

        return -1;
    }

    public static void stringValidation(String inputString) {
        if(StringUtils.isEmpty(inputString)) {
            throw new IllegalArgumentException();
        }
    }

    public static void operatorTypeValidation(String inputType) {
        if(!"+".equals(inputType)
                && !"-".equals(inputType)
                && !"*".equals(inputType)
                && !"/".equals(inputType)) {
            throw new IllegalArgumentException();
        }
    }



}
