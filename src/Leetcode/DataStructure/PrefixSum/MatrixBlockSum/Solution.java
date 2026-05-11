package Leetcode.DataStructure.PrefixSum.MatrixBlockSum;

/**
 *
 *
 * @since 11 / 05 2026
 */
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        RangeSum rangeSum = new RangeSum(mat);

        int m = mat.length;
        int n = mat[0].length;

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);

                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);

                answer[i][j] = rangeSum.sumRegion(r1, c1, r2, c2);
            }
        }

        return answer;
    }
}

class RangeSum {
    private int[][] preSumsMatrix;

    RangeSum(int[][] mat) {
        buildPreSumsMatrix(mat);
    }

    private void buildPreSumsMatrix(int[][] mat) {
        this.preSumsMatrix = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 1; i < mat.length + 1; i++) {
            for (int j = 1; j < mat[0].length + 1; j++) {
                preSumsMatrix[i][j] = preSumsMatrix[i -1][j] + preSumsMatrix[i][j - 1] - preSumsMatrix[i -1][j - 1]
                        + mat[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        return preSumsMatrix[r2 + 1][c2 + 1]
                - preSumsMatrix[r2 + 1][c1]
                - preSumsMatrix[r1][c2 + 1]
                + preSumsMatrix[r1][c1];
    }
}
