public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] check = new boolean[256];//ASCII Initialize character translation and type tables
        for (int i = 0; i < 256; i++)
            check[i] = false;
        int i = 0, j = 0, len = s.length();
        int max = 0;
        while (j < len){
            if (!check[s.charAt(j)]){
                check[s.charAt(j)] = true;
                j++;
            }
            else{
                max = Math.max(max, j - i);
                while (s.charAt(i) != s.charAt(j)){
                    check[s.charAt(i)] = false;//why?
                    i++;
                }
                i ++;
                j ++;
            }
        }
        return max = Math.max(max, len - i);
    }
}


/*
    char[] sToArray = s.toCharArray();
    int temp = 0;
    HashMap<Character, Integer> result = new HashMap<Character, Integer>();
    for (int i = 0; i < sToArray.length; i++){
        if (!result.containsKey(sToArray[i])){
            result.put(sToArray[i], i);
        }
        else{
            temp = temp > result.size() ? temp: result.size();
            i = result.get(sToArray[i]);
            //Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
            result.clear();//to start over
            //Removes all of the mappings from this map.
        }
    }
    return Math.min(temp, result.size());
 time exceeded
 */
