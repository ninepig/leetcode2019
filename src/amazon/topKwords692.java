package facebook;

import java.util.*;

public class topKwords692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0){
            return res;
        }
        Map<String,Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                // 最小堆， 但是如果出现数量相同的话，必须按照首字母排序。
                (a,b)-> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()):
                        a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while (!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }

        return res;
    }
}
