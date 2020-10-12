import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws CalculatorException {


        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        while (true) {
            System.out.println("Введите выражение");
            String expression = scanner.nextLine();
            if (expression.equals("end")) break;
            calculator.setExpression(expression);
            calculator.result();
        }

    }
}
