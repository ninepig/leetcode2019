package facebook;

/**
 * Created by yangw on 2019/3/23.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean ifTrue = true;
        while (ifTrue){
            for(int i = 0 ; i < strs.length ; i++){
                // 这里是<= 因为当长度等于index的时候也会出问题， 因为index 最小也是 length() - 1
                if(strs[i].length()<=index||strs[i].charAt(index)!=strs[0].charAt(index)){
//                if(strs.length <= index || strs[i].charAt(index)!= strs[0].charAt(index)){
                    ifTrue = false;
                    break;
                }
            }
            if(ifTrue){
                sb.append(strs[0].charAt(index));
                index++;
            }
        }
        return sb.toString();
    }

}
