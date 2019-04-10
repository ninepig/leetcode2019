package facebook;

/**
 * Created by yangw on 2019/4/10.
 */
public class compareVersion165 {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        int length = Math.max(levels1.length,levels2.length);

        for(int i = 0 ; i < length ; i++){
            Integer current1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer current2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;

            int compare = current1.compareTo(current2);
            if(compare != 0){
                return compare;
            }
        }
        return 0;
    }
}
