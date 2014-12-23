public class Solution {
    public String intToRoman(int num) {
        String roman[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int integer[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        //get the max value of each region
        String romanValue = "";
        for (int i = 0; num != 0; i++){
            //every time find the max value then combine the chars.
            while (num >= integer[i]){
                num -= integer[i];
                romanValue += roman[i];
            }
        }
        return romanValue;
    }
}