package facebook;

/**
 * Created by yangw on 2019/4/2.
 */
public class countAndSay038 {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        StringBuilder preSb = new StringBuilder(),curSb = new StringBuilder();

        curSb.append("1");
        for (int i = 2 ; i <= n ; i++){
            preSb = curSb;
            int count = 1;
            char say = preSb.charAt(0);
            curSb = new StringBuilder();

            for (int j = 1 ; j < preSb.length() ; j++){
                if(say == preSb.charAt(j)){
                    count++;
                }else{
                    curSb.append(count).append(say);
                    count = 1;
                    say = preSb.charAt(j);
                }
            }
            curSb.append(count).append(say);
        }
        return curSb.toString();
    }
}
