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

    /**
     * Build different components of the frame
     */
    public void build() {
        model = new Model();
        makeScreen();
        makeDigitButtons();
        makeOperatorButtons();
        makeMenubar();
    }

    /**
     * Set the ActionListener to each component and the KeyListener to the frame
     * @param actionListener the ActionListener to be added
     * @param keyListener the KeyListener to be added
     */
    public void setListener(ActionListener actionListener, KeyListener keyListener) {
        for(int i = 0; i < 10; i++)
            digitButts[i].addActionListener(actionListener);

        for (int i = 0; i < Operator.values().length; i++)
            operatorButts[i].addActionListener(actionListener);

        equal.addActionListener(actionListener);
        shift.addActionListener(actionListener);

        addKeyListener(keyListener);
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
     * Creat the buttons with digits and add the to the digitPanel
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
     * Create the operation buttons and add the to their panel, then add the panels
     * to the tabbedPane
     */
    public void makeOperatorButtons() {
        JPanel basic = new JPanel(new GridLayout(5, 1));
        JPanel advanced = new JPanel(new GridLayout(10, 1));

        operatorButts = new JButton[15];

        for(int i = 0; i < Operator.values().length; i++) {
            operatorButts[i] = new JButton(Operator.values()[i].toString());
            if(i < 5)
                basic.add(operatorButts[i]);
            else
                advanced.add(operatorButts[i]);
        }


        shift = new JButton("Shift");
        advanced.add(shift);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Basic", basic);
        tabbedPane.add("Advanced", advanced);

        add(tabbedPane, BorderLayout.EAST);

        equal = new JButton(" = ");
        Dimension size = equal.getPreferredSize();
        size.height += 10;
        equal.setPreferredSize(size);
        add(equal, BorderLayout.SOUTH);

    }

    /**
     * Add a Menubar to this frame
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
     * The actual calculator class that does the main work
     */
    private class Model {
        private double first, second, result;

        private Operator operator;

        /**
         * Apply the operation on the entered numbers
         */
        public void setResult() {
            if(operator == null) {
                result = first;
                return;
            }
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
                case SIN:
                    result = Math.sin(first);
                    break;
                case COS:
                    result = Math.cos(first);
                    break;
                case TAN:
                    result = Math.tan(first);
                    break;
                case COT:
                    result = 1 / Math.tan(first);
                    break;
            }
        }

        /**
         * @return the first number
         */
        public double getFirst() {
            return first;
        }

        /**
         * @return the second number
         */
        public double getSecond() {
            return second;
        }

        /**
         * @return the operator
         */
        public Operator getOperator() {
            return operator;
        }

        /**
         * Set then get the result
         * @return the result of the operation
         */
        public double getResult() {
            setResult();
            first = result;
            return result;
        }

        /**
         * @return true if the operator has been set
         */
        public boolean hasOperator() {
            return operator != null;
        }

        /**
         * Set the operator and set second number to zero
         * @param operator the new Operator to ne set
         */
        public void setOperator(Operator operator) {
            if(operator.isSingleInput())
                getResult();
            else
                this.operator = operator;
            second = 0;
        }

        /**
         * Append the given digit to the end of the first number
         * @param digit the digit to be appended
         */
        public void appendFirst(int digit) {
            first = first * 10 + digit;
        }

        /**
         * Append the given digit to the end of the first number
         * @param digit the digit to be appended
         */
        public void appendSecond(int digit) {
            second = second * 10 + digit;
        }
    }

    /**
     * The listener class to add to the inteface
     */
    private class Listener implements ActionListener, KeyListener {

        /**
         * Press the given digit's button
         * @param i the given digit
         */
        public void digit(int i) {
            if(model.hasOperator()) {
                model.appendSecond(i);
                screen.setText(model.getFirst() + model.getOperator().toString() + model.getSecond());
            }
            else {
                model.appendFirst(i);
                screen.setText(model.getFirst() + "");
            }
        }

        /**
         * Press the equal button
         */
        public void equal() {
            screen.setText(model.getResult() + "");
        }

        /**
         * Press the i-th operator button
         * @param i the index of the operator
         */
        public void operator(int i) {
            Operator op = Operator.values()[i];
            model.setOperator(op);
            if(op.isSingleInput())
                screen.setText(model.getFirst() + "");
            else
                screen.setText(model.getFirst() + op.toString());
        }

        /**
         * The action to be performed
         * @param e the ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton butt = (JButton)e.getSource();

            if(butt.equals(equal)) {
                equal();
                return;
            }

            for(int i = 0; i < 10; i++) {
                if(butt.equals(digitButts[i])) {
                    digit(i);
                    return;
                }
            }

            for(int i = 0; i < Operator.values().length; i++) {
                if (butt.equals(operatorButts[i])) {
                    operator(i);
                    return;
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * The action to be performed based on the pressed key
         * @param e the KeyEvent
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            String text = String.format(" %c ", e.getKeyChar());

            System.out.println(code + "," + text);

            if(code == KeyEvent.VK_EQUALS && text.equals(" = ")) {
                equal();
                return;
            }

            for(int i = 0; i < 10; i++) {
                if(code == KeyEvent.VK_0 + i && text.equals(" " + i + " ")) {
                    digit(i);
                    return;
                }
            }

            for(int i = 0; i < Operator.values().length; i++) {
                Operator op = Operator.values()[i];
                if (code == op.toKeyCode() && text.equals(op.toString())) {
                    operator(i);
                    return;
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }


}
