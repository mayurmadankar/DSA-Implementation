package dynamicProgramming;

public class KnapSack {
	
	public static int KnapSack(int weight[] , int value[] , int maxWeight ) {
		return KnapSack(weight , value , maxWeight , 0);
	}
	public static int KnapSack(int weight[] , int value[] , int maxWeight , int i) {
		if(i==weight.length || maxWeight==0) {
			return 0;
		}
		if(weight[i]>maxWeight) {
			return KnapSack(weight , value , maxWeight , i+1);
		}else {
//			include the ith item 
			int op1 = value[i]+KnapSack(weight , value , maxWeight-weight[i] , i+1);
//			dont include 
			int op2 = KnapSack(weight , value , maxWeight , i+1);
			return Math.max(op1, op2);
		}
	}
	
	
 public static int knapsackM(int[] weight, int[] value, int n, int maxWeight) {
		
     int storage[][]= new int[n+1][maxWeight+1];
     for(int i=0;i<n+1;i++){
         for(int j=0;j<maxWeight+1;j++){
             storage[i][j]=-1;
         }
     }
     return knapsack(weight,value,maxWeight,n+1,storage,0);

}
 public static int knapsack(int[] weight,int value[],int maxWeight,int n,int[][] storage,int i){
    if(i==weight.length || maxWeight==0){
        storage[i][maxWeight]=0;
        return storage[i][maxWeight];}

    if(storage[i][maxWeight]!=-1)
        return storage[i][maxWeight];
    if(weight[i]>maxWeight)
    {
        storage[i][maxWeight]=knapsack(weight,value,maxWeight,n-1,storage,i+1);
        return storage[i][maxWeight];
    }
    else{
        int op1=value[i]+knapsack(weight,value,maxWeight-weight[i],n-1,storage,i+1);
        int op2=knapsack(weight,value,maxWeight,n-1,storage,i+1);
        storage[i][maxWeight]=Math.max(op1,op2);
        return storage[i][maxWeight];
    }
     
}
	
	
	
	public static void main(String[] args) {
		int weight[]= { 6 , 1 ,2 ,4 ,5};
		int value[] = {10 ,5 ,4 ,8 ,6};
		int maxWeight = 5;
		System.out.println(knapsackM(weight , value , 0 , maxWeight));
		System.out.println(KnapSack(weight , value , maxWeight));
		
	}
}
