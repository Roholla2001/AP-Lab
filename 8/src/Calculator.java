import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.*;

/**
 * A calculator GUI that can be used with both its keypad and the keyboard
 */
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

    private JButton sinCos;
    private JButton tanCot;
    private JButton exp;
    private JButton log;
    private JButton pi;
    private JButton e;
    private JButton shift;

    private boolean isShiftOn;


    private JButton equal;

    /**
     * Construct and build new Calculator
     */
    public Calculator() {
        super("Calculator");
        setBounds(800, 200, 300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        makeDigitButtons();
        makeOperatorButtons();
        makeBasic();
//        makeAdvanced();
        makeScreen();
        makeTabbedPane();

        
        setFocusable(true);
        setVisible(true);
    }

    /**
     * Make a basic calculator
     */
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

    /**
     * Make an advanced calculator
     */
    public void makeAdvanced() {
        advanced = new JPanel(new GridLayout(5, 5));

        buttons[0][3] = plus;
        buttons[1][3] = minus;
        buttons[2][3] = multiply;
        buttons[3][0] = equal;
        buttons[3][2] = mod;
        buttons[3][3] = divide;

        buttons[0][4] = sinCos;
        buttons[1][4] = tanCot;
        buttons[2][4] = exp;
        buttons[3][4] = log;
        buttons[4][4] = pi;
        buttons[4][3] = e;
        buttons[4][2] = shift;
        buttons[4][0] = new JButton("");
        buttons[4][1] = new JButton("");

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                advanced.add(buttons[i][j]);


    }

    /**
     * Make the
     */
    public void makeScreen() {
        screen = new JTextArea();
        screen.setEditable(false);
        screen.setFont(new Font("Arial", 4, 30));
        Dimension size = screen.getPreferredSize();
        size.height += 20;
        screen.setPreferredSize(size);

        JScrollPane scroll = new JScrollPane(screen);
        scroll.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(scroll, BorderLayout.NORTH);
    }

    /**
     * Creat the buttons with digits
     */
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

    /**
     * Create the buttons with operation
     */
    public void makeOperatorButtons() {
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        mod = new JButton("%");
        equal = new JButton("=");

        sinCos = new JButton("SIN/cos");
        tanCot = new JButton("TAN/cot");
        exp = new JButton("exp");
        log = new JButton("log");
        pi = new JButton("Pi");
        e = new JButton("e");
        shift = new JButton("Shift");



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

//        sinCos.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setResult();
//                if(isShiftOn)
//                    operator = Operator.COS;
//                else
//                    operator = Operator.SIN;
//                setResult();
//
//            }
//        });
//
//        tanCot.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setResult();
                screen.append(" = " + result);
            }
        });



    }

    /**
     * Adds a Menubar to this frame
     */
    public void makeMenubar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('M');
        menuBar.add(menu);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(exit);
    }

    /**
     * Apply the operation on the entered numbers
     */
    public void setResult() {
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

            default:
                result = first;
        }
    }

    /**
     * Create an ActionListener that listens to a specific digit
     * @param digit the digit to be pressed
     * @return the ActionListener
     */
    public ActionListener digitListener(int digit) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressDigit(digit);
            }
        };
        return listener;
    }

    /**
     * Change the screen and the numbers according to the given digit
     * @param digit the given digit
     */
    public void pressDigit(int digit) {
        screen.append("" + digit);
        if(operator == null)
            first = first * 10 + digit;
        else
            second = second * 10 + digit;
    }

    /**
     * Make a tabbed pain and add the calculators to it
     */
    public void makeTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(basic, "Basic");
        tabbedPane.add(advanced, "Advanced");
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Dimension size = tabbedPane.getPreferredSize();
        size.height += 200;
        tabbedPane.setPreferredSize(size);


        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
