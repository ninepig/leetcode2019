package algorithmbook.chapterone;

import java.util.Iterator;

/**
 * Created by yangw on 2019/3/19.
 */
public class test {
    public static void main(String ... args){
        PushdownStack test = new PushdownStack();
        Item abc = new Item("abc");
        Item bac = new Item("bac");
        Item cba = new Item("cba");
        test.push(abc);
        test.push(bac);
        test.push(cba);

        Iterator<Item> i = test.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

    }
}
