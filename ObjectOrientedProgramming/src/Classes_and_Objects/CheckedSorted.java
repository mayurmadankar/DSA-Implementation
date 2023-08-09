package Classes_and_Objects;

public class CheckedSorted {
	
	public static boolean checkedSorted(int input[]) {
		if(input.length<=1) {
			return true;
		
		}
		int smallInput[]=new int[input.length-1];
		for(int i=1 ; i<input.length;i++) {
			smallInput[i-1]=input[i];
		}
		boolean smallAns = checkedSorted(smallInput);
		if(!smallAns) {
			return false;
		}
		if(input[0]<=input[1]) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		int input[]= {0,1,3,5,6};
		System.out.println(checkedSorted(input));
	}

}
