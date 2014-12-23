public class Solution {
    public int evalRPN(String[] tokens) {
        int val = 0;
        if (tokens == null || tokens.length == 0)
            return val;
        Stack<String> num = new Stack<String>();
        String operator = "+-*/";
        for (String t: tokens){
            if (!operator.contains(t))
                num.push(t);
            else{
                int num1 = Integer.valueOf(num.pop());//string integer convert
                int num2 = Integer.valueOf(num.pop());
                switch(t){
                    case "+":
                        num.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        num.push(String.valueOf(num2 - num1));
                        break;
                    case "*":
                        num.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        num.push(String.valueOf(num2 / num1));
                        break;
                }
            }
        }
        val = Integer.valueOf(num.pop());
        return val;
    }
}