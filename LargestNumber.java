/*
Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.
For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
*/

public String largestNumber(int[] num){
	String[] arr = new String[num.length];
  	for (int i = 0; i < num.length; i++){
	  	arr[i] = String.valueOf(num[i]);
    }
   	//Arrays.sort(T[] a, Comparator<? super T> c): sort the array of objects according to the order induced by the specified comparator
    Arrays.sort(arr, new Mysort());
    StringBuffer sb = new StringBuffer();
    for (String s: arr){
	    sb.append(s);
   	}
   	//avoid of two number are 0 -> "00" = "0"
    String res = sb.toString();
   	if ("".equals(res.replace("0", "")))
        return "0";
   	return res;
}
public class Mysort implements Comparator<String>{
	public int compare(String o1, String o2){
	    return (o2 + o1).compareTo(o1 + o2);
    }
}  