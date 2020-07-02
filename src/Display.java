public class Display {

    public static String showNumber (String number){
        return Op.setSpacing(number, false);
    }

    public static String showResult (double number) {
        if (Op.isExponential(number))
            return String.valueOf(number);

        return Op.setSpacing(String.valueOf(number), true);
    }

}