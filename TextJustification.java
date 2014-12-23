public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if (words == null || words.length == 0)
            return res;
        int len = 0, space = 0;
        for (int i = 0; i < words.length; i++){
            if (len + words[i].length() + (i - space) > L){
                int spaceNum = 0, extraNum = 0;
                if (i - space - 1 > 0){
                    spaceNum = (L - len) / (i - space - 1); //calculate length of each space
                    extraNum = (L - len) % (i - space - 1); //check if each space length could be equal
                }
                StringBuilder sb = new StringBuilder();
                for (int j = space; j < i; j++){
                    sb.append(words[j]);
                    if (j < i - 1){
                        for (int k = 0; k < spaceNum; k++)
                            sb.append(" ");
                        if (extraNum > 0){
                            sb.append(" ");
                            extraNum--;
                        }
                    }
                }
                //the case of when sb has only one word which its length is less then L
                for (int j = sb.length(); j < L; j++)
                    sb.append(" ");
                res.add(sb.toString());
                len = 0;
                space = i;
            }
            len += words[i].length();
        }
        StringBuilder last = new StringBuilder();
        for (int i = space; i < words.length; i++){
            last.append(words[i]);
            if (last.length() < L)
                last.append(" ");
        }
        for (int i = last.length(); i < L; i++){
            last.append(" ");
        }
        res.add(last.toString());
        return res;
    }
}