package amazon;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangw on 2019/4/14.
 */
public class BipartiteGraph785 {
    public boolean isBipartiteDfs(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            // Regarding current point, check if the neighbour has same color with him. set his color to 1.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;

    }

    /**
     * DFS, first check if current node has color, it should be same color as our designed
     * if not has color, set its color
     * check its neighbours' color. if the color is same. return false.
     *
     * @param graph
     * @param colors
     * @param color
     * @param node
     * @return
     */
    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartitebfs(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0 ; i < len ; i++){
            if(colors[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;

            while (!q.isEmpty()){
                int cur = q.poll();
                for (int next :graph[cur]){
                    if(colors[next] == 0){
                        colors[next] = -colors[cur];
                        q.offer(next);
                    }else if(colors[next] != -colors[cur]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

