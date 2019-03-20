package api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/3/1.
 */
public class newApiLearned {
    public static void main(String ... args){

        Map<String, HashMap<String, Double>> g = new HashMap<>();
        // 这个put 是基于你getValue("abc")以后的hashmap来操作的
        // 也就是如果abc 没有存在的话，进行lambda操作 创建一个新的hashmap
        g.computeIfAbsent("abc",lambda -> new HashMap<String,Double>()).put("abc",1.0);

    }
}
