package facebook;

/**
 * Created by yangw on 2019/4/10.
 */
public class StringCompression443 {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        int index = 0, indexAns = 0;
        while (index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;
            if(count != 1){
                for (char c : Integer.toString(count).toCharArray()){
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
}
