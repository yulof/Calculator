import javax.swing.*;

public class GUI extends JFrame {

    private double num1, num2;
    private char operation;

    private JPanel panel;
    private JLabel label;
    private JButton C, sign, percentage, decimal, equal, add, subtract, multiplication, division,
                    zero, one, two, three, four, five, six, seven, eight, nine;

    private GUI() {
        super("Calculadora");
        setContentPane(panel);

        C.addActionListener(e -> {
            label.setText("0");
            num1 = 0; num2 = 0;
            operation = ' ';
        });

        sign.addActionListener(e -> {
            if (!label.getText().equals("0"))
                if (label.getText().charAt(0) != '-')
                    label.setText("-" + label.getText());
                else
                    label.setText(label.getText().replace("-", ""));
        });

        percentage.addActionListener(e -> label.setText(Display.showResult(Op.stringToDouble(label.getText()) / 100)));

        division.addActionListener(e -> operationButtonAction('/'));

        multiplication.addActionListener(e -> operationButtonAction('*'));

        subtract.addActionListener(e -> operationButtonAction('-'));

        add.addActionListener(e -> operationButtonAction('+'));

        equal.addActionListener(e -> {
            num2 = Op.stringToDouble(label.getText());

            switch (operation){
                case '+': label.setText(Display.showResult(num1 + num2)); break;
                case '-': label.setText(Display.showResult(num1 - num2)); break;
                case '*': label.setText(Display.showResult(num1 * num2)); break;
                case '/':
                    if (num2 != 0)
                        label.setText(Display.showResult(num1 / num2));
                    else
                        label.setText("Error");
                    break;
            }

            operation = ' ';
        });

        decimal.addActionListener(e -> {
            if (!label.getText().contains("."))
                label.setText(label.getText() + '.');
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
        if (Op.stringToDouble(label.getText()) != 0)
            label.setText(Display.showNumber(label.getText(), num));
        else
            label.setText(num);
    }

    private void operationButtonAction(char operation) {
        num1 = Op.stringToDouble(Op.quitSpacing(label.getText()));
        this.operation = operation;
        label.setText("0");
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