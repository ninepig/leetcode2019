package facebook;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by yangw on 2019/4/4.
 */
public class maxStack716 {
    PriorityQueue<Integer> maxHeap;
    Stack<Integer> stack;
    public maxStack716(){
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        stack = new Stack<>();
    }
    public void push(int x) {
        maxHeap.offer(x);
        stack.push(x);
    }

    public int pop() {
        maxHeap.remove(stack.peek());
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxHeap.peek();
    }

    // 要注意的点
    public int popMax() {
       int max = maxHeap.poll();
       Stack<Integer> temp = new Stack<>();
       while (stack.peek()!= max){
           temp.push(stack.pop());
       }
       stack.pop();
       while (!temp.isEmpty()){
           stack.push(temp.pop());
       }
       return max;
    }
}
