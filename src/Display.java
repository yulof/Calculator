public class Display {

    public static String showNumber (String current, String number) {
        if (Op.numberOfDigits(current) >= 16)
            return current;

        return Op.setSpacing(current.concat(number), false);
    }

    public static String showResult (double number) {
        if (Op.isExponential(number))
            return String.valueOf(number);

        return Op.setSpacing(String.valueOf(number), true);
    }

}