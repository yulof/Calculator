public class Spacing {

    public static String set(String number, boolean result) {
        if (number.contains("-"))
            return "-" + set(number.substring(1), result);

        String string = quit(number);

        if (!hasDecimals(string))
            return setSpacingIntegers(string, string.length() % 3);

        if (decimalsAreZero(string) && result) {
            return set(Utilities.longToString((long) Utilities.stringToDouble(number)), true);
        }

        if (decimalsAreZero(string) && !result) {
            return number;
        }

        return setSpacingDecimals(string, sizeOfIntegerPart(string) % 3);
    }

    private static String setSpacingDecimals(String string, int r) {
        int n = string.indexOf(".");
        String decimals = string.substring(n);

        return setSpacingIntegers(string.substring(0, n), r).concat(decimals);
    }

    private static String setSpacingIntegers(String string, int r) {
        if (string.length() <= 3)
            return string;

        String result = "";

        if (r != 0)
            result = string.substring(0, r).concat(",");

        while (r < string.length()) {
            result = result.concat(string.substring(r, r + 3));

            r = r + 3;
            if (r + 1 < string.length())
                result = result.concat(",");
        }

        return result;
    }

    public static String quit(String string) {
        return string.replaceAll(",", "");
    }

    public static String quitAll(String string) {
        return quit(string).replace(".", "").replace("-", "");
    }

    private static boolean hasDecimals(String string) {
        return string.contains(".");
    }

    private static boolean decimalsAreZero(String string) {
        int i = string.indexOf(".") + 1;
        boolean decimalsAreZero = true;

        while (i < string.length() && decimalsAreZero) {
            if (string.charAt(i) != '0')
                decimalsAreZero = false;

            i++;
        }

        return decimalsAreZero;
    }

    private static int sizeOfIntegerPart(String string) {
        return string.indexOf(".");
    }

}