package LearnStacks;

public class StackUse {
   public static void main(String[] args) throws Exception{
	StacksUsingArrays  stack = new StacksUsingArrays(3);
	for(int i=1 ; i<=5 ;i++) {
		stack.push(i);
	}
	while(!stack.isEmpty()) {
		try {
			System.out.println( stack.pop());
		}
		catch(StackEmptyException e) {
			
		}
	}
}
}
