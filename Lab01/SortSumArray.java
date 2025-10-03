import javax.swing.JOptionPane;
import java.util.Arrays;
public class SortSumArray {
    public static void main(String[] args) {
        String strn = JOptionPane.showInputDialog(null, "Import the length of array:", "Array Length", JOptionPane.INFORMATION_MESSAGE);
        int n = Integer.parseInt(strn);
        int i = 0;
        int[] arr = new int[n];
        if (n == 0) JOptionPane.showMessageDialog(null, "Goodbye");
        else {
            while (i < n) {
                String stra = JOptionPane.showInputDialog(null, "Import number:");
                int a = Integer.parseInt(stra);
                arr[i] = a;
                i++;
            }
            
            JOptionPane.showMessageDialog(null, "Our array:\n" + Arrays.toString(arr) + "\n");
            int[] sortedarr = sortarr(arr);
            JOptionPane.showMessageDialog(null, "Sorted arr: " + Arrays.toString(sortedarr) + "\n" +
                                                "Sum of array: " + SUM(arr) + "\n" +
                                                "Average of array: " + (double) SUM(arr)/n);
        }
        System.exit(0);
    }
    public static int[] sortarr(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int k = arr[i];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
        } return arr;
    }

    public static int SUM(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }
}
