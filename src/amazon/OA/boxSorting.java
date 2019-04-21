package amazon.OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangw on 2019/4/21.
 */
public class boxSorting {

    public static List<String>  orderBox(int numberOfBox, List<String> boxList){

        if(boxList == null || numberOfBox == 0) return boxList;

        // Check new or old box and put them into two List
        List<String> newBox = new ArrayList<>();
        List<String> oldBox = new ArrayList<>();

        for (int i = 0 ; i< numberOfBox ; i++){
            String[] currentBox = boxList.get(i).split("\\s+");
                if(currentBox[1].charAt(0)>='0' && currentBox[1].charAt(0)<='9') {
                    newBox.add(boxList.get(i));
                }else {
                    oldBox.add(boxList.get(i));
            }
        }

        // Sort the old box one
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');
//                char c1 = s1.charAt(index1 + 1);
//                char c2 = s2.charAt(index2 + 1);
// 旧版后面只有英文 不会有数字
//                if(c1 >= '0' && c1 <= '9') {
//                    if(c2 >= '0' && c2 <= '9') {
//                        return 0;
//                    } else {
//                        return 1;
//                    }
//                } else if(c2 >= '0' && c2 <= '9') {
//                    return -1;
//                }

                int idOrder = s1.substring(index1 + 1).compareTo(s2.substring(index2 + 1));
                if(idOrder == 0) {
                    return s1.substring(0, index1).compareTo(s2.substring(0, index2));
                }
                return idOrder;
            }
        };
        Collections.sort(oldBox,myComparator);
        oldBox.addAll(newBox);
        return oldBox;
    }

    public static void main(String[] args){

        List<String> input= new ArrayList<>();
//        ,"eo first qpx","09z cat hamster","06f 12 25 6","az0 first qpx","236 cat dog rabbit snake"
        input.add("ykc 82 01");
        input.add("eo first qpx");
        input.add("09z cat hamster");
        input.add("06f 12 25 6");
        input.add("az0 first qpx");
        input.add("236 cat dog rabbit snak");
        for (String res : orderBox(6,input)){
            System.out.println(res);
        }
    }
}
