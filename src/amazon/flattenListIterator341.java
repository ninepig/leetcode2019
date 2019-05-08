package amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by yangw on 2019/4/4.
 */
public class flattenListIterator341 implements Iterator{

    List<NestedInteger> list;
    Stack<NestedInteger> stack;
    public flattenListIterator341(List<NestedInteger> nestedList) {
        this.list = nestedList;
        stack = new Stack();
        for(int i = nestedList.size() - 1 ; i >= 0 ; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger temp  = stack.pop();
            if(temp.isInteger()){
                return true;
            }
            for(int i = temp.getList().size() - 1 ; i>=0 ; i--){
                stack.push(temp.getList().get(i));
            }
        }
        return false;
    }

}

 interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
