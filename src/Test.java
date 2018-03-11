import com.calculator.*;
import com.reversepolishnotationconverter.ReversePolishNotationConverter;

public class Test {

    public static void main(String[] args) {
        Calculator calculator = new ReversePolishNotationCalculator();
        ReversePolishNotationConverter converter = new ReversePolishNotationConverter();

        System.out.println(converter.convert("3 + 2 * 5"));


       //System.out.println(calculator
                //.calculate("2 3 + 5 6 / *")); //powinno zwrócić 25, bo ten zapis w "normalnej" notacji wygląda tak: (2+3)*5
       // System.out.println(calculator.calculate(
          //      "2 7 + 3 / 14 3 - 4 * + 2 /")); //powinno wypisać 23.5 bo ten zapis jest równoważny:  ((2+7)/3+(14-3)*4)/2

    }
}