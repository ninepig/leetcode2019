package unionfind;

/**
 * Created by yangw on 2019/3/1.
 * 684  https://leetcode.com/problems/redundant-connection/
 * Tag: Union find
 * 用来找是否存在环的必杀技。 可以在 amortized o（1）的时间之中完成 find以及merge的过程
 */
public class RedundantConnection {
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
            if(ranks[node1Parent] > ranks[node2Parent]) parent[node1Parent] = node2Parent;
            else if (ranks[node1Parent] < ranks[node2Parent] ) parent[node2Parent] = node1Parent;
            else{
                parent[node1Parent] = node2Parent;
                ranks[node1Parent] += 1;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
            UnionFind set = new UnionFind(2000);
            for (int[] edge: edges){
                if(!set.union(edge[0],edge[1])){
                    return edge;
                }
            }
            return new int[]{};
    }
}
