import java.util.function.DoubleToIntFunction;
import javax.swing.JOptionPane;

public class FirstDegreeEqua {
    public static void main(String[] args) {
        String strNotification;
        String stra = JOptionPane.showInputDialog(null, "Input coefficient a:", "Input a", JOptionPane.INFORMATION_MESSAGE);
        String strb = JOptionPane.showInputDialog(null, "Input coefficient b:", "Input b", JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(stra);
        double b = Double.parseDouble(strb);
        strNotification = "The equation: " + stra +  "x + " + strb + " = 0" + "\n";
        if (a == 0) {
            strNotification += "The equation has no solution.";
        } else {
            strNotification += "The solution: x = " + (-b/a);
        }
        JOptionPane.showMessageDialog(null, strNotification, "Show result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}