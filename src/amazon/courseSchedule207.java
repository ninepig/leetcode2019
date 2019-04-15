package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangw on 2019/4/9.
 */
public class courseSchedule207 {
    public boolean canFinishBfs(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0 ; i < numCourses ; i++){
            matrix.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int i = 0 ; i < prerequisites.length ; i++){
            // Constructing graph
            matrix.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        LinkedList<Integer>queue = new LinkedList<>();
        for (int i = 0 ; i < numCourses ; i++){
            // Begin point
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = numCourses;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            // if indegree == 0 ， get into queue.
            for (int node : matrix.get(cur)){
                if(--inDegree[node] == 0){
                    queue.offer(node);
                }
            }
            count--;
        }
        return count == 0;
    }

    public boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0 ; i < numCourses; i++){
            graph[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0 ; i < prerequisites.length ;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0 ; i < numCourses ; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        // ring detected
        if(visited[course]) return false;
        else
            visited[course] = true;
        for (int i = 0 ; i < graph[course].size();i++){
            if(!dfs(graph,visited, (int) graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

}
