package facebook;

import java.util.Stack;

/**
 * Created by yangw on 2019/3/31.
 */
public class minStack155 {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public minStack155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals( minStack.peek())){
            stack.pop();
            minStack.pop();
        }else{
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }


    int min = Integer.MAX_VALUE;
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push2(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop2() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top2() {
        return stack.peek();
    }

    public int getMin2() {
        return min;
    }

}
