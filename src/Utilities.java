public class Utilities {

    public static double stringToDouble(String string) {
        return Double.parseDouble(Spacing.quit(string));
    }

    public static String longToString(long number) {
        return String.valueOf(number);
    }

    public static String doubleToString(double number) {
        return String.valueOf(number);
    }

    public static boolean isZero(String string) {
        if (string.equals(""))
            return false;

        String number = Spacing.quitAll(string);
        boolean isZero = true;

        int i = 0;
        while (i < number.length() && isZero) {
            if (number.charAt(i) != '0')
                isZero = false;

            i++;
        }

        return isZero;
    }

}