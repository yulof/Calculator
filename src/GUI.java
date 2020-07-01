import javax.swing.*;

public class GUI extends JFrame{

    private JPanel panel;

    private JButton C, sign, percentage;
    private JButton decimal, equal;
    private JButton add, subtract, multiplication, division;
    private JButton zero, one, two, three, four, five, six, seven, eight, nine;

    private JLabel label;

    private float num1, num2;
    private char operation;
    private boolean result;

    private GUI() {
        super("Calculadora");
        setContentPane(panel);

        zero.addActionListener(e -> numberButtonAction("0"));

        one.addActionListener(e -> numberButtonAction("1"));

        two.addActionListener(e -> numberButtonAction("2"));

        three.addActionListener(e -> numberButtonAction("3"));

        four.addActionListener(e -> numberButtonAction("4"));

        five.addActionListener(e -> numberButtonAction("5"));

        six.addActionListener(e -> numberButtonAction("6"));

        seven.addActionListener(e -> numberButtonAction("7"));

        eight.addActionListener(e -> numberButtonAction("8"));

        nine.addActionListener(e -> numberButtonAction("9"));

        C.addActionListener(e -> {
            label.setText("0");
            result = false;
        });

        add.addActionListener(e -> operationButtonAction('+'));

        subtract.addActionListener(e -> operationButtonAction('-'));

        multiplication.addActionListener(e -> operationButtonAction('*'));

        division.addActionListener(e -> operationButtonAction('/'));

        sign.addActionListener(e -> {
            if (!label.getText().equals("0"))
                if (label.getText().charAt(0) != '-')
                    label.setText("-" + label.getText());
                else
                    label.setText(label.getText().replace("-", ""));
        });

        decimal.addActionListener(e -> {
            if (!label.getText().contains("."))
                label.setText(label.getText() + '.');
        });

        percentage.addActionListener(e -> label.setText(String.valueOf(Float.parseFloat(label.getText())/100)));

        equal.addActionListener(e -> {
            num2 = Float.parseFloat(label.getText());

            if (operation == '+')
                label.setText(result(num1+num2));

            if (operation == '-')
                label.setText(result(num1-num2));

            if (operation == '*')
                label.setText(result(num1*num2));

            if (operation == '/')
                if(num2!=0)
                    label.setText(result(num1/num2));
                else
                    label.setText("Error");

            operation = ' ';
            result = true;
        });

    }

    private void numberButtonAction(String num){
        if(!label.getText().equals("0"))
            label.setText(addNumber(label.getText(), num));
        else
            label.setText(num);
    }

    private String addNumber (String string, String number){
        if (result){
            result = false;
            return number;
        } else
            return string + number;
    }

    private void operationButtonAction(char operation){
        num1 = Float.parseFloat(label.getText());
        this.operation = operation;
        label.setText("0");
    }

    private String result(float number){
        if (number % 1 == 0)
            return String.valueOf(((int) number));
        else
            return String.valueOf(number);
    }

    public static void view() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new GUI();
            frame.setSize(340, 480);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
        });
    }

}