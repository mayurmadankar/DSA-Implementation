package dynamicProgramming;

public class TakeNumberToOne {

	
//	Throw recursion
	public static int countSteps(int n) {
		if(n==1) {
			return 0;
		}
		int op1 = countSteps(n-1);
		int minSteps = op1;
		
		if(n%3==0) {
			int op2 = countSteps(n/3);
			if(op2<minSteps) {
				minSteps=op2;
			}
		}
		if(n%2==0) {
			int op3 = countSteps(n/2);
			if(op3<minSteps) {
				minSteps=op3;
			}
		}
		return 1+minSteps;
	}
	
//	Throw Memoization
	public static int countStepsM(int n) {
		int storage[]= new int[n+1];
		return countStepsM(n , storage);
	}
	private static int countStepsM(int n, int[] storage) {
		if(n==1) {
			storage[n]=0;
			return storage[n];
		}
		if(storage[n]!=0) {
			return storage[n];
		}
		int op1 = countStepsM(n-1 , storage);
		int minSteps = op1;
		
		if(n%3==0) {
			int op2 = countStepsM(n/3, storage);
			if(op2<minSteps) {
				minSteps=op2;
			}
		}
		if(n%2==0) {
			int op3 = countStepsM(n/2 , storage);
			if(op3<minSteps) {
				minSteps=op3;
			}
		}
		storage[n]= 1+minSteps;
		return storage[n];
	}
	
	public static int countStepsDP(int n) {
		int storage[]= new int[n+1];
		storage[1]=0;
		for(int i=2 ; i<=n ; i++) {
			int minSteps =storage[i-1];
			
			if(i%3==0) {
				if(minSteps> storage[i/3]) {
					minSteps=storage[i/3];
				}
			}
			if(i%2==0) {
				if(minSteps>storage[i/2]) {
					minSteps=storage[i/2];
				}
			}
			storage[i]=1+minSteps;
		}
		return storage[n];
	}
	
	
	public static void main(String[] args) {
		int n=10;
		System.out.println(countStepsDP(n));
		System.out.println(countStepsM(n));
		System.out.println(countSteps(n));
	}
}
