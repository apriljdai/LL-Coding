public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++){
            if (!temp.containsKey(numbers[i]))
                temp.put(target - numbers[i], i);
            //Associates the specified value with the specified key in this map.
            else{
                int index = temp.get(numbers[i]);
                result[0] = index + 1;
                result[1] = i + 1;
                Arrays.sort(result);
                break;
            }
        }
        return result;
    }
}