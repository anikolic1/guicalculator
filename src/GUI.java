import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JTextField l;

    String s0, s1, s2;

    public GUI() {
        frame = new JFrame();
        s0 = s1 = s2 = "";

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        l = new JTextField(16);
        l.setEditable(false);

        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        JButton beq1 = new JButton("=");

        JButton ba = new JButton("+");
        JButton bs = new JButton("-");
        JButton bd = new JButton("/");
        JButton bm = new JButton("*");
        JButton beq = new JButton("C");

        JButton be = new JButton(".");

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        beq1.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bd.addActionListener(this);
        bm.addActionListener(this);
        beq.addActionListener(this);
        be.addActionListener(this);

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.add(l);
        panel.add(ba);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bs);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bm);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bd);
        panel.add(be);
        panel.add(b0);
        panel.add(beq);
        panel.add(beq1);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator GUI");
        frame.setSize(250,270);
        frame.setVisible(true);
    }

    private static boolean isNum(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (GUI.isNum(s)) {
            if (s0.isEmpty()) {
                s0 = s;
                updateText();
            }
            else {
                s1 = s;
                updateText();
            }
        }
        else {
            switch (s) {
                case "+":
                    s2 = "+";
                    updateText();
                    break;
                case "-":
                    s2 = "-";
                    updateText();
                    break;
                case "*":
                    s2 = "*";
                    updateText();
                    break;
                case "/":
                    s2 = "/";
                    updateText();
                    break;
                case "C":
                    s0 = s1 = s2 = "";
                    updateText();
                    break;
                case "=":
                    double val = getVal();
                    l.setText(s0 + s2 + s1 + "=" + val);
                    s0 = Double.toString(val);
                    s1 = s2 = "";
                    break;
            }
        }
    }

    private void updateText() {
        l.setText(s0 + s2 + s1);
    }

    private double getVal() {
        double val = switch (s2) {
            case "+" -> Double.parseDouble(s0) + Double.parseDouble(s1);
            case "-" -> Double.parseDouble(s0) - Double.parseDouble(s1);
            case "*" -> Double.parseDouble(s0) * Double.parseDouble(s1);
            case "/" -> Double.parseDouble(s0) / Double.parseDouble(s1);
            default -> 0;
        };
        return val;
    }
}