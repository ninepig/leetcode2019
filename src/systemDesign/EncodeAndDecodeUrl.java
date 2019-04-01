package facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangw on 2019/3/30.
 * 另外一种思路就是按照题目的要求，将长短链接进行一一映射，那么如何实现这个映射算法，
 * 才能保证编解码的唯一性呢？？我们可以使用两个Map来分别保存.
 */
public class EncodeAndDecodeUrl {
    Map<String,Integer> map1 = new HashMap<>();
    Map<Integer,String> map2 = new HashMap<>();
    String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encode1(String longUrl){
        if(!map1.containsKey(longUrl)){
            map2.put(map1.size()+1,longUrl);
            map1.put(longUrl,map2.size()+1);
        }
        int n = map1.get(longUrl);
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int r = n % 62;
            n /= 62;
            sb.insert(0,s.charAt(r));
        }
        return sb.toString();
    }

    public String decode1(String shortUrl){
        int val = 0;
        int n = shortUrl.length();
        for (int i = 0 ; i < n ; i++){
            val = val*52 + s.indexOf(shortUrl.charAt(i));
        }
        return map2.get(val);
    }
}
