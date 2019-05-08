package amazon.MianJing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangw on 2019/5/7.
 */
public class distanceOfTwoPoint {
    // without weight , we use bfs
    public int distanceBetweenTwoCitiesWithOutWeight(int[][] cityGraph, int start, int end) {
        if (cityGraph == null || cityGraph.length == 0) {
            return 0;
        }
        int[] visited = new int[cityGraph.length];
        int sum = 0;
        LinkedList<city> queue = new LinkedList<>();
        queue.offer(new city(start, 0));
        visited[start] = 1;
        boolean flag = false;
        int mark = 0;

        while (!queue.isEmpty()) {
            city curCity = queue.poll();
            for (int i = 0; i < cityGraph[curCity.x].length; i++) {
                if (cityGraph[curCity.x][i] == 1 && visited[i] == 0) {
                    mark = i;
                    sum = curCity.s + 1;
                    queue.offer(new city(i, sum));
                    visited[i] = 1;
                }
                if (mark == end) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return sum;
    }

    class city {
        int x;
        int s;

        city(int x, int s) {
            this.x = x;
            this.s = s;
        }
    }

    int min = 0;

    public int distanceBetweenTwoCitiesWithWeight(int[][] cityGraph, int start, int end) {
        if (cityGraph == null || cityGraph.length == 0) return 0;
        int[] visisted = new int[cityGraph.length];
        dfs(cityGraph, start, end, visisted, 0);

        return min;
    }

    private void dfs(int[][] cityGraph, int cur, int end, int[] visisted, int dis) {
        // if current distance is bigger than the current minimum,  return
        if (dis > min) {
            return;
        }
        // if it is the target city, and update the minvalue
        if(cur == end){
            if(dis < min){
                min  = dis;
                return ;
            }
        }
        /**
         * 当前点到其他各点之间可连通但是还未添加进来时，遍历执行
         * */
        for (int i = 1; i <= cityGraph.length; i++) {
            if (cityGraph[cur][i] != 99999999 && visisted[i] == 0) {
                visisted[i] = 1;
                dfs(cityGraph,i,end,visisted,dis+cityGraph[cur][i]);
                visisted[i] = 0;
            }
        }
        return ;

    }
}
