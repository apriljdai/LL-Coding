public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanNumber = new HashMap<Character, Integer>();
        romanNumber.put('I',1);
        romanNumber.put('V',5);
        romanNumber.put('X',10);
        romanNumber.put('L',50);
        romanNumber.put('C',100);
        romanNumber.put('D',500);
        romanNumber.put('M',1000);
        //map the roman char with integer
        int romanValue = romanNumber.get(s.charAt(s.length() - 1));
        //wanna get value, use mapVariable.get(key);
        for(int i = s.length() - 2; i >= 0; i--){
            if(romanNumber.get(s.charAt(i + 1)) <= romanNumber.get(s.charAt(i)))
                romanValue += romanNumber.get(s.charAt(i));
            else
                romanValue -= romanNumber.get(s.charAt(i));
            //algorithm: right char >= left char, => right - left
            //           left char > right char, => left + right
        }
        return romanValue;
    }
}