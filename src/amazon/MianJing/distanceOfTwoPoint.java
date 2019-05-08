package amazon.MianJing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yangw on 2019/5/7.
 */
public class distanceOfTwoPoint {
    // without weight , we use bfs
    public int distanceBetweenTwoCitiesWithOutWeight(int[][] cityGraph,int start , int end){
        if(cityGraph == null || cityGraph.length == 0){
            return 0;
        }
        int[] visited = new int[cityGraph.length];
        int sum = 0;
        LinkedList<city> queue = new LinkedList<>();
        queue.offer(new city(start,0));
        visited[start] = 1;
        boolean flag = false;
        int mark = 0;

        while (!queue.isEmpty()){
            city curCity = queue.poll();
            for (int i = 0 ; i < cityGraph[curCity.x].length ; i++){
                if(cityGraph[curCity.x][i] == 1 && visited[i] == 0){
                    mark =  i;
                    sum = curCity.s + 1;
                    queue.offer(new city(i,sum));
                    visited[i] = 1;
                }
                if(mark == end){
                    flag = true;
                    break;
                }
            }
            if(flag){
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
}
