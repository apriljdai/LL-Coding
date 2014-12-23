public class Solution {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> needFind = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++){
            hasFound.put(T.charAt(i), 0);
            if (needFind.containsKey(T.charAt(i)))
                needFind.put(T.charAt(i), needFind.get(T.charAt(i)) + 1);
            else
                needFind.put(T.charAt(i), 1);
        }
        int begin = 0, minSize = S.length(), count = 0;
        String result = "";
        for (int end = 0; end < S.length(); end++){
            char c = S.charAt(end);
            if (needFind.containsKey(c)){
                hasFound.put(c, hasFound.get(c) + 1);
                if (hasFound.get(c) <= needFind.get(c))
                    count ++;
                if (count == T.length()){
                    while ((!needFind.containsKey(S.charAt(begin))) || (hasFound.get(S.charAt(begin)) > needFind.get(S.charAt(begin)))){
                        if (needFind.containsKey(S.charAt(begin))){
                            hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin)) - 1);
                        }
                        begin ++;
                    }
                    if (end - begin + 1 <= minSize){
                        minSize = end - begin + 1;
                        result = S.substring(begin, end + 1);
                    }
                }
            }
        }
        return result;
    }
}