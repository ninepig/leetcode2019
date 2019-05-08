package amazon.MianJing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangw on 2019/4/28.
 *
 *
 第一轮，印度人，给两个string, 要求保证每个string内部相对顺序不变的情况下，输出所有可能的组合.
 比如 s1 = “AB”  s2 = “CD” 输出ABCD ACBD ACDB CABD CADB CDAB
 */
public class twoStringCombination {

    static void printInterRecur(String input1, String input2, char temp[],
                                int m, int n, int i) {

        if (m == 0 && n == 0) {
            System.out.println(temp);
        }

        if (m != 0) {
            temp[i] = input1.charAt(0);
            printInterRecur(input1.substring(1), input2, temp, m - 1, n, i + 1);

        }

        if (n != 0) {
            temp[i] = input2.charAt(0);
            printInterRecur(input1, input2.substring(1), temp, m, n - 1, i + 1);
        }

    }

    public static void main(String arg[]) {

        String input1 = "AB";
        String input2 = "CD";
        char temp[] = new char[input1.length() + input2.length()];

        printInterRecur(input1, input2, temp, input1.length(), input2.length(),
                0);

    }


}
