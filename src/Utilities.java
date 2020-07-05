public class Utilities {

    public static double stringToDouble(String string) {
        if (string.equals("Error"))
            return 0;

        return Double.parseDouble(Spacing.quit(string));
    }

    public static String longToString(long number) {
        return String.valueOf(number);
    }

    public static String doubleToString(double number) {
        return String.valueOf(number);
    }

    public static boolean isExponential(double number) {
        return String.valueOf(number).contains("E");
    }

    public static int realSize(String string) {
        return Spacing.quitAll(string).length();
    }

    public static int sizeOfIntegerPart(String string) {
        return string.indexOf(".");
    }

    public static boolean decimalsAreZero(String string) {
        int i = string.indexOf(".") + 1;
        boolean decimalsAreZero = true;

        while (i < string.length() && decimalsAreZero) {
            if (string.charAt(i) != '0')
                decimalsAreZero = false;

            i++;
        }

        return decimalsAreZero;
    }

    public static boolean hasDecimals(String string) {
        return string.contains(".");
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