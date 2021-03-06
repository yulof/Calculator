import javax.swing.*;

public class GUI extends JFrame {

    private double num1, num2;
    private char operation = ' ';

    private JPanel panel;
    private JLabel label, miniLabel;
    private JButton C, sign, percentage, decimal, equal, add, subtract, multiplication, division,
            zero, one, two, three, four, five, six, seven, eight, nine, back;

    private GUI() {
        super("Calculadora");
        setContentPane(panel);
        label.setFont(Display.font(label.getText()));

        C.addActionListener(e -> {
            setDisplay("0");
            miniLabel.setText(" ");
            num1 = 0;
            num2 = 0;
            operation = ' ';
        });

        back.addActionListener(e -> {
            if (isResult())
                miniLabel.setText(" ");

            setDisplay(Display.previousNumber(label.getText()));
        });

        percentage.addActionListener(e -> {
            if (!label.getText().equals("Error")) {
                if (isResult())
                    miniLabel.setText(" ");

                setDisplay(Display.result(Utilities.stringToDouble(label.getText()) / 100));
            }
        });

        division.addActionListener(e -> {
            if (operation != ' ')
                equal.doClick();

            operationButtonAction('/');
        });

        multiplication.addActionListener(e -> {
            if (operation != ' ')
                equal.doClick();

            operationButtonAction('*');
        });

        subtract.addActionListener(e -> {
            if (operation != ' ')
                equal.doClick();

            operationButtonAction('-');
        });

        add.addActionListener(e -> {
            if (operation != ' ')
                equal.doClick();

            operationButtonAction('+');
        });

        sign.addActionListener(e -> {
            if (!label.getText().equals("0") && !label.getText().equals("Error") && !Utilities.isZero(label.getText())) {
                if (isResult())
                    miniLabel.setText(" ");

                if (label.getText().charAt(0) != '-')
                    setDisplay("-" + label.getText());
                else
                    setDisplay(label.getText().replaceFirst("-", ""));
            }
        });

        decimal.addActionListener(e -> {
            if (!label.getText().contains(".") && !label.getText().equals("Error")) {
                if (isResult())
                    miniLabel.setText(" ");

                setDisplay(label.getText() + '.');
            }
        });

        equal.addActionListener(e -> {
            if (operation != ' ') {
                num2 = Utilities.stringToDouble(label.getText());

                miniLabel.setText(miniLabel.getText() + label.getText() + " =");
                setDisplay(Display.resultOfOperation(num1, num2, operation));

                operation = ' ';
            }
        });

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
    }

    private void numberButtonAction(String num) {
        if (this.operation == ' ')
            miniLabel.setText(" ");

        setDisplay(Display.addNumber(label.getText(), num));
    }

    private void operationButtonAction(char operation) {
        if (!label.getText().equals("Error")) {
            num1 = Utilities.stringToDouble(label.getText());
            this.operation = operation;

            miniLabel.setText(label.getText() + " " + operation + " ");
            setDisplay("0");
        }
    }

    private void setDisplay(String number){
        label.setText(number);
        label.setFont(Display.font(label.getText()));
    }

    private boolean isResult() {
        return miniLabel.getText().contains("=");
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