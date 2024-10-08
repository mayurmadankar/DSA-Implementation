package dynamicProgramming;

public class EditDistance {
	
//	recursive
	
	public static int editDistance(String s , String t) {
		
		if(s.length()==0) {
			return t.length();
		}
		if(t.length()==0) {
			return s.length();
		}
		if(s.charAt(0)==t.charAt(0)) {
			return editDistance(s.substring(1),t.substring(1));
		}else {
//			insert
			int op1 = editDistance(s , t.substring(1));
//			delete
			int op2 = editDistance(s.substring(1),t);
//			substitution
			int op3 = editDistance(s.substring(1) , t.substring(1));
			
			return 1+Math.min(op1 , Math.min(op2, op3));
		}
	}
	
//	Memoization
	
	public static int editDistanceM(String s , String t) {
		int m = s.length();
		int n = t.length();
		int storage[][] = new int[m+1][n+1];
		for(int i=0 ;i<=m ;i++) {
			for(int j=0 ;j<=n ;j++) {
				storage[i][j]=-1;
			}
		}
		return editDistanceM(s , t , storage);
	}
	public static int editDistanceM(String s , String t , int storage[][]) {
		int m = s.length();
		int n = t.length();
		
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(m==0) {
			storage[m][n]=n;
			return storage[m][n];
		}
		if(n==0) {
			storage[m][n]=m;
			return storage[m][n];
		}
		if(s.charAt(0)==t.charAt(0)) {
			storage[m][n]= editDistanceM(s.substring(1),t.substring(1),storage);
		}else {
//			insert
			int op1 = editDistanceM(s , t.substring(1),storage);
//			delete
			int op2 = editDistanceM(s.substring(1),t , storage);
//			substitution
			int op3 = editDistanceM(s.substring(1) , t.substring(1),storage);
			
			storage[m][n]=1+Math.min(op1 , Math.min(op2, op3));
		}
		return storage[m][n];
	}
	
//	Dynamic Programming
	public static int editDistanceDP(String s , String t) {
		int m = s.length();
		int n = t.length();
		int storage[][]=new int[m+1][n+1];
		
		for(int i=0 ; i<=m ; i++) {
			storage[i][0]=i;
		}
		for(int j=0 ;j<=n ;j++) {
			storage[0][j]=j;
		}
		for(int i=1 ; i<=m ;i++) {
			for(int j=1 ; j<=n ;j++) {
				if(s.charAt(m-i)==t.charAt(n-j)) {
					storage[i][j]=storage[i-1][j-1];
				}else {
					storage[i][j]= 1+Math.min(storage[i][j-1], Math.min(storage[i-1][j],storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
	}
	
	public static void main(String[] args) {
		String s = "mayur";
		String t = "madankar";
		
		System.out.println(editDistanceDP(s,t));
		System.out.println(editDistanceM(s,t));
		System.out.println(editDistance(s,t));
	}
}
