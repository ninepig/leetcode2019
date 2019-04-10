package facebook;

public class multplyString {
    public String multiply(String num1, String num2) {
        int[] product = new int[num1.length() + num2.length() + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = num1.length() - 1 ; i >= 0 ; i--){
            for (int j = num2.length() - 1; j>=0 ; j--){
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                // 关键 +=
                product[i+j+1] += a * b;
            }
        }

        int carry = 0 ;
        for (int i = product.length - 1 ; i>= 0 ; i--){
            int sum = product[i] + carry;
            carry = sum / 10;
            product[i] = sum%10;

        }

       for (int num : product){
           sb.append(num);
       }
        // Remove heading 0
       while(sb.length()!= 0 && sb.charAt(0)==0){
           sb.deleteCharAt(0);
       }
        // 0 or number
       return sb.length() == 0 ? "0":sb.toString();

    }
}