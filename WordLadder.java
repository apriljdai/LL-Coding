public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict.size() == 0)
            return 0;
        LinkedList<String> tempString = new LinkedList<String>();
        LinkedList<Integer> intString = new LinkedList<Integer>();
        tempString.add(start);
        intString.add(1);
        while (!tempString.isEmpty()){
            int result = intString.pop();
            String tempResult = tempString.pop();
            if (tempResult.equals(end))
                return result;
            for (int i = 0; i < tempResult.length(); i++){
                char[] tempChar = tempResult.toCharArray();
                for (char a = 'a'; a <= 'z'; a++){
                    tempChar[i] = a;
                    String newString = new String(tempChar);
                    if (dict.contains(newString)){
                        tempString.add(newString);
                        intString.add(result + 1);
                        dict.remove(newString);
                    }
                }
            }
        }
        return 0;
    }
}