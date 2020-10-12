import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String expression;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) throws CalculatorException {
            this.expression = expression;
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }


    public void result() throws CalculatorException {
        validateExpression(expression);
        if (expression.contains("+")) {
            int result = sum(ExpressionUtil.getNumber(expression, true), ExpressionUtil.getNumber(expression,false));
            if (ExpressionUtil.isRomanian(expression, result)) return;
            System.out.println(result);
        } else if (expression.contains("-")) {
            int result = subtract(ExpressionUtil.getNumber(expression,true), ExpressionUtil.getNumber(expression,false));
            if (ExpressionUtil.isRomanian(expression, result)) return;
            System.out.println(result);
        } else if (expression.contains("*")) {
            int result = multiply(ExpressionUtil.getNumber(expression,true), ExpressionUtil.getNumber(expression,false));
            if (ExpressionUtil.isRomanian(expression, result)) return;
            System.out.println(result);
        } else if (expression.contains("/")) {
            int result = divide(ExpressionUtil.getNumber(expression,true), ExpressionUtil.getNumber(expression,false));
            if (ExpressionUtil.isRomanian(expression, result)) return;
            System.out.println(result);
        } else throw new CalculatorException();
    }

    private void validateExpression(String expression) throws CalculatorException {
        int[] arabicNumbers = {1,2,3,4,5,6,7,8,9,10};
        String[] romanianNumbers = {"I", "V", "X"};
        for (int i : arabicNumbers) {
            for (String s : romanianNumbers) {
                if (expression.contains(String.valueOf(i)) && expression.contains(s))
                    throw new CalculatorException("Неверный формат выражения");
            }
        }
    }

}
