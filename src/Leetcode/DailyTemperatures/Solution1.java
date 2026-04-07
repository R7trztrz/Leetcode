package Leetcode.DailyTemperatures;

class Solution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            boolean findWarmer = false;
            int days = 0;

            for (int j = i + 1; j < temperatures.length; j++) {
                // Increment the waiting-day count for each day that passes.
                days++;

                if (temperatures[j] > temperatures[i]) {
                    findWarmer = true;
                    break;
                }
            }

            answer[i] = findWarmer ? days : 0;
        }

        return answer;
    }
}
