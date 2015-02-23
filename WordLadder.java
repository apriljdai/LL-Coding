/*
 Word Ladder
 
 Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,
 
 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 
 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */

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