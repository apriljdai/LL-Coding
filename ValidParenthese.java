public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> valid = new HashMap<Character, Character>();
        valid.put('(',')');
        valid.put('{','}');
        valid.put('[',']');
        //Stack class represents a last-in-first-out (LIFO) stack of objects.
        char[] sToArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char i: sToArray){
            if (valid.keySet().contains(i))//Returns a Set view of the keys contained in this map.
                stack.push(i);//Pushes an item onto the top of this stack.
            else if(valid.values().contains(i)){//Returns a Collection view of the values contained in this map.
                if(!stack.isEmpty() && valid.get(stack.peek()) == i)
                    //Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
                    //Looks at the object at the top of this stack without removing it from the stack.
                    stack.pop();
                //Removes the object at the top of this stack and returns that object as the value of this function.
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}