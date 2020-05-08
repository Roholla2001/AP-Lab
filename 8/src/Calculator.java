import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

/**
 * A calculator GUI that can be used with both its keypad and the keyboard
 */
public class Calculator extends JFrame {

    private JTextArea screen;

    private JButton[] digitButts;
    private JButton[] operatorButts;

    private JButton equal;
    private JButton shift;

    private Model model;


    /**
     * Construct and build new Calculator
     */
    public Calculator() {
        super("Calculator");
        setBounds(800, 200, 300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        build();

        Listener listener = new Listener();
        setListener(listener, listener);

        setFocusable(true);
        setVisible(true);
    }

    public void build() {
        model = new Model();
        makeScreen();
        makeDigitButtons();
        makeOperatorButtons();
    }

    public void setListener(ActionListener actionListener, KeyListener keyListener) {
        for(int i = 0; i < 10; i++) {
            digitButts[i].addActionListener(actionListener);
            digitButts[i].addKeyListener(keyListener);
        }
        for (int i = 0; i < Operator.values().length; i++) {
            operatorButts[i].addActionListener(actionListener);
            operatorButts[i].addKeyListener(keyListener);
        }
        equal.addActionListener(actionListener);
        equal.addKeyListener(keyListener);
        shift.addActionListener(actionListener);
        shift.addKeyListener(keyListener);
    }


    /**
     * Make the screen
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
        digitButts = new JButton[10];

        JPanel digitsPanel = new JPanel(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            digitButts[i] = new JButton(i + "");
            if(i > 0)
                digitsPanel.add(digitButts[i]);
        }

        digitsPanel.add(digitButts[0]);

        add(digitsPanel, BorderLayout.CENTER);
    }

    /**
     * Create the buttons with operation
     */
    public void makeOperatorButtons() {
        JPanel basic = new JPanel(new GridLayout(5, 1));
        JPanel advanced = new JPanel(new GridLayout(15, 1));

        operatorButts = new JButton[15];

        for(int i = 0; i < Operator.values().length; i++) {
            operatorButts[i] = new JButton(Operator.values()[i].toString());
            if(i < 5)
                basic.add(operatorButts[i]);
//            advanced.add(operatorButts[i]);
        }


        shift = new JButton("Shift");
        advanced.add(shift);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Basic", basic);
        tabbedPane.addTab("Advanced", advanced);

        add(tabbedPane, BorderLayout.EAST);

        equal = new JButton(" = ");
        Dimension size = equal.getPreferredSize();
        size.height += 10;
        equal.setPreferredSize(size);
        add(equal, BorderLayout.SOUTH);

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

    private class Model {
        private double first, second, result;

        private Operator operator;

        /**
         * Apply the operation on the entered numbers
         */
        public void setResult() {
            switch(operator) {
                case ADD:
                    result = first + second;
                    break;
                case SUBTRACT:
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
        }


        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }

        public Operator getOperator() {
            return operator;
        }

        public double getResult() {
            setResult();
            first = result;
            return result;
        }

        public boolean hasOperator() {
            return operator != null;
        }

        public void setOperator(Operator operator) {
            this.operator = operator;
            second = 0;
        }

        public void appendFirst(int digit) {
            first = first * 10 + digit;
        }

        public void appendSecond(int digit) {
            second = second * 10 + digit;
        }
    }

    private class Listener implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton butt = (JButton)e.getSource();

            if(butt.equals(equal)) {
                screen.setText(model.getResult() + "");
                return;
            }

            for(int i = 0; i < 10; i++) {
                if(butt.equals(digitButts[i])) {
                    if(model.hasOperator()) {
                        model.appendSecond(i);
                        screen.setText(model.getFirst() + model.getOperator().toString() + model.getSecond());
                    }
                    else {
                        model.appendFirst(i);
                        screen.setText(model.getFirst() + "");
                    }
                    return;
                }
            }

            for(int i = 0; i < Operator.values().length; i++) {
                if (butt.equals(operatorButts[i])) {
                    Operator op = Operator.values()[i];
                    model.setOperator(op);
                    screen.setText(model.getFirst() + op.toString());
                    return;
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
