package Leetcode.DataStructure.Array.DiffArray.CorporateFlightBookings;

/**
 * With the difference array diff, we can quickly increase or decrease a range of elements.
 * <p>
 * diff[i] = num[i] - num[i - 1].
 * From [i, j], add x: diff[i] += x, diff[j + 1] -= x.
 * Time complexity: O(n)
 *
 * @since 12 / 05 / 2026
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        // build diff array
        int[] diff = new int[n];

        diff[0] = answer[0];
        for (int i = 1; i < n; i++) {
            diff[i] = answer[i] - answer[i - 1];
        }

        // calculate seats
        for (int[] booking : bookings) {
            // [x, y, value]
            int x = booking[0] - 1;
            int y = booking[1] - 1;
            int value = booking[2];

            // From index(x) to index(y), add value
            diff[x] += value;
            if (y + 1 < n) {
                diff[y + 1] -= value;
            }

        }

        // Restore the array
        answer[0] = diff[0];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + diff[i];
        }

        return answer;
    }
}
