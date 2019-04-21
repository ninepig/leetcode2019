package amazon.OA;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yangw on 2019/4/20.
 *
 * https://www.techiedelight.com/lee-algorithm-shortest-path-in-a-maze/
 */
public class shortestPathOfMazeBfs {
    static int[][] one = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };//上下左右移动坐标的变化
    static String[] nextpath = { "U", "D", "L", "R" };//上下左右移动的表示

    static class point {//点类记录当前坐标，步数，路径
        int x, y, step;//step表示从出发到当前点经过几步
        String path;//path表示从出发到当前点经过路径

        public point(int x, int y, int step, String path) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.path = path;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 3;
        int m = 3;
        int[][] mazeArray = {{0,1,1},{1,0,1},{1,1,1}};
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                mazeArray[i][j] = in.nextInt();
//            }
//        }
        bfs(mazeArray, n, m);
    }

    //按字典序较小选择路径
    public static boolean comparePath(String A, String B) {
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();
        for (int i = 0, len = A.length(); i < len; i++) {
            if (arrayA[i] < arrayB[i])
                return false;
        }
        return true;
    }

    //判断点是否出界或被访问过
    public static boolean validatePoint(int[][] matrix, point a) {
        int n = matrix.length - 1, m = matrix[0].length - 1;
        if (a.x < 0 || a.x > n || a.y < 0 || a.y > m || matrix[a.x][a.y] == 1)
            return false;
        return true;
    }

    //搜索
    static void bfs(int[][] mazeArray, int n, int m) {
        ArrayList<point> list = new ArrayList<point>();
        list.add(new point(0, 0, 0, ""));//向队列中加入第一个点
        int minStep = Integer.MAX_VALUE;//最小步数
        String minPath = "";//最短路径
        while (list.size() != 0) {
            point currentPoint = list.get(0);//当队列中有点时，取出点比较是否为终点
            list.remove(0);//删除该点
            if (currentPoint.x == n - 1 && currentPoint.y == m - 1) {
                if (minStep > currentPoint.step) {
                    minStep = currentPoint.step;
                    minPath = currentPoint.path;
                } else if (minStep == currentPoint.step) {
                    if (comparePath(minPath, currentPoint.path)) {
                        minPath = currentPoint.path;
                    }
                }
                continue;

            }
            //如果不是终点，依次尝试访问上下左右，并加入队列继续循环
            for (int i = 0; i < 4; i++) {
                int x = currentPoint.x + one[i][0];
                int y = currentPoint.y + one[i][1];
                int step = currentPoint.step + 1;
                String path = currentPoint.path + nextpath[i];
                point nextPoint = new point(x, y, step, path);
                if (validatePoint(mazeArray, nextPoint)) {
                    list.add(nextPoint);
                    mazeArray[x][y] = 1; //mark as 1 to bypass select next time
                }
            }
        }
        System.out.println(minPath + "\n" + minStep);//循环结束输出最短步数及路径
        return;
    }

}
