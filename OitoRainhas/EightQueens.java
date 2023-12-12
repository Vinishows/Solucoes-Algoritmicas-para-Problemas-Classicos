import java.util.Random;

public class EightQueens {

    public static boolean isSafe(int[] board, int row, int col) {
        // Verifica se é seguro colocar uma rainha na posição (row, col)
        for (int i = 0; i < row; i++) {
            if (board[i] == col ||
                board[i] - i == col - row ||
                board[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }
    // Complexidade de Tempo: O(1)
    // Complexidade de Espaço: O(1)

    public static void placeQueens(int[] board, int row, int n) {
        if (row == n) {
            // Todas as rainhas foram colocadas com sucesso
            printBoard(board);
            return;
        }

        int[] shuffledCols = new int[n];
        for (int i = 0; i < n; i++) {
            shuffledCols[i] = i;
        }
        shuffleArray(shuffledCols);

        for (int col : shuffledCols) {
            if (isSafe(board, row, col)) {
                board[row] = col;
                placeQueens(board, row + 1, n);
            }
        }
    }
    // Complexidade de Tempo: O(n)
    // Complexidade de Espaço: O(n)

    public static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
    // Complexidade de Tempo: O(n)
    // Complexidade de Espaço: O(1)

    public static void printBoard(int[] board) {
        for (int i : board) {
            for (int j = 0; j < board.length; j++) {
                if (j == i) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    // Complexidade de Tempo: O(n^2)
    // Complexidade de Espaço: O(1)

    public static void solveEightQueens(int n) {
        int[] board = new int[n];
        placeQueens(board, 0, n);
    }
    // Complexidade de Tempo: O(n!)
    // Complexidade de Espaço: O(n)

    public static void main(String[] args) {
        int n = 8; // Tamanho do tabuleiro de xadrez
        solveEightQueens(n);
    }
    // Complexidade de Tempo: O(n!)
    // Complexidade de Espaço: O(n)
}
