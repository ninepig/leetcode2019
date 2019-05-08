package amazon;

import java.util.*;

/**
 * Created by yangw on 2019/5/7.
 */
// detect a graph can be a tree, detect ring
// undriect graph, union find
public class validGraphTree261 {
    private int[] parent;
    private int[] size;

    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }
        return edges.length == n - 1;
    }

    private boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 == p2) {
            return false;
        }
        if (size[p1] < size[p2]) {
            parent[p1] = p2;
            size[p2]++;
        } else {
            parent[p2] = p1;
            size[p1]++;
        }
        return true;
    }

    private int find(int v) {
        while (v != parent[v]) {
            parent[v] = find(parent[parent[v]]);
            v = parent[v];
        }
        return v;
    }


    public boolean validTreebfs(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[1]);
            neighbors2.add(edge[0]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(edges[0][0]);
        visited.add(edges[0][0]);
        int nodes = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;

            for (int neighbor : graph.get(node)) {
                if (queue.contains(neighbor)) {
                    return false;
                }
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;
    }

}
