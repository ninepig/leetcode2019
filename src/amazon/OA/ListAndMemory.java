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
                a.get(1) - b.get(1)
                ));

        Collections.sort(List2,(a,b)->(
                a.get(1) - b.get(1)
        ));

        List<pair> helper = new ArrayList<>();
        for (int i = 0 ; i < List1.size() ; i++){
            for (int j = 0 ; j < List2.size() ; j++){
                if(List1.get(i).get(1) + List2.get(j).get(1) <= k){
                    helper.add(new pair(List1.get(i).get(1) + List2.get(j).get(1),i,j));
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
                res.add(Arrays.asList(helper.get(i).firstIndex + 1,helper.get(i).secondIndex + 1));
                max = helper.get(i).sum;
            }else if(helper.get(i).sum == max){
                res.add(Arrays.asList(helper.get(i).firstIndex + 1,helper.get(i).secondIndex + 1));
            }
        }
        return res;
    }
    public static void main(String ...args){
            List<List<Integer>> list1 = new ArrayList<>();
            List<List<Integer>> list2 = new ArrayList<>();
            int k = 5;
            list1.add(Arrays.asList(1,4));
            list1.add(Arrays.asList(2,1));
            list1.add(Arrays.asList(3,2));
            list2.add(Arrays.asList(3,1));

            List<List<Integer>> res = getIndex(5,list1,list2);

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
    int secondIndex;
    public pair(int sum, int firstIndex, int secondIndex){
        this.sum = sum;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }
}
