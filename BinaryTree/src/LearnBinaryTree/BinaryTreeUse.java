package LearnBinaryTree;

import java.util.Scanner;



public class BinaryTreeUse {

	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.Left != null) {
			toBePrinted += "L:" + root.Left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.Left);
		printTree(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		int rootData;
		System.out.println("Enter root data");
		rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		root.Left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.Left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
	
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int ans = 1;
		ans += countNodes(root.Left);
		ans += countNodes(root.right);
		return ans;
	}
	
	public static void mirror(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		mirror(root.Left);
		mirror(root.right);
		BinaryTreeNode<Integer> temp = root.Left;
		root.Left = root.right;
		root.right = temp;
		return;
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		int option1 = height(root.Left) + height(root.right);
		int option2 = diameter(root.Left);
		int option3 = diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.Left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}

	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Integer,Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightDiameter(root.Left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		int height = 1 + Math.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Math.max(option1, Math.max(option2, option3));		
		Pair<Integer,Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	public static void inorder(BinaryTreeNode<Integer> root) {
		
	}
	
	public static BinaryTreeNode<Integer> buildTreeHelper(int in[] , int pre[] , int inS , int inE , int preS , int preE){
		if(inS > inE) {
			return null;
		}
		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		
		int rootInIndex = -1;
		for(int i=inS ; i<inE ; i++) {
			if(in[i]==rootData) {
				rootInIndex = i;
				break;
			}
			if(rootInIndex == -1) {
				return null;
			}
		}
		
		int leftInS = inS;
		int leftInE  = rootInIndex-1;
		int leftPreS = preS+1 ;
		int leftPreE = leftInS - leftInS + leftPreS;
		int rightInS = rootInIndex+1;
		int rightInE = inE;
		int rightPreS = leftPreE+1;
		int rightPreE = preE;
		root.Left=buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		
		
		return root;
	}
	
    public static BinaryTreeNode<Integer> buildTree(int in[] , int pre[]){
		return buildTreeHelper(in , pre , 0 , in.length-1 , 0 , pre.length-1);
	}
	
    public static int minimum(BinaryTreeNode<Integer> root) {
    	if(root==null) {
    		return Integer.MAX_VALUE;
    	}
    	return Math.min(root.data, Math.min(minimum(root.Left) , minimum(root.right)));
    }
    
    public static int maximum(BinaryTreeNode<Integer> root) {
    	if(root==null) {
    		return Integer.MIN_VALUE;
    	}
    	return Math.max(root.data, Math.max(maximum(root.Left) , maximum(root.right)));
    }
	
    public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true ;
		}
		int leftmax = maximum(root.Left);
		int rightmin = minimum(root.right);
		int rootData = root.data;
		
		if(rootData <=leftmax) {
			return false;
		}
		if(rootData>rightmin) {
			return false;
		}
		boolean isleftBST = isBST(root.Left);
		boolean isrightBST = isBST(root.right);
		
		if(isleftBST && isrightBST) {
			return true;
		}
		else {
			return false;
		}
	}
	
    public static Pair<Boolean , Pair<Integer , Integer>> isBST2(BinaryTreeNode<Integer> root){
    	if(root == null) {
    		Pair<Boolean , Pair<Integer , Integer>> output = new Pair<Boolean , Pair<Integer , Integer>>();
    		output.first = true;
    		output.second = new Pair<Integer , Integer>();
    		output.second.first = Integer.MAX_VALUE;
    		output.second.second = Integer.MIN_VALUE;
    		return output;
    	}
    	Pair<Boolean , Pair<Integer , Integer>> leftoutput = isBST2(root.Left);
    	Pair<Boolean , Pair<Integer , Integer>> rightoutput = isBST2(root.right);
    	
    	int min = Math.min(root.data, Math.min(leftoutput.second.first, rightoutput.second.first));
    	int max = Math.max(root.data, Math.min(leftoutput.second.second , rightoutput.second.second));
    	
    	boolean isBST = root.data >  leftoutput.second.second 
    			&& root.data <= rightoutput.second.first
    			&& leftoutput.first && rightoutput.first;
    	
    	Pair<Boolean , Pair<Integer , Integer>> output = new Pair<Boolean , Pair<Integer , Integer>>();
		output.first = isBST;
		output.second = new Pair<Integer , Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;

    }
    
    public static boolean isBST3(BinaryTreeNode<Integer> root , int min , int max) {
    	if(root ==null) {
    		return true ;
    	}
    	if(root.data< min || root.data >max) {
    		return false;
    	}
    	boolean isLeftOk = isBST3(root.data , min , root.data-1);
    	boolean isRightOk = isBST3(root.data , root.data , max);
    	
    	return isLeftOk && isRightOk ;
    }
    
    
    private static boolean isBST3(Integer data, int min, int max) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		
		 int in[] = { 4 , 2 , 5 , 1 , 3 , 7 };
		 int pre[]= {1 , 2 , 4 , 5 ,3 , 7};
		 
		 BinaryTreeNode<Integer> root = buildTree(in , pre);
		
		printTree(root);
		
//		BinaryTreeNode<Integer> root = takeInputLevelWise();
//		printTree(root);
//		System.out.println("diameter:" + heightDiameter(root).second);
//
//		System.out.println("Height:" + heightDiameter(root).first);
	}
}
