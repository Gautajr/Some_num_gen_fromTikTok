public class SerpentinePattern {

    /**
     * Generates a matrix with a serpentine (boustrophedon) pattern along the anti-diagonals.
     *
     * @param n The size of the square matrix (e.g., 4 for a 4x4 matrix).
     * @return A 2D integer array representing the generated pattern.
     */
    public static int[][] generatePattern(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];
        int num = 1;

        // Iterate through all anti-diagonals, where s = row + col
        for (int s = 0; s <= 2 * (n - 1); s++) {
            if (s % 2 == 0) {
                // For even sums, traverse from top-right to bottom-left
                int row = (s < n) ? 0 : s - (n - 1);
                int col = (s < n) ? s : n - 1;

                while (row < n && col >= 0) {
                    matrix[row][col] = num++;
                    row++;
                    col--;
                }
            } else {
                // For odd sums, traverse from bottom-left to top-right
                int row = (s < n) ? s : n - 1;
                int col = (s < n) ? 0 : s - (n - 1);

                while (row >= 0 && col < n) {
                    matrix[row][col] = num++;
                    row--;
                    col++;
                }
            }
        }
        return matrix;
    }

    /**
     * Prints a 2D integer array to the console with formatted spacing.
     *
     * @param matrix The 2D array to print.
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%-4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size = 4;
        System.out.println("Generating a " + size + "x" + size + " pattern:");
        int[][] patternMatrix = generatePattern(size);
        printMatrix(patternMatrix);
    }
}
