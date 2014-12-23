public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        //1D dynamic programming
        boolean[] test = new boolean[s.length() + 1];
        test[0] = true;
        for (int i = 0; i < s.length(); i++){
            if (!test[i])
                continue;
            for (String a: dict){
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;//dict set could larger than s
                if (test[end])
                    continue;
                if (s.substring(i, end).equals(a))
                    test[end] = true;
            }
        }
        return test[s.length()];
    }
}