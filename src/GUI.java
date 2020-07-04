import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private double num1, num2;
    private char operation = ' ';

    private JPanel panel;
    private JLabel label;
    private JButton C, sign, percentage, decimal, equal, add, subtract, multiplication, division,
            zero, one, two, three, four, five, six, seven, eight, nine, back;

    private GUI() {
        super("Calculadora");
        setContentPane(panel);
        label.setFont(Display.font(label.getText()));

        C.addActionListener(e -> {
            label.setText("0");
            num1 = 0;
            num2 = 0;
            operation = ' ';
            label.setFont(Display.font(label.getText()));
        });

        back.addActionListener(e -> {
            label.setText(Display.previousNumber(label.getText()));
            label.setFont(Display.font(label.getText()));
        });

        percentage.addActionListener(e -> {
            label.setText(Display.result(Utilities.stringToDouble(label.getText()) / 100));
            label.setFont(Display.font(label.getText()));
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
            if (!label.getText().equals("0"))
                if (label.getText().charAt(0) != '-')
                    label.setText("-" + label.getText());
                else
                    label.setText(label.getText().replace("-", ""));

            label.setFont(Display.font(label.getText()));
        });

        decimal.addActionListener(e -> {
            if (!label.getText().contains("."))
                label.setText(label.getText() + '.');

            label.setFont(Display.font(label.getText()));
        });

        equal.addActionListener(e -> {
            if (operation != ' ') {
                num2 = Utilities.stringToDouble(label.getText());

                label.setText(Display.resultOfOperation(num1, num2, operation));
                operation = ' ';
                label.setFont(Display.font(label.getText()));
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
        if (label.getText().equals("0"))
            label.setText(num);
        else
            label.setText(Display.addNumber(label.getText(), num));

        label.setFont(Display.font(label.getText()));
    }

    private void operationButtonAction(char operation) {
        num1 = Utilities.stringToDouble(label.getText());
        this.operation = operation;
        label.setText("0");
        label.setFont(Display.font(label.getText()));
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