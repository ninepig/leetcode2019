package stack;

import java.util.Stack;

/**
 * Category : Stack , Math
 * Leetcode 224 basic calculator
 * https://leetcode.com/problems/basic-calculator/
 * Using stack to solve this question.
 * When there is keeping showing integer, we cacluate the integer's sum (with '+' and '-')
 * if there is sign, we change to sum or minus,
 * When we meet ( , we push the result into stack, when we see ), pop out the result.
 */
public class BasicCaculator {

    public int calculate(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length(),sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < len ; i++){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i)-'0';
                while (i+1 < len && Character.isDigit(s.charAt(i+1))){
                    sum = sum*10 + s.charAt(i)-'0';
                    i++;
                }
                result += sum*sign;
            }else if (s.charAt(i) == '+'){
                sign = 1;
            }else if(s.charAt(i) =='-'){
                sign = -1;
            }else if(s.charAt(i) == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(s.charAt(i)==')'){
                result = result*stack.pop() + stack.pop();
            }
        }
        return result;
    }



    //    public int calculate(String s) {
//        int len = s.length(),sign = 1, result = 0;
//        Stack<Integer> stack = new Stack();
//        for(int i = 0 ; i < len ;i++){
//            if(Character.isDigit(s.charAt(i))){
//                int sum = s.charAt(i) - '0';
//                while(i + 1 < len && Character.isDigit(s.charAt(i+1))){
//                    sum = sum*10 + s.charAt(i+1) - '0';
//                    i++;
//                }
//                result += sum*sign;
//            }else if (s.charAt(i) == '+'){
//                sign = 1;
//            }else if (s.charAt(i) == '-'){
//                sign = -1;
//            }else if (s.charAt(i) == '('){
//                stack.push(result);
//                stack.push(sign);
//                result = 0 ;
//                sign = 1;
//            }else if (s.charAt(i) == ')'){
//                result = result * stack.pop() +stack.pop();
//            }
//        }
//        return result;
//    }
}
