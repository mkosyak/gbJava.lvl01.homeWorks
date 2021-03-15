package lesson_08;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;

public class CalcPanelTop {
    private final JPanel panel;               // panel
    private final JTextField inpField;        // input Field (text)

    public CalcPanelTop() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        inpField = new JTextField();
        inpField.setEditable(false);
        inpField.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        panel.add(inpField, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getInpField() {
        return inpField;
    }
}
