import javax.swing.JOptionPane;

public class SecondDegreeEqua {
    public static void main(String[] args) {
        String notification;
        String stra, strb, strc;
        stra = JOptionPane.showInputDialog("Enter a:");
        strb = JOptionPane.showInputDialog("Enter b:");
        strc = JOptionPane.showInputDialog("Enter c:");
        
        double a = Double.parseDouble(stra);
        double b = Double.parseDouble(strb);
        double c = Double.parseDouble(strc);
        
        notification = "The equation is:\n" + stra + "x^2 + " + strb + "x + " + strc + " = 0";
        JOptionPane.showMessageDialog(null, notification);
        
        double delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            JOptionPane.showMessageDialog(null, "The equation has no real solutions.");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            notification = "The equation has one solution:\n" + "x = " + x;
            JOptionPane.showMessageDialog(null, notification);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            notification = "The equation has two solutions:\n" + "x1 = " + x1 + "\n" + "x2 = " + x2;
            JOptionPane.showMessageDialog(null, notification);
        }
        
        System.exit(0);
    }
}
