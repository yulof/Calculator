public class Spacing {

    public static String set(String number, boolean result) {
        if (number.contains("-"))
            return "-" + set(number.substring(1), result);

        String string = quit(number);

        if (!Utilities.hasDecimals(string))
            return setSpacingIntegers(string, string.length() % 3);

        if (Utilities.decimalsAreZero(string) && result) {
            return set(Utilities.longToString((long) Utilities.stringToDouble(number)), true);
        }

        if (Utilities.decimalsAreZero(string) && !result) {
            return number;
        }

        return setSpacingDecimals(string, Utilities.sizeOfIntegerPart(string) % 3);
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

}