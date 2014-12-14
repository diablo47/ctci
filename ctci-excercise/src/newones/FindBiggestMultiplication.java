package newones;

public class FindBiggestMultiplication {

    public static int maxProduct(int[] A) {
    	if(A == null || A.length == 0){
    		return 0 ;
    	}
        int ret = A[0];
        int min=ret,max=ret;
        
        for(int i = 1;i<A.length;i++){
        	if(A[i]<0){
        		int temp = max;
        		max = min;
        		min = temp;
        	}
        	max = Math.max(A[i], max*A[i]);
        	min = Math.min(A[i], min*A[i]);
        	
        	ret = Math.max(max, ret);
        }
        return ret;
    }
	
	public static void main(String[] args){
		int[] a = new int[]{2,3,-2,4,-4};
		System.out.println(maxProduct(a));
	}
	
}
