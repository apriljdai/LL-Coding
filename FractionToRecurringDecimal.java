/*
Fraction to Recurring Decimal
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.
For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

public static String fractionToDecimal(int numerator, int denominator){
		//the base case
		if (numerator == 0)
			return new String("0");
		if (denominator == 0)
			return "";

		//check if the answer will be negative
		boolean flag = (numerator < 0) ^ (denominator < 0);

		//trans to positive but change to long cause maybe overflow
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);

		StringBuffer res = new StringBuffer();

		if (flag)
			res.append("-");
		
		res.append(String.valueOf(num / den));
		
		num = num % den;
		if (num == 0)
			return res.toString();
		
		res.append(".");
        //hashmap to store the remain and its index in res
		HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
		for (int i = res.length(); num != 0; ++i){
			if (hm.containsKey(num))
				break;
			hm.put(num, i);
			num *= 10;
			res.append(String.valueOf(num / den));
			num %= den;
		}
	    //handle the num that could be divided and mod 0
		if (num == 0)
			return res.toString();

		res.insert(hm.get(num),"(");
		res.append(")");
		return res.toString();
	}