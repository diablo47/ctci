package newones;

public class Stock2 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0 ;
        int start = 0, ret = 0, end = prices.length-1;
        int biggestIndex = 0;
        while(start<prices.length-1){
            biggestIndex = findBiggest(prices,start, end);
            for(int i = start;i<biggestIndex;i++){
                ret += prices[biggestIndex]-prices[i];
            }
            start = biggestIndex+1;
        }
        return ret;
    }
    
    public int findBiggest(int[] prices, int start, int end){
        int biggestIndex = start, biggest = prices[start];
        for(int i = start;i<=end;i++){
            if(prices[i]>=biggest){
                biggestIndex = i;
                biggest = prices[i];
            }
        }
        return biggestIndex;
    }
}
