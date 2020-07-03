public class Op {
    //Operations with two operators
    public static String resultOfOperation(double num1, double num2, char operation){
        switch (operation){
            case '+': return Display.showResult(num1 + num2);
            case '-': return Display.showResult(num1 - num2);
            case '*': return Display.showResult(num1 * num2);
            case '/':
                if (num2 != 0)
                    return Display.showResult(num1 / num2);
                else
                    return "Error";
        }
        return "";
    }

    //Changing between data types
    public static double stringToDouble(String string) {
        if (string.equals(""))
            return 0;

        if (string.charAt(string.length() - 1) == 'E')
            return Double.parseDouble(quitSpacing(string.concat("1")));

        return Double.parseDouble(quitSpacing(string));
    }

    public static String longToString(long number) {
        return String.valueOf(number);
    }

    //Visual separation of numbers
    public static String setSpacing(String number, boolean result) {
        String string = quitSpacing(number);

        if (string.contains("-"))
            return "-" + setSpacing(number.substring(1), result);

        if (hasDecimals(string))
            if (decimalsAreZero(string) && result)
                string = longToString((long) stringToDouble(number));
            else if (!decimalsAreZero(string) && result)
                return setSpacingDecimals(string, sizeOfIntegerPart(string) % 3);
            else
                return number;

        return setSpacingIntegers(string, string.length() % 3);
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

        if (r != 0) {
            result = string.substring(0, r);
            result = result.concat(",");
        }

        while (r < string.length()) {
            result = result.concat(string.substring(r, r + 3));
            r = r + 3;
            if (r + 1 < string.length())
                result = result.concat(",");
        }

        return result;
    }

    public static String quitSpacing(String string) {
        return string.replaceAll(",", "");
    }

    private static String quitAll(String string) {
        return quitSpacing(string).replace(".", "").replace("-", "");
    }

    // Other operations
    public static boolean isExponential(double number) {
        return String.valueOf(number).contains("E");
    }

    public static int numberOfDigits(String string) {
        return Op.quitAll(string).length();
    }

    private static int sizeOfIntegerPart(String string){
        return string.indexOf(".");
    }

    private static boolean decimalsAreZero(String string) {
        if (hasDecimals(string)) {
            int i = string.indexOf(".") + 1;
            boolean decimalsAreZero = true;

            while (i < string.length() && decimalsAreZero) {
                if (string.charAt(i) != '0')
                    decimalsAreZero = false;

                i++;
            }

            return decimalsAreZero;
        }

        return false;
    }

    private static boolean hasDecimals(String string) {
        return string.contains(".");
    }

    public static boolean isZero (String string){
        String number = Op.quitSpacing(string);

        if (!number.contains(".") && !number.equals("0"))
            return false;

        boolean isZero = true;
        int i = 0;

        while (number.charAt(i) != '.' && isZero){
            if (number.charAt(i) != '0')
                isZero = false;

            i++;
        }

        return isZero;
    }

}