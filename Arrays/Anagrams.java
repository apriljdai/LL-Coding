/*
 Anagrams
 
 Given an array of strings, return all groups of strings that are anagrams.
 
 Note: All inputs will be in lower-case.
 */

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if (strs == null || strs.length == 0)
            return result;
        HashMap<String, ArrayList<String>> anagram = new HashMap<String, ArrayList<String>>();
        for (String s: strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sortedS = new String(temp);
            //map all the string which has the same characters
            if (anagram.containsKey(sortedS)){
                anagram.get(sortedS).add(s);
            }
            else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                anagram.put(sortedS, list);
            }
        }
        Set<String> set = anagram.keySet();
        for (String s: set){
            ArrayList<String> value = anagram.get(s);
            if (value.size() > 1)
            //have to add if statement
                result.addAll(value);
        }
        return result;
    }
}