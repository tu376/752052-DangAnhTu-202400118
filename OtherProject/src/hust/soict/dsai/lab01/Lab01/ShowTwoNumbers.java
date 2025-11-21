import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";
        
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2 + "\n";
        
        double Num1 = Double.parseDouble(strNum1);
        double Num2 = Double.parseDouble(strNum2);

        strNotification += "Sum of two numbers: " + (Num1 + Num2) + "\n";
        strNotification += "Difference of two numbers: " + (Num1 - Num2) + "\n";
        strNotification += "Product of two numbers: " + (Num1 * Num2) + "\n";
        if (Num2 == 0) {
            strNotification += "Cannot make this division";
        } else {
            strNotification += "Qoutient of two numbers: " + (Num1 / Num2);
        }

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
