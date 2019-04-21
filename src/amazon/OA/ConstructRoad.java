package amazon.OA;

/**
 * Created by yangw on 2019/4/19.
 */
public class ConstructRoad {
    public static void buildRoads(int n, int numRoads, int[][] roads, int numNewRoads, int[][] edges) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int[] road : roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            graph[u][v] = 0;
            graph[v][u] = 0;
        }

        for(int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            int w = edge[2];
            graph[u][v] = w;
            graph[v][u] = w;
        }

        printGraph(graph);

        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int count = 0; count < n - 1; count++) {
            int u = minKey(n, key, visited);
            visited[u] = true;

            for(int v = 0; v < n; v++) {
                if(graph[u][v] != Integer.MAX_VALUE && visited[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int cost = 0;
        for(int i = 1; i < n; i++) {
            cost += graph[parent[i]][i];
        }
        System.out.print("Total Cost: " + cost);
    }

    private static int minKey(int n, int[] key, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int v = 0; v < n; v++) {
            if(visited[v] == false && key[v] < min) {
                min = key[v];
                idx = v;
            }
        }
        return idx;
    }

    private static void printGraph(int[][] graph) {
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int numRoads = 3;
        int[][] roads = {{1,4}, {4,5}, {2,3}};
        int numNewRoads = 4;
        int[][] edges = {{1,2,5}, {1,3,10}, {1,6,2}, {5,6,5}};

        buildRoads(n, numRoads, roads, numNewRoads, edges);
    }


}
