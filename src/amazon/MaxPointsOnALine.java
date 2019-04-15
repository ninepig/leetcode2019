package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/3/29.
 */
public class MaxPointsOnALine {
    class Point{
        int x ;
        int y ;
    }
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length <= 2 ) return points.length;

        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        int result = 0 ;

        for (int i = 0 ; i < points.length ;i++){
            map.clear();
            int max = 0;
            int overlap = 0;
            for (int j = i + 1 ; j < points.length ; j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = getGcd(x,y);
                if(gcd != 0){
                    x /= gcd;
                    y /= gcd;
                }
                if(map.containsKey(x)){
                    if(map.get(x).containsKey(y)){
                        map.get(x).put(y,map.get(x).get(y)+1);
                    }else {
                        map.get(x).put(y,1);
                    }
                }else {
                    Map<Integer,Integer> subM  = new HashMap<>();
                    subM.put(y,1);
                    map.put(x,subM);
                }
                max = Math.max(max,map.get(x).get(y));
            }
            result = Math.max(result,max+overlap+1);
        }
        return result;
    }

    /**
     * 公理
     * @param x
     * @param y
     * @return
     */
    private int getGcd(int x, int y) {
        if(y == 0) return x;
        else
            return getGcd(y,x%y);
    }

}
