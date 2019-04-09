package facebook;

import java.util.Stack;

public class BasicCalculatorIII772 {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0 , pre = 0 , i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                pre = pre * 10 + c - '0' ;
            }
        }

    }

}
