package amazon.MianJing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangw on 2019/5/7.
 */
public class UnDirectGraphRingDetect {

    public boolean undirectGraphDetect(int[][] edges) {
        UnionFind set = new UnionFind(2000);
        for (int[] edge: edges){
            if(!set.union(edge[0],edge[1])){
                return false;
            }
        }
        return true;
    }

    class UnionFind{
        int[] parent;
        int[] ranks;

        public UnionFind(int size){
            parent = new int[size+1];
            ranks = new int[size+1];
            for(int i = 0 ; i < size ; i++){
                parent[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int node){
            while(parent[node] != node){
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        public boolean union(int node1 , int node2){
            int node1Parent = find(node1);
            int node2Parent = find(node2);
            if(node1Parent == node2Parent) return false;
            if(ranks[node1Parent] > ranks[node2Parent]) parent[node2Parent] = node1Parent;
            else if (ranks[node1Parent] < ranks[node2Parent] ) parent[node1Parent] = node2Parent;
            else{
                parent[node1Parent] = node2Parent;
                ranks[node1Parent] += 1;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        // 使用邻接表存储图的信息
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 遍历每一条边
        for(int[] edge : edges) {
            // Each element of edges is a pair [u, v] with u < v
            int u = edge[0];
            int v = edge[1];

            // 深度优先遍历该图，判断u到v之间是否已经存在了一条路径
            boolean hasPath = dfs(graph, u, v, new ArrayList<Integer>());

            if(hasPath == true) {
                return edge;
            }
            else {
                // 将该边加入到邻接表中
                if(!graph.containsKey(u)) {
                    graph.put(u, new ArrayList<Integer>());
                }
                graph.get(u).add(v);

                if(!graph.containsKey(v)) {
                    graph.put(v, new ArrayList<Integer>());
                }
                graph.get(v).add(u);
            }
        }

        return null;
    }

    // 深度优先遍历该图，判断start到end之间是否已经存在了一条路径
    public boolean dfs(Map<Integer, List<Integer>> graph, int start, int end, List<Integer> visited) {
        if(!graph.containsKey(start) || !graph.containsKey(end)) {
            return false;
        }

        if(start == end) {
            return true;
        }

        visited.add(start);

        // 遍历start的所有相邻节点
        for(int adj : graph.get(start)) {
            if(!visited.contains(adj)) {
                if(dfs(graph, adj, end, visited) == true) {
                    return true;
                }
            }
        }

        return false;
    }

}
