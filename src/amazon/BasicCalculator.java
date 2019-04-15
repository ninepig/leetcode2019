package amazon;

import java.util.Stack;

/**
 * Created by yangw on 2019/3/30.
 */
public class BasicCalculator {
    public int calculate(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0 , sign = 1;
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int cur = c - '0';
                while ( i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    cur = 10*cur + s.charAt(++i) -'0';
                res += sign * cur;
            }else if (c == '-')
                sign = -1;
            else if (c =='+'){
                sign = 1;
            }else if (c == '('){
                stack.push(res);
                res = 0 ;
                stack.push(sign);
                sign = 1;
            }else if(c == ')'){
                res = res * stack.pop() + stack.pop();
                sign = 1;
            }
        }
        return res;
    }
}