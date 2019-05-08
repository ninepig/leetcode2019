package amazon.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yangw on 2019/4/21.
 */
public class ListAndMemory {

    public static List<List<Integer>> getIndex(int k , List<List<Integer>> List1 , List<List<Integer>> List2){

        Collections.sort(List1,(a,b)->(
                 b.get(1) - a.get(1)
                ));

        Collections.sort(List2,(a,b)->(
                b.get(1) - a.get(1)
        ));



        List<pair> helper = new ArrayList<>();
        for (int i = 0 ; i < List1.size() ; i++){
            for (int j = 0 ; j < List2.size() ; j++){
                if(List1.get(i).get(1) + List2.get(j).get(1) <= k){
                    helper.add(new pair(List1.get(i).get(1) + List2.get(j).get(1),List1.get(i).get(0),List2.get(j).get(0)));
                }else{
                   break;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i < helper.size() ; i++){
            if(helper.get(i).sum > max){
                res.clear();
                res.add(Arrays.asList(helper.get(i).firstIndex ,helper.get(i).secondIndex ));
                max = helper.get(i).sum;
            }else if(helper.get(i).sum == max){
                res.add(Arrays.asList(helper.get(i).firstIndex ,helper.get(i).secondIndex ));
            }
        }
        return res;
    }
    public static void main(String ...args){
            List<List<Integer>> list1 = new ArrayList<>();
            List<List<Integer>> list2 = new ArrayList<>();
            list1.add(Arrays.asList(1,8));
            list1.add(Arrays.asList(2,15));
            list1.add(Arrays.asList(3,9));
//        list1.add(Arrays.asList(4,10));
            list2.add(Arrays.asList(1,8));
        list2.add(Arrays.asList(2,11));
        list2.add(Arrays.asList(3,12));


            List<List<Integer>> res = getIndex(20,list1,list2);

        System.out.println("   ");
        System.out.println("   ");
            for (List<Integer> r : res){
                System.out.println(r.get(0)+" sec" + r.get(1));
            }

    }
}

class memory{
    int index;
    int value;
}
class pair{
    int sum;
    int firstIndex;

    @Override
    public String toString() {
        return "pair{" +
                "sum=" + sum +
                ", firstIndex=" + firstIndex +
                ", secondIndex=" + secondIndex +
                '}';
    }

    int secondIndex;
    public pair(int sum, int firstIndex, int secondIndex){
        this.sum = sum;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

}
