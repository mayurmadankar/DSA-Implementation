package dynamicProgramming;

public class MinSquare {
	
// ITERATIVE METHOD
	
	public static int countMinSquareDP(int n ) {
		
		int dp[] = new int[n+1];
		dp[0]=0;
		
		for(int i =1 ; i<=n ;i++) {
			
			int minVal = Integer.MAX_VALUE;
			
			for(int j=1 ; j*j<=i ;j++) {
				
				int currVal = dp[i-(j*j)];
				
				if(minVal>currVal) {
					minVal = currVal;
				}
			}
			dp[i]=1+minVal;
		}
		return dp[n];
	}
	
	
	
// MEMOIZABLE METHOD
	public static int countMinSquare(int n) {
		
		int dp[] = new int[n+1];
		for(int i=0 ; i<=n ;i++) {
			dp[i]=-1;
		}
		return countMinSquare(n , dp);
	}
	public  static int countMinSquare(int n, int[] dp) {
		if(n==0) {
			return 0;
		}
		
		int minVal = Integer.MAX_VALUE;
		
		for(int i=1 ; i*i<=n ; i++) {
			int currVal;
			
			if(dp[n-(i*i)]==-1) {
				dp[n-(i*i)] = countMinSquare(n-(i*i) , dp);
				currVal = dp[n-(i*i)];
			}else {
				currVal = dp[n-(i*i)];
			}
			if(minVal>currVal) {
				minVal = currVal;
			}
		}
		int myVal=1+minVal;
		return myVal;
	}
	public static void main(String[] args) {
		int n = 41;
		
		System.out.println(countMinSquareDP(n));
		System.out.println(countMinSquare(n));
	}
}
