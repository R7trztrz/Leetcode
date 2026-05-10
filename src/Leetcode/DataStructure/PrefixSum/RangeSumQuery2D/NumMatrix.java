package Leetcode.DataStructure.PrefixSum.RangeSumQuery2D;

/**
 * preSum[i][j] records the sum of all elements in the matrix with top-left at the
 * origin and bottom-right at (i, j).
 *
 * @since 10 / 05 / 2026
 */
class NumMatrix {
    private int[][] preSumMatrix;

    public NumMatrix(int[][] matrix) {
        buildPreSumMatrix(matrix);
    }

    public void buildPreSumMatrix(int[][] matrix) {
      this.preSumMatrix = new int[matrix.length + 1][matrix[0].length + 1];

      for (int i = 1; i < matrix.length + 1; i++) {
          for (int j = 1; j < matrix[0].length + 1; j++) {
              preSumMatrix[i][j] = preSumMatrix[i - 1][j] + preSumMatrix[i][j - 1] + matrix[i - 1][j - 1]
                      - preSumMatrix[i -1][j -1];
          }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSumMatrix[row2 +1][col2 + 1] - preSumMatrix[row2 +1][col1] - preSumMatrix[row1][col2 + 1]
                + preSumMatrix[row1][col1];
    }
}
