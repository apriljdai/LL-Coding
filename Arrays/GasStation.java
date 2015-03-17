public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0)
            return -1;
        int start = 0, sum = 0, total = 0;
        for (int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];//instead of "="
            total += sum;
            if (sum < 0){
                start = i + 1;
                sum = 0;//total is no need to be 0 since it counts the whole value of gas and cost
            }
        }
        if (total < 0)
            return -1;
        return start;
    }
}