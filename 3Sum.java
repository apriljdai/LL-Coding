public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3)
            return result;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++){//num.length - 2 since j = i + 1
            if (i == 0 || num[i] > num[i - 1]){//avoid duplicate solution
                int j = i + 1;
                int k = num.length - 1;
                while (j < k){
                    if (num[i] + num[j] + num[k] == 0){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        result.add(temp);
                        j ++;
                        k --;
                        while (j < k && num[k] == num[k + 1])//avoid two neighborsare the same, which will produce duplicate solution
                            k --;
                        while (j < k && num[j] == num[j - 1])
                            j++;
                    }
                    else if (num[i] + num[j] + num[k] > 0)
                        k --;
                    else
                        j ++;
                    
                }
            }
        }
        return result;
    }
}