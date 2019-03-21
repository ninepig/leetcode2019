package algorithmbook.chapterone;

import java.util.Iterator;

/**
 * Created by yangw on 2019/3/19.
 * 利用数组实现的栈
 */
public class PushdownStack implements  Iterable<Item>{
    private  Item[] a =  new Item[1];
    private int N = 0;
    public boolean isEmpty(){ return N == 0;}
    public int size() {return N;}

    private void resize(int max){
        // Move stack to a new Array of size max.
        Item[] temp =  new Item[max];
        for(int i = 0 ; i < N ; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if(N == a.length){resize(a.length*2);}
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements  Iterator<Item>{
        private  int i = N;
        @Override
        public boolean hasNext() {
           return i > 0 ;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
