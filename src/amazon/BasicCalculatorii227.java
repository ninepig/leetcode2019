package amazon;

import java.util.Stack;

/**
 * Created by yangw on 2019/3/31.
 */
public class BasicCalculatorii227 {
    public int calculate(String s) {
        if( s == null || s.length() == 0)return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        for (int i = 0 ; i < len ; i++){
            char cur = s.charAt(i);
            if(Character.isDigit(cur)){
                res = res * 10 + cur - '0';
            }
            if((!Character.isDigit(cur)) && s.charAt(i) != ' '|| i == len -1 ){
                if(sign == '-'){
                    stack.push(-res);
                }
                if(sign == '+'){
                    stack.push(res);
                }
                if(sign == '*'){
                    stack.push(res*stack.pop());
                }
                if(sign == '/'){
                    stack.push(stack.pop()/res);
                }
                sign = cur;
                res = 0;
            }
        }
        int result = 0;
        for (int i : stack){
            result += i;
        }
        return result;
    }

}
