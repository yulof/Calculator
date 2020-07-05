import java.awt.*;

public class Display {

    public static String addNumber(String current, String number) {
        if (current.equals("0"))
            return number;

        if (Utilities.realSize(current) >= 16 || current.equals("Error") || Utilities.isExponential(Utilities.stringToDouble(current)))
            return current;

        if (Utilities.isZero(current))
            return current + number;

        return Spacing.set(current.concat(number), false);
    }

    public static String result(double number) {
        if (Utilities.isExponential(number))
            return Utilities.doubleToString(number);

        return Spacing.set(Utilities.doubleToString(number), true);
    }

    public static String previousNumber(String number) {
        if (number.equals("Error"))
            return "0";

        if (number.contains("E"))
            return number.substring(0, number.indexOf("E"));

        String previous = Spacing.set(number.substring(0, number.length() - 1), false);

        if (previous.contains("-") && Utilities.isZero(previous.substring(1)))
            return previous.substring(1);

        if (previous.equals("") || previous.equals("-"))
            return "0";

        return previous;
    }

    public static String resultOfOperation(double num1, double num2, char operation) {
        switch (operation) {
            case '+':
                return Display.result(num1 + num2);
            case '-':
                return Display.result(num1 - num2);
            case '*':
                return Display.result(num1 * num2);
            case '/':
                if (num2 != 0) return Display.result(num1 / num2);
            default:
                return "Error";
        }
    }

    public static Font font(String string){
        if (string.length() >= 20)
            return new Font("Segoe UI", Font.PLAIN, 26);

        if (string.length() >= 16)
            return new Font("Segoe UI", Font.PLAIN, 30);

        return new Font("Segoe UI", Font.PLAIN, 36);
    }

}