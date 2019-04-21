package amazon.OA;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangw on 2019/4/20.
 *
 *
 */
public class ConstructRoadUnionPq {


    class Connection{
        int city1;
        int city2;
        int cost;
        public Connection(int city1,int city2,int cost){
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    class UnionFind{
       private int[] ids;

       public UnionFind(int size){
           this.ids = new int[size + 1];
           for (int i = 0 ; i < size + 1 ;i++){
               this.ids[i] = i;
           }
       }

       public int root(int i){
           while(ids[i] != i){
               i = ids[i];
           }
           return i;
       }

       public boolean find(int i , int j){
           return root(i) == root(j);
       }

       public void union(int i, int j){
           int rooti = root(i);
           int rootj = root(j);
           ids[rooti] = rootj;
       }
    }

    public static void main(String ... args){
        ConstructRoadUnionPq test = new ConstructRoadUnionPq();
        int totalCities = 6;
        int totalARoad = 3;
        int numNewContruct = 4;
        List<List<Integer>> roads = new ArrayList<>();
        roads.add(Arrays.asList(1,4));
        roads.add(Arrays.asList(4,5));
        roads.add(Arrays.asList(2,3));

        List<List<Integer>> newRoads = new ArrayList<>();
        newRoads.add(Arrays.asList(1,2,5));
        newRoads.add(Arrays.asList(1,3,10));
        newRoads.add(Arrays.asList(1,6,2));
        newRoads.add(Arrays.asList(5,6,5));

//        System.out.println(test.getMinimumCostToConstruct(6,3,roads,
//                4,newRoads));
        System.out.println(test.getMinimumCostToRepair(6,3,roads,
                4,newRoads));
    }

    public int getMinimumCostToConstruct(int numTotalAvailableCities,
                                         int numTotalAVailableRoads,
                                         List<List<Integer>> roadsAvailable,
                                         int numNewRoadsConstruct,
                                         List<List<Integer>> costNewRoadsConstruct){

        if(numTotalAvailableCities < 2 || numTotalAVailableRoads >= numTotalAvailableCities - 1) {
            return 0;
        }
        UnionFind uf = new UnionFind(numTotalAvailableCities);

        int existingRoadCount = 0;

        for (List<Integer> road : roadsAvailable){
            int city1 = road.get(0);
            int city2 = road.get(1);
            if(!uf.find(city1,city2)){
                uf.union(city1,city2);
                existingRoadCount++;
            }
        }

        // 可以用collection sort 替代PQ 一样是nlogn
        PriorityQueue<Connection> pq = new PriorityQueue<>(numNewRoadsConstruct,
                (a ,b) -> (Integer.compare(a.cost,b.cost))
        );

        for (List<Integer> newRoad : costNewRoadsConstruct){
            Connection newConnection = new Connection(newRoad.get(0),newRoad.get(1),newRoad.get(2));
            pq.offer(newConnection);
        }

        List<Connection> mst = new ArrayList<>();

        while (pq.size() > 0 && mst.size() + existingRoadCount < numTotalAvailableCities - 1){
            Connection temp = pq.poll();
            int city1 = temp.city1;
            int city2 = temp.city2;
            if(!uf.find(city1,city2)){
                uf.union(city1,city2);
                mst.add(temp);
            }
        }
        // Can not reach all cities.
        if(mst.size() + existingRoadCount < numTotalAvailableCities - 1){
            return -1;
        }

        int sum = 0;

        for (Connection cn : mst){
            sum += cn.cost;
        }

        return sum;
    }

    public int getMinimumCostToRepair(int numTotalAvailableCities,
                                         int numTotalAvailableRoads,
                                         List<List<Integer>> roadsAvailable,
                                         int numNewRoadsToBeRepaired,
                                         List<List<Integer>> costRoadsToBeRepaired) {

        if(numTotalAvailableCities < 2 || numTotalAvailableRoads >= numTotalAvailableCities - 1) {
            return 0;
        }
        UnionFind uf = new UnionFind(numTotalAvailableCities);

        int res = 0;

        // Sort List by cost number.
        Collections.sort(costRoadsToBeRepaired,(a,b) -> a.get(2) - b.get(2));

        Set<String> set = new HashSet<>();
        for (List<Integer> road : costRoadsToBeRepaired){
            set.add(road.get(0) + "," + road.get(1));
        }

        int roadCount = 0;

        for (List<Integer> road : roadsAvailable){
            String key = road.get(0) + "," + road.get(1);
            if(set.contains(key)){
                continue;
            }
            if(!uf.find(road.get(0),road.get(1))){
                uf.union(road.get(0),road.get(1));
                roadCount += 1;
            }
        }

        if(roadCount >= numTotalAvailableCities - 1){
            return 0;
        }

        for (List<Integer> road : costRoadsToBeRepaired){
            int a = road.get(0) , b = road.get(1);
            if(!uf.find(a,b)){
                roadCount += 1;
                res+= road.get(2);
            }
            if(roadCount >= numTotalAvailableCities - 1){
                return res;
            }
        }
        return -1;
    }

}
