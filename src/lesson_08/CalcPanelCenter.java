package lesson_08;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class CalcPanelCenter {
    private final JPanel panel;               // panel

    public CalcPanelCenter(JTextField inputField) {
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));
        char[][] keyMap = new char[][]{
                {'7', '8', '9'},
                {'4', '5', '6'},
                {'1', '2', '3'},
                {'=', '0', '.'}
        };
        CalcButtonListener keyListener = new CalcButtonListener(inputField);

        for (int i = 0; i < keyMap.length; i++) {
            for (int j = 0; j < keyMap[i].length; j++) {
                JButton jbNumber = new JButton(String.valueOf(keyMap[i][j]));
                jbNumber.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
                jbNumber.addActionListener(keyListener);
                panel.add(jbNumber);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

}

