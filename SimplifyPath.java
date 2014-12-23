public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;
        String[] temp = path.split("/");
        //Splits this string around matches of the given regular expression.
        LinkedList<String> result = new LinkedList<String>();
        for (String s: temp){
            if (s.length() == 0 || s.equals("."))
                continue;
            else if (s.equals("..")){
                if (!result.isEmpty())
                    result.pop();
            }
            else
                result.push(s);
        }
        //has to consider the case of empty, or if path = "/", then the return is [] rather than [/]
        if (result.isEmpty())
            result.push("");
        String ans = "";
        while (!result.isEmpty()){
            ans += "/" + result.removeLast(); //Removes and returns the last element from this list.
        }
        return ans;
    }
}