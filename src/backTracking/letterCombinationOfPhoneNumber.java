package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 17
 * number combination
 * Created by yangw on 2018/12/24.
 */
public class letterCombinationOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(digits,map,res,sb,0);
        return res;
    }

    private void helper(String digits, String[] map, List<String> res, StringBuilder sb, int pos) {
        if(sb.length() >= digits.length()){
            res.add(sb.toString());
        }else {
            String currentMap = map[Character.getNumericValue(digits.charAt(pos))];
            for(char c : currentMap.toCharArray()){
                sb.append(c);
                helper(digits,map,res,sb,pos+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }

}
