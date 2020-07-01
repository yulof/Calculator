import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{

    private JPanel panel;
    private JButton C;
    private JButton sign;
    private JButton percentage;
    private JButton division;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton multiplication;
    private JButton subtract;
    private JButton add;
    private JButton decimal;
    private JButton zero;
    private JButton equal;
    private JLabel label;

    private float num1, num2;
    private char operation;

    public GUI() {
        super("Calculadora");
        setContentPane(panel);

        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("0");
            }
        });

        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("1");
            }
        });

        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("2");
            }
        });

        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("3");
            }
        });

        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("4");
            }
        });

        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("5");
            }
        });

        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("6");
            }
        });

        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("7");
            }
        });

        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("8");
            }
        });

        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberButtonAction("9");
            }
        });

        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("0");
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationButtonAction('+');
            }
        });

        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationButtonAction('-');
            }
        });

        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationButtonAction('*');
            }
        });

        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationButtonAction('/');
            }
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Float.parseFloat(label.getText());

                if (operation == '+')
                    label.setText(String.valueOf(num1+num2));

                if (operation == '-')
                    label.setText(String.valueOf(num1-num2));

                if (operation == '*')
                    label.setText(String.valueOf(num1*num2));

                if (operation == '/')
                    label.setText(String.valueOf(num1/num2));
            }
        });

    }

    private void numberButtonAction(String num){
        if(!label.getText().equals("0"))
            label.setText(label.getText() + num);
        else
            label.setText(num);
    }

    private void operationButtonAction(char operation){
        num1 = Float.parseFloat(label.getText());
        this.operation = operation;
        label.setText("0");
    }

    public static void view() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new GUI();
                frame.setSize(340, 480);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            }
        });
    }



}