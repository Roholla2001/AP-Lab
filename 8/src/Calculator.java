import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;


public class Calculator extends JFrame {
    private JTextArea screen;
    private JPanel basic;
    private JPanel advanced;

    private double first, second;
    private double result;
    private Operator operator;

    private JButton[][] buttons;

    private JButton plus;
    private JButton minus;
    private JButton multiply;
    private JButton divide;
    private JButton mod;


    private JButton equal;

    public Calculator() {
        super("Calculator");
        setBounds(800, 200, 300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        makeDigitButtons();
        makeOperatorButtons();
        makeBasic();
        makeAdvanced();
        makeScreen();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(basic, "Basic");
        tabbedPane.add(advanced, "Advanced");
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Dimension size = tabbedPane.getPreferredSize();
        size.height += 200;
        tabbedPane.setPreferredSize(size);


        add(tabbedPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void makeBasic() {
        basic = new JPanel(new GridLayout(4, 4));

        buttons[0][3] = plus;
        buttons[1][3] = minus;
        buttons[2][3] = multiply;
        buttons[3][0] = equal;
        buttons[3][2] = mod;
        buttons[3][3] = divide;

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                basic.add(buttons[i][j]);



    }

    public void makeAdvanced() {
        advanced = new JPanel();
    }

    public void makeScreen() {
        screen = new JTextArea();
        screen.setFont(new Font("Arial", 4, 30));
        Dimension size = screen.getPreferredSize();
        size.height += 20;
        screen.setPreferredSize(size);

        JScrollPane scroll = new JScrollPane(screen);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(scroll, BorderLayout.NORTH);
    }

    public void makeDigitButtons() {
        buttons = new JButton[6][6];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int digit = 3 * i + j + 1;
                JButton butt = new JButton("" + digit);
                butt.addActionListener(digitListener(digit));
                buttons[i][j] = butt;
            }

        int digit = 0;
        JButton butt = new JButton("" + digit);
        butt.addActionListener(digitListener(digit));
        buttons[3][1] = butt;
    }

    public void makeOperatorButtons() {
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        mod = new JButton("%");
        equal = new JButton("=");

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = Operator.PLUS;
                screen.append(" + ");
            }
        });

        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = Operator.MINUS;
                screen.append(" - ");
            }
        });

        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = Operator.MULTIPLY;
                screen.append(" * ");
            }
        });

        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = Operator.DIVIDE;
                screen.append(" / ");
            }
        });

        mod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operator = Operator.MOD;
                screen.append(" % ");
            }
        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(operator) {
                    case PLUS:
                        result = first + second;
                        break;
                    case MINUS:
                        result = first - second;
                        break;
                    case MULTIPLY:
                        result = first * second;
                        break;
                    case DIVIDE:
                        result = first / second;
                        break;
                    case MOD:
                        result = first % second;
                        break;


                }
                screen.append(" = " + result);
            }
        });



    }

    public ActionListener digitListener(int digit) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen.append("" + digit);
                if(operator == null)
                    first = first * 10 + digit;
                else
                    second = second * 10 + digit;
            }
        };
        return listener;
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
