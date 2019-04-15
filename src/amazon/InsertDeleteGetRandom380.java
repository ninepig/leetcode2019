package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by yangw on 2019/4/3.
 */
public class InsertDeleteGetRandom380 {

    HashMap<Integer,Integer> helperMap ;
    ArrayList<Integer> helperList;
    Random random;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandom380() {
        helperMap = new HashMap<>();
        helperList = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(helperMap.containsKey(val)){
            return false;
        }
        // val + lastIndex of array
        helperMap.put(val,helperList.size());
        helperList.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // put the target val to the end of array. then remove it
    public boolean remove(int val) {
        if(!helperMap.containsKey(val)){
            return false;
        }
        // 用最后一个位置的value,代替要删除的值，同时更新map
        int location = helperMap.get(val);
        if(location < helperList.size()-1) {
            // Last one's value
            int lastValue = helperList.get(helperList.size() - 1);
            helperList.set(location,lastValue);
            helperMap.put(lastValue,location);
        }
        helperList.remove(helperList.size()-1);
        helperMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // 返回 0---n 之间的某个数
        return helperList.get(random.nextInt(helperList.size()));
    }
}
