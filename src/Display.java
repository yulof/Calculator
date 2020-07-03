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

    public static String previousNumber (String number){
        String result = Op.setSpacing(number.substring(0, number.length()-1), false);

        if(result.equals("") || result.equals("-"))
            return "0";
        else
            return result;
    }

}