public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> intToGray = new ArrayList<Integer>();
        int size = (int)Math.pow(2,n);
        //must add cast in front of Math since pow returns long
        for (int i = 0; i < size; i++){
            intToGray.add(i ^ (i >> 1));
            //integer to gray code algorithm: binary i right move 1 bit, then XOR to the origional i
        }
        return intToGray;
    }
}