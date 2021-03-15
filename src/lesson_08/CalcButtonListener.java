package lesson_08;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcButtonListener implements ActionListener {
    private JTextField inputField;

    public CalcButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    private String adjustResultString(String input) {
        /**
         * Adjustment: Search tale from previous expression (before '=') and remove
         * for proper run via ScriptEngine
         * */
        int i = 0, j = 0;
        String output = input;  // init

// ---- find latest '='
        do {
            j = input.indexOf('=', i);
            if (j >= 0) {
                j++;                            // index to ignore latest '='
                output = input.substring(j);
                i = j;
            }
        } while (j != -1);
        return output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
// ---- creates variable that will capture a string when an event occurs
        String cmd = e.getActionCommand();
        String inpField = inputField.getText();
// ---- init ScriptEngine
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        Object expResult = null;

// ---- handle Func.Codes
        switch (cmd) {
            case "CLEAR":
//                System.out.println(cmd + inpField );
//                inputField.setText("");
                inpField = "";
                break;
            case "BACKSPACE":
                StringBuilder sb = new StringBuilder(inpField);
                sb.deleteCharAt(sb.length() - 1);
                inpField = sb.toString();
                break;
//            case "MOD [+|-]":
//                System.out.println(cmd + inpField );
//                break;
            case "DIV [/]":
                inpField = inpField + '/';
                break;
            case "MUL [*]":
                inpField = inpField + '*';
                break;
            case "SUB [-]":
                inpField = inpField + '-';
                break;
            case "ADD [+]":
                inpField = inpField + '+';
                break;
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "(":
            case ")":
            case ".":
                inpField = inpField + cmd;
                break;
            case "SQRT":
            case "=":
                inpField = adjustResultString(inpField);
                try {
                    expResult = scriptEngine.eval(inpField);

                    inpField = inpField + "=" + expResult.toString();
                    if (cmd == "SQRT") {
                        double sqrtResult = Double.parseDouble(expResult.toString());
                        inpField = inpField + " (" + cmd + ")" + "=" + Math.sqrt(sqrtResult);
                    }
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Incorrect expression!");
                    return;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null,
                        "Function code '" + cmd + "' is NOT supported");
                return;
        }
        inputField.setText(inpField);
    }
}
