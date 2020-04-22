import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame;

    public GUI() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(new Dimension(340, 400));
        frame.setLocation(300, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw();
        frame.setVisible(true);
    }

    public void draw() {
        screen();
        JPanel basic, advanced;
        basic = basic();
        advanced = advanced();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(20, 150, 300, 200);
        tabbedPane.add("Basic", basic);
        tabbedPane.add("Advanced", advanced);
        frame.add(tabbedPane);
    }

    public void screen() {
        JTextArea screen = new JTextArea();
        screen.setEditable(false);
        screen.setFont(new Font("Arial", 14, 16));

        JScrollPane scroll = new JScrollPane(screen);
        scroll.setLocation(20, 30);
        scroll.setSize(300, 100);

        frame.add(scroll);
    }

    public JPanel basic() {
        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        panel.setLocation(10, 150);
        panel.setLayout(new GridLayout(4, 4));

        Button[][] buttons = new Button[4][4];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j] = new Button(3 * i + j + 1 + "");
        buttons[3][0] = new Button("");
        buttons[3][1] = new Button("0");
        buttons[3][2] = new Button("%");
        buttons[0][3] = new Button("+");
        buttons[1][3] = new Button("-");
        buttons[2][3] = new Button("*");
        buttons[3][3] = new Button("/");

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                panel.add(buttons[i][j]);
        return panel;
    }


    public JPanel advanced() {
        JPanel panel = new JPanel();
        panel.setSize(300, 200);
        panel.setLocation(10, 150);
        panel.setLayout(new GridLayout(5, 5));

        Button[][] buttons = new Button[5][5];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j] = new Button(3 * i + j + 1 + "");

        buttons[3][0] = new Button("SHIFT");
        buttons[3][1] = new Button("0");
        buttons[3][2] = new Button("%");
        buttons[0][3] = new Button("+");
        buttons[1][3] = new Button("-");
        buttons[2][3] = new Button("*");
        buttons[3][3] = new Button("/");

        buttons[0][4] = new Button("SIN/cos");
        buttons[1][4] = new Button("TAN/cot");
        buttons[2][4] = new Button("exp");
        buttons[3][4] = new Button("log");
        buttons[4][4] = new Button("Π");
        buttons[3][4] = new Button("e");

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if(buttons[i][j] != null)
                    panel.add(buttons[i][j]);
                else
                    panel.add(new Button(""));
        return panel;
    }

}
