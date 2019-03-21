package string;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0) return 0;
        int indexAnswer = 0 , index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexAnswer++] = currentChar;
            if(count != 1){
                for(char c : Integer.toString(count).toCharArray())
                    chars[indexAnswer++] = c;
            }
        }
        return indexAnswer;
    }
}
