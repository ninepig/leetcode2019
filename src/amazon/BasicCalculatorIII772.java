package amazon;

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
            if(c == '('){
                int j = findClosing(s.substring(i));
                pre = calculate(s.substring(i+1,i+j));
                i += j;
            }
            if( i == s.length() - 1 || !Character.isDigit(c)) {
                switch (sign) {
                    case '+':
                        stack.push(pre);
                        break;
                    case '-':
                        stack.push(-pre);
                        break;
                    case '*':
                        stack.push(stack.pop() * pre);
                        break;
                    case '/':
                        stack.push(stack.pop() / pre);
                        break;
                }
                pre = 0;
                sign = c;
            }
        }
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    private int findClosing(String substring) {
        int level = 0 , i = 0;
        for (i = 0 ; i < substring.length();i++){
            if(substring.charAt(i) == '(') level++;
            else if(substring.charAt(i) == ')'){
                level--;
                if(level == 0) break;
            }else{
                continue;
            }
        }
        return i;
    }

}
