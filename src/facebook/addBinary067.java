package facebook;

/**
 * Created by yangw on 2019/4/5.
 */
public class addBinary067 {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = sum / 2;
            res.append(sum % 2);//if don't use StringBuilder,we can use res=String.valueOf(sum%2)+res,then no need to reverse
        }
        if (carry == 1) {//remember to check whether carry != 0
            res.append(1);
        }
        return res.reverse().toString();//append&reverse,instead of inserting at front cuz sb is array-based,insert will be
    }//very time-consuming
}
