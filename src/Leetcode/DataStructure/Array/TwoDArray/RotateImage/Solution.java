package Leetcode.DataStructure.Array.TwoDArray.RotateImage;

/**
 * Flip the n × n matrix along the diagonal from the top-left to the bottom-right.
 * Then reverse each row of the matrix.
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * @since 14 / 05 / 2026
 */
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] i : matrix) {
            reverse(i);
        }
    }

    // reverse array
    public void reverse(int[] array) {
        int temp = 0;
        int j = array.length - 1;
        for (int i = 0; i < j; i++) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j--;
        }
    }
}
