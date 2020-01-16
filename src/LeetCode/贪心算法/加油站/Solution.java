package LeetCode.贪心算法.加油站;


public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
            System.out.println(gas[i] - cost[i]);
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];
            // If one couldn't get here,
            if (curr_tank < 0) {
                // Pick up the next station as the starting one.
                starting_station = i + 1;
                // Start with an empty tank.
                curr_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_station : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] gas = new int[]{4, 5, 1, 2, 3};
        int[] cost = new int[]{1, 4, 4, 1, 5};
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}

