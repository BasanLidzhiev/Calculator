import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionUtil {

    public static int getNumber(String expression, boolean isFirst) throws CalculatorException {
        String patternStr = "[-+/*]";
        Matcher matcher = Pattern.compile(patternStr).matcher(expression);
        String a;
        int number;
        if (isFirst && matcher.find()) {
            a = expression.substring(0, matcher.start()).trim();
        } else if (matcher.find()) {
            a = expression.substring(matcher.start() + 1).trim();
        } else throw new CalculatorException("Неверный формат выражения");
        return getNumberFromExpression(a);
    }

    private static int getNumberFromExpression(String b) throws CalculatorException {
        int number;
        if (b.contains("I") || b.contains("V") || b.contains("X"))
            number = Converter.romanToArabic(b);
        else number = Integer.parseInt(b);
        if (number >= 0 && number <= 10) {
            return number;
        } else throw new CalculatorException("Число a не в диапазоне 0-10");
    }

    public static boolean isRomanian(String expression, int result) throws CalculatorException {
        if (expression.contains("I") || expression.contains("V") || expression.contains("X")) {
            String romanianResult = Converter.arabicToRoman(result);
            System.out.println(romanianResult);
            return true;
        } else return false;
    }

}
