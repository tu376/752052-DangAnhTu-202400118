import javax.swing.JOptionPane;

public class SystemFirstDegreeEqua{
    public static void main(String[] args) {
        String notification;
        String stra11, stra12, stra21, stra22, strb1, strb2;
        stra11 = JOptionPane.showInputDialog("Enter a11:");
        stra12 = JOptionPane.showInputDialog("Enter a12:"); 
        strb1 = JOptionPane.showInputDialog("Enter b1:");
        stra21 = JOptionPane.showInputDialog("Enter a21:");
        stra22 = JOptionPane.showInputDialog("Enter a22:");
        strb2 = JOptionPane.showInputDialog("Enter b2:");
        double a11 = Double.parseDouble(stra11);
        double a12 = Double.parseDouble(stra12);
        double b1 = Double.parseDouble(strb1);
        double a21 = Double.parseDouble(stra21);
        double a22 = Double.parseDouble(stra22);
        double b2 = Double.parseDouble(strb2);
        notification = "The system of equations is:\n" +
            stra11 + "x1 + " + stra12 + "x2 = " + strb1 + "\n" +
            stra21 + "x1 + " + stra22 + "x2 = " + strb2;
        JOptionPane.showMessageDialog(null, notification);
        if (a11 * a22 - a12 * a21 == 0) {
            JOptionPane.showMessageDialog(null, "The system has no solution or infinitely many solutions.");
        } else {
            double x1 = (b1 * a22 - b2 * a12) / (a11 * a22 - a12 * a21);
            double x2 = (b2 * a11 - b1 * a21) / (a11 * a22 - a12 * a21);
            notification = "The solution is:\n" + "x1 = " + x1 + "\n" + "x2 = " + x2;
            JOptionPane.showMessageDialog(null, notification);
        }
        System.exit(0);
    }
}