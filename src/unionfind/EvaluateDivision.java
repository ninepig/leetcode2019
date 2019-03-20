package unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yangw on 2019/3/1.
 */
public class EvaluateDivision {

    Map<String, HashMap<String, Double>> g = new HashMap<>();
    /**
     * 399
     * Using dfs + graph to do this
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation1(String[][] equations, double[] values, String[][] queries) {
        // Using equations and values to construct the graph
        // 图 的hashmap 是图的顶点，以及每个顶点相邻的定点，以及权重边组成的。
        for(int i = 0 ; i< equations.length ; i++){
            String x = equations[i][0];
            String y = equations[i][1];
            double v = values[i];
            g.computeIfAbsent(x, lambda -> new HashMap<String, Double>()).put(y, v);
            g.computeIfAbsent(y,lambda -> new HashMap<String, Double>()).put(x,1/v);
        }
        double[] ans = new double[queries.length];
        // Using dfs to get value.
        for (int i = 0 ; i < queries.length ; i++){
            String x = queries[i][0];
            String y = queries[i][1];
            if(!g.containsKey(x)||!g.containsKey(y)){
                ans[i] = -1.0;
            }else{
                ans[i] = divide(x,y,new HashSet<String>());
            }
        }
        return ans;
    }

    /**
     * 构建一条 x 到 y 的路径， 把边的权重乘起来 / DFS
     * 如果不存在x 到 y 的路径 就返回- 1 如果 x 和 有相等 返回 1
     * @param x
     * @param y
     * @param visited
     * @return
     */
    private double divide(String x, String y, HashSet<String> visited) {
        if(x.equals(y)) return 1.0;
        visited.add(x);
        if(!g.containsKey(x)) return -1.0;
        for (String n : g.get(x).keySet()){
            if(visited.contains(n)) continue;
            visited.add(n);
            double d = divide(n,y,visited);
            if(d > 0) return d * g.get(x).get(n);
        }
        return -1.0;
    }

    class Node{
        public String parent;
        public double ratio;
        public Node(String parent, double ratio){
            this.parent = parent;
            this.ratio = ratio;
        }
    }

    class UnionFind {
        HashMap<String, Node> parents = new HashMap<>();

        public Node find(String s) {
            // 如果所有节点里没有 s ，则返回null
            if (!parents.containsKey(s)) return null;
            // 找到s的root节点
            Node n = parents.get(s);
            if (!n.parent.equals(s)) {
                Node p = find(n.parent);
                n.parent = p.parent;
                n.ratio *= p.ratio;
            }
            return n;
        }

        public void union(String s, String p, double ratio) {
            boolean hasS = parents.containsKey(s);
            boolean hasP = parents.containsKey(p);
            if (!hasS && !hasP) {
                parents.put(s, new Node(p, ratio));
                // root node point to itself
                parents.put(p, new Node(p, 1.0));
            } else if (!hasP) {
                parents.put(p, new Node(s, 1.0 / ratio));
            } else if (!hasS) {
                parents.put(s, new Node(p, ratio));
            } else {
                Node rS = find(s);
                Node rP = find(p);
                rS.parent = rP.parent;
                rS.ratio = ratio / rS.ratio * rP.ratio;
            }
        }
    }
        public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
            UnionFind u = new UnionFind();
            // 构建unionFind 集
            for(int i = 0 ; i < equations.length ; i++){
                u.union(equations[i][0],equations[i][1],values[i]);
            }
            double[] ans = new double[queries.length];
            for (int i = 0 ; i < queries.length ; i++){
                // 找到他们到达root的ratio值
                Node rx = u.find(queries[i][0]);
                Node ry = u.find(queries[i][1]);
                if(rx == null || ry == null || !rx.parent.equals(ry.parent)){
                    ans[i] = -1.0;
                }else{
                    //如果是同一点的话， 答案就是 1.0
                    ans[i] = rx.ratio / ry.ratio;
                }
            }
            return ans;
        }
}
