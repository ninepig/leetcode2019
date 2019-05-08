package amazon.MianJing;

import sun.misc.Queue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangw on 2019/5/7.
 */
public class DirectGraphRingDetect {

    public boolean topoLogicDetecingRing(int[][] graph){
        if(graph == null || graph.length == 0) return false;

        int num = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        int[] indegree =  new int[graph.length];

        for (int i = 0 ; i < graph.length ;i++){
            for(int j = 0 ; j < graph[0].length ;j++){
                if(graph[i][j] == 1){
                    indegree[j]++;
                }
            }
        }
        // offer the node whose indegree is 0
        for (int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int vertic = queue.poll();
            num++;
            for(int j = 0;j <graph.length;j++){
                if(graph[vertic][j] == 1){
                    indegree[j] -= 1;
                    if(indegree[j] == 0){
                        queue.offer(j);
                    }
                }
            }
        }
        // This mean it exists the node whose indegee is still 1 . so it must have a ring.
        if(num != graph.length) return false;
        return  true;
    }

    // assuming it will be empty if there is no indegree.
    // 不太可能， 肯定是临街矩阵。
//    public boolean topoLogicDetecingRing( List<List<Integer>> matrix ) {
//        int num = 0;
//        LinkedList<Integer> queue = new LinkedList<>();
//
//        int[] indegree =  new int[matrix.size()];
//        for (int i = 0 ; i < indegree.length ; i++){
//            indegree[0] = matrix.get()
//        }
    }

