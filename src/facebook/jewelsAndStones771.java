package facebook;

/**
 * Created by yangw on 2019/3/25.
 */
public class jewelsAndStones771 {
    public int numJewelsInStones(String J, String S) {
        // A --- z  58
        int[] map = new int[58];
        int count = 0;
        for(char stone : S.toCharArray()){
            map[stone - 'A']++;
        }
        for(char jewel : J.toCharArray()){
            count += map[jewel - 'A'];
        }


        return count;
    }
}
