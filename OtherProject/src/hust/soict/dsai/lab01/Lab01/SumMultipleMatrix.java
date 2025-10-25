import java.util.Scanner;

/*
Input:
1 2
3 4

1 2
3 4
 */

public class SumMultipleMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input size of two matrices
        System.out.print("Enter the number of row and column of the first matrix: ");
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();
        System.out.print("Enter the number of row and column of the second matrix: ");
        int row2 = scanner.nextInt();
        int col2 = scanner.nextInt();

        // Input two matrices
        int[][] matrix1 = new int[row1][col1];
        int[][] matrix2 = new int[row2][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }
        if (row1 == row2 && col1 == col2 && row1 == col1) {
            System.out.println("Sum of two matrices:");
            int[][] summ = add(matrix1, matrix2);
            for (int i = 0; i < row1; i++) {
                for (int j =- 0; j < col1; j++) {
                    System.out.print(summ[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Mul of two matrices:");
            int[][] mulm = mul(matrix1, matrix2);
            for (int i = 0; i < row1; i++) {
                for (int j =- 0; j < col1; j++) {
                    System.out.print(mulm[i][j] + " ");
                }
                System.out.println();
            }
        } else if (row1 == row2 && col1 == col2) {
            System.out.println("Sum of two matrices:");
            int[][] summ = add(matrix1, matrix2);
            for (int i = 0; i < row1; i++) {
                for (int j =- 0; j < col1; j++) {
                    System.out.print(summ[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Cannot calculate multiplication.");
        } else if (row1 == col2 && row2 == col1) {
            System.out.println("Cannot calculate addition.");
            System.out.println("Mul of two matrices:");
            int[][] mulm = mul(matrix1, matrix2);
            for (int i = 0; i < row1; i++) {
                for (int j =- 0; j < row1; j++) {
                    System.out.print(mulm[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] add(int[][] m1, int[][] m2) {
        int row = m1.length;
        int col = m1.length;
        int[][] m = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                m[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return m;
    }

    public static int[][] mul(int[][] m1, int[][] m2) {
        int a = m1.length;
        int b = m1[0].length;
        int[][] m = new int[a][a];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                int c = 0;
                for (int k = 0; k < b; k++) {
                    c += m1[i][k] * m2[k][j];
                }
                m[i][j] = c;
            }
        }
        return m;
    }
}
