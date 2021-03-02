package lesson_08;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class CalcFrameMain extends JFrame{

    public CalcFrameMain() {                                                   // constructor
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 300, 600, 600);
        setTitle("Calculator.(v.1.0)");

// ---- add JPanel: set layout for Main Frame
        setLayout(new BorderLayout());

// ---- add Top JPanel: Input (JTextField),...
        CalcPanelTop topPanel = new CalcPanelTop();
        add(topPanel.getPanel(),BorderLayout.NORTH);

// ---- add Center JPanel: Number buttons (JButton)
        CalcPanelCenter centerPanel = new CalcPanelCenter(topPanel.getInpField());
        add(centerPanel.getPanel(),BorderLayout.CENTER);

// ---- add Center JPanel: Actions buttons (JButton)
        CalcPanelRight rightPanel = new CalcPanelRight(topPanel.getInpField());
        add(rightPanel.getPanel(),BorderLayout.EAST);

        setVisible(true);
    }
}
