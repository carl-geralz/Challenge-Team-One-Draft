public class SudokuVerification {

    // Metode utama yang dipanggil untuk memverifikasi Sudoku
    public void run() {
        int[][] board = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        boolean isValid = isValidSudoku(board);
        System.out.println("Sudoku valid: " + isValid);
    }

    // Fungsi untuk memeriksa apakah Sudoku valid
    public boolean isValidSudoku(int[][] board) {
        // Memeriksa baris
        for (int i = 0; i < 9; i++) {
            if (!isValidUnit(board[i])) {
                return false;
            }
        }

        // Memeriksa kolom
        for (int i = 0; i < 9; i++) {
            int[] column = new int[9];
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
            }
            if (!isValidUnit(column)) {
                return false;
            }
        }

        // Memeriksa sub-grup 3x3
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                int[] block = new int[9];
                int index = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        block[index++] = board[k][l];
                    }
                }
                if (!isValidUnit(block)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Fungsi untuk memeriksa apakah sebuah unit (baris, kolom, atau blok) valid
    private boolean isValidUnit(int[] unit) {
        boolean[] seen = new boolean[9];
        for (int num : unit) {
            if (num < 1 || num > 9) {
                return false;
            }
            if (seen[num - 1]) {
                return false;
            }
            seen[num - 1] = true;
        }
        return true;
    }
}