package amazon;

/**
 * Created by yangw on 2019/3/26.
 */
public class bestTimeToBuyAndSell121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int lowest = prices[0];
        int max = 0;
        for(int i = 1 ; i < prices.length ; i++){
            lowest = Math.min(lowest,prices[i]);
            max = Math.max(max , prices[i] - lowest);
        }
        return max;
    }
}
