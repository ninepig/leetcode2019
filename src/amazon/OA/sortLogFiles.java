package amazon.OA;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yangw on 2019/4/20.
 */
public class sortLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');
                char c1 = s1.charAt(index1 + 1);
                char c2 = s2.charAt(index2 + 1);

                if(c1 >= '0' && c1 <= '9') {
                    if(c2 >= '0' && c2 <= '9') {
                        return 0;
                    } else {
                        return 1;
                    }
                } else if(c2 >= '0' && c2 <= '9') {
                    return -1;
                }

                int idOrder = s1.substring(index1 + 1).compareTo(s2.substring(index2 + 1));
                if(idOrder == 0) {
                    return s1.substring(0, index1).compareTo(s2.substring(0, index2));
                }
                return idOrder;
            }
        };

        Arrays.sort(logs, myComparator);
        return logs;
    }

    public static List<String> reorderLogFiles(List<String> logs) {
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index1 = s1.indexOf(' ');
                int index2 = s2.indexOf(' ');
                char c1 = s1.charAt(index1 + 1);
                char c2 = s2.charAt(index2 + 1);

                if(c1 >= '0' && c1 <= '9') {
                    if(c2 >= '0' && c2 <= '9') {
                        return 0;
                    } else {
                        return 1;
                    }
                } else if(c2 >= '0' && c2 <= '9') {
                    return -1;
                }

                int idOrder = s1.substring(index1 + 1).compareTo(s2.substring(index2 + 1));
                if(idOrder == 0) {
                    return s1.substring(0, index1).compareTo(s2.substring(0, index2));
                }
                return idOrder;
            }
        };

        Collections.sort(logs, myComparator);
        return logs;
    }

    public static void main(String[] ars) {
//        String[] a = new String[]{};
        List<String> a = Arrays.asList("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo");
        for (String b : reorderLogFiles(a)) {
            System.out.println(b);
        }
    }
}
