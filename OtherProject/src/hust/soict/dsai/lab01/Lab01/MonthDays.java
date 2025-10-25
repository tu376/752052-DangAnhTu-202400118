import javax.swing.JOptionPane;

public class MonthDays {
    public static void main(String[] args) {
        while (true) {
            int month = -1;
            while (month == -1) {
                String Month = JOptionPane.showInputDialog(null, "Enter month:");
                if (Month == null) return; // cancel
                month = getMonth(Month);
                if (month == -1) JOptionPane.showMessageDialog(null, "Invalid month. Try again.");
            }

            int year = -1;
            while (year < 0) {
                String Year = JOptionPane.showInputDialog(null, "Enter year:");
                if (Year == null) return;
                if (Year.matches("\\d+")) year = Integer.parseInt(Year);
                if (year < 0) JOptionPane.showMessageDialog(null, "Invalid year. Pleae try again!");
            }

            JOptionPane.showMessageDialog(null, getMonthDays(month, year));
        }
    }

    public static int getMonth(String Month) {
        String lowerMonth = Month.toLowerCase();

        switch (lowerMonth) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
                return 4;
            case "may":
            case "5":
                return 5;
            case "june":
            case "jun.":
            case "jun":
            case "6":
                return 6;
            case "july":
            case "jul.":
            case "jul":
            case "7":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
                return 8;
            case "september":
            case "sep.":
            case "sep":
            case "9":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
                return 12;
            default:
                return -1;    
        }
    }

    public static boolean checkLeap(int Year) {
        return ((Year % 4 == 0 && Year % 100 != 0) || (Year % 400 == 0));
    }

    public static int getMonthDays(int Month, int Year) {
        switch (Month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return checkLeap(Year)? 29: 28;
            default:
                return 0;
        }
    }
}
