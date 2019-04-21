package amazon.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/4/19.
 * 这个题和music 那道一模一样 没区别的
 */
public class TruckSpace {
    static ArrayList<Integer> IDsOfPackages(int truckSpace,
                                            ArrayList<Integer> packagesSpace)
    {
        // WRITE YOUR CODE HERE
        int space = truckSpace - 30;
        ArrayList<Integer> res = new ArrayList<>();
        if(space < 0) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < packagesSpace.size(); i++) {
            int diff = space - packagesSpace.get(i);
            if(map.containsKey(diff)) {
                if(diff > max || packagesSpace.get(i) > max) {
                    res.clear();
                    res.add(map.get(diff));
                    res.add(i);
                }
            }
            map.put(packagesSpace.get(i), i);
        }
        return res;
    }

    public static void main(String[] args) {
        int s= 90;
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(10);
        nums.add(25);
        nums.add(35);
        nums.add(50);
        nums.add(60);
        System.out.print(IDsOfPackages(s, nums));
    }
}
