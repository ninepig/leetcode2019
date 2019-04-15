package amazon;

/**
 * Created by yangw on 2019/4/3.
 */
public class LicenseKeyFormating482 {
    public String licenseKeyFormatting(String S, int K) {
        String removeDashS = S.replaceAll("-","").toUpperCase();
        StringBuilder sb = new StringBuilder(removeDashS);
        int index = sb.length() - K;
        while(index > 0){
            sb.insert(index,"-");
            index -= K ;
        }
        return sb.toString();

    }
}
