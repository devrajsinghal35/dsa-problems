class NumMatrix {

    private int[][] prefix;

    public NumMatrix(int[][] matrix) {

        // Check null and empty matrix first
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;       // number of rows
        int n = matrix[0].length;   // number of columns

        // Create prefix sum array
        prefix = new int[m][n];

        // Build prefix sum
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // Sum of area above current cell
                int top = (i > 0) ? prefix[i - 1][j] : 0;

                // Sum of area to the left
                int left = (j > 0) ? prefix[i][j - 1] : 0;

                // Area that was counted twice
                int topLeft = (i > 0 && j > 0)
                        ? prefix[i - 1][j - 1]
                        : 0;

                // Add current value
                // Add top
                // Add left
                // Remove duplicate top-left
                prefix[i][j] =
                        matrix[i][j] + top + left - topLeft;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        // Total area from (0,0) to (row2,col2)
        int total = prefix[row2][col2];

        // Remove area above requested rectangle
        int top = (row1 > 0)
                ? prefix[row1 - 1][col2]
                : 0;

        // Remove area to the left
        int left = (col1 > 0)
                ? prefix[row2][col1 - 1]
                : 0;

        // Add back the area removed twice
        int topLeft = (row1 > 0 && col1 > 0)
                ? prefix[row1 - 1][col1 - 1]
                : 0;

        return total - top - left + topLeft;
    }
}