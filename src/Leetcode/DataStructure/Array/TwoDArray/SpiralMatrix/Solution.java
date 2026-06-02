package Leetcode.DataStructure.Array.TwoDArray.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * After traversing, the boundary is changed immediately,
 * so that the traversal in the next direction will not start from index 0, thus avoiding repetition.
 * <p>
 * Time Complexity: O(n)
 *
 * @since 15 / 05 / 2026
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        // initialization boundary
        int upperBound = 0;
        int rightBound = matrix[0].length - 1;
        int lowerBound = matrix.length - 1;
        int leftBound = 0;

        // iteration
        while (answer.size() < matrix.length * matrix[0].length) {
            // →
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    answer.add(matrix[upperBound][i]);
                }
                upperBound++;
            }

            // ↓
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    answer.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            // ←
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    answer.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }

            // ↑
            if(leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    answer.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }

        return answer;
    }
}
