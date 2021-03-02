package lesson_08;

import javax.swing.*;
import java.awt.*;

public class CalcPanelRight {

    private final JPanel panel;

    public CalcPanelRight(JTextField inputField) {
        panel = new JPanel();
        JButton jbActions[] = new JButton[]{
                new JButton("CLEAR"),
                new JButton("BACKSPACE"),
                new JButton("MOD [+|-]"),
                new JButton("SQRT"),
                new JButton("DIV [/]"),
                new JButton("MUL [*]"),
                new JButton("SUB [-]"),
                new JButton("ADD [+]"),
                new JButton("("),
                new JButton(")"),
        };

        panel.setLayout(new GridLayout(10, 1));
        CalcButtonListener keyListener = new CalcButtonListener(inputField);
        for (int i = 0; i < jbActions.length; i++) {
            jbActions[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            jbActions[i].setBackground(Color.ORANGE);
            jbActions[i].addActionListener(keyListener);
            panel.add(jbActions[i]);
        }
    }

    public JPanel getPanel() {
        return panel;
    }

}
