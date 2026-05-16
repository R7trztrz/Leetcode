package Leetcode.DataStructure.TwoDArray.SpiralMatrixII;

/**
 *
 * @since 16 / 05 / 2026
 */
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] answer = new int[n][n];

        int upperBound = 0;
        int rightBound = n - 1;
        int lowerBound = n - 1;
        int leftBound = 0;

        int[] array = new int[n * n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int iterator = 0;

        for (int j = 0; j < n * n; j++) {
            // →
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    // iteration
                    answer[upperBound][i] = array[iterator];
                    iterator++;
                }

                upperBound++;
            }

            // ↓
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    // iteration
                    answer[i][rightBound] = array[iterator];
                    iterator++;
                }

                rightBound--;
            }

            // ←
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    // iteration
                    answer[lowerBound][i] = array[iterator];
                    iterator++;
                }

                lowerBound--;
            }

            // ↑
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    // iteration
                    answer[i][leftBound] = array[iterator];
                    iterator++;
                }

                leftBound++;
            }
        }

        return answer;
    }
}
