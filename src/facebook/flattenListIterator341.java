package facebook;

/**
 * Created by yangw on 2019/4/4.
 */
public class flattenListIterator341 {

//    List<NestedInteger> list;
//    Stack<NestedInteger> stack;
//    public flattenListIterator341(List<NestedInteger> nestedList) {
//        this.list = nestedList;
//        stack = new Stack();
//        for(int i = nestedList.size() - 1 ; i >= 0 ; i--){
//            stack.push(nestedList.get(i));
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return stack.pop().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while(!stack.isEmpty()){
//            NestedInteger temp  = stack.pop();
//            if(temp.isInteger){
//                return true;
//            }
//            for(int i = temp.getList().size() - 1 ; i>=0 ; i--){
//                stack.push(temp.getList().get(i));
//            }
//        }
//        return false;
//    }
}
