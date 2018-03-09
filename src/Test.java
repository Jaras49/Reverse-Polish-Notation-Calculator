import java.util.ArrayDeque;
import java.util.List;

import ReversePolishNotationConverter.*;

interface Calculator {

    double calculate(String expression);
}

class ReversePolishNotationCalculator implements Calculator {

    @Override
    public double calculate(String expression) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] operators = expression.split(" ");
        

        for (String operator : operators ){
            double temp = 0;
            double x;
            double y;

            if(operator.equals("-") || operator.equals("+") ||
                    operator.equals("/") || operator.equals("*")){

                x = Double.parseDouble(stack.pop());
                y = Double.parseDouble(stack.pop());

                switch (operator){
                    case "+":
                        temp = y + x;
                        break;
                    case "-":
                        temp = y - x;
                        break;
                    case "*":
                        temp = y * x;
                        break;
                    case "/":
                        temp = y / x;
                        break;
                }
                stack.push(Double.toString(temp));
            }
            else
                stack.push(operator);
        }
        return Double.parseDouble(stack.pop());
    }
}

public class Test {

    public static void main(String[] args) {
        Calculator calculator = new ReversePolishNotationCalculator();
        ReversePolishNotationConverter converter = new ReversePolishNotationConverter();

        System.out.println(converter.convert("3 + 2 * 5"));
        double wyn = 2+3*5/6;
        System.out.println(wyn);


       System.out.println(calculator
                .calculate("2 3 + 5 6 / *")); //powinno zwrócić 25, bo ten zapis w "normalnej" notacji wygląda tak: (2+3)*5
       // System.out.println(calculator.calculate(
          //      "2 7 + 3 / 14 3 - 4 * + 2 /")); //powinno wypisać 23.5 bo ten zapis jest równoważny:  ((2+7)/3+(14-3)*4)/2

    }
}