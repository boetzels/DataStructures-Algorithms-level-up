public class Main {
    public static void main(String[] args) {
	// write your code here
        int n = 4;

        int[] queens = new int[n];

        if (NQueens(queens, n, 0)) {
            for (int i : queens) {
                for (int k = 0; k < n; k++) {
                    System.out.print((k == i) ? "x" : 0);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("No solution");
        }
    }

    public static boolean NQueens(int[] queens, int n, int line) {
        if (line >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (validQueen(queens, n, line, i)) {
                queens[line] = i;
                if (NQueens(queens, n, line + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean validQueen(int[] queens, int n, int line, int col) {
        for (int i = 0; i < line; i++) {
            int lineDif = line - i;
            if (col == queens[i] || col == queens[i] + lineDif || col == queens[i] - lineDif) {
                return false;
            }
        }
        return true;
    }
}
