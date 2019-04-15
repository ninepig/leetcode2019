package amazon;

import java.util.Stack;

/**
 * Created by yangw on 2019/4/11.
 */
public class reversePolitishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> s = new Stack();

        for (String token : tokens){

            if(token.equals("+")){
                s.push(s.pop() - s.pop());
            }else if(token.equals("-")){
                int a = s.pop();
                int b = s.pop();
                s.push(b - a);
            }else if (token.equals("*")){
                s.push(s.pop()*s.pop());
            }else if(token.equals("/")){
                int a = s.pop();
                int b = s.pop();
                s.push(b / a);
            }else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();

    }
}
