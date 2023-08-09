package LearnBinaryTree;

public class BinarySearchTree {
	private BinaryTreeNode<Integer> root;
    //insert data
    //private helper for insert data
    private BinaryTreeNode<Integer> insertHelper(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            return newNode;
        }
        if(data <= root.data){
            //insert on left subtree
            root.Left = insertHelper(data, root.Left);
        }
        else{
            //insert on right subtree
            root.right = insertHelper(data, root.right);
        }
        return root;
    }
	public void insert(int data) {
		//Implement the insert() function
        root = insertHelper(data, root);

    }
	//remove function'
    //remove helper function
    private BinaryTreeNode<Integer> removeHelper(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            return null;
        }
        if(data < root.data){
            root.Left = removeHelper(data, root.Left);
            return root;
        }else if(data > root.data){
            root.right = removeHelper(data, root.right);
            return root;
        }else{ //data = root.data
            if(root.Left == null && root.right == null){
                return null;
            }else if(root.Left == null){
                return root.right;
            }else if(root.right == null){
                return root.Left;
            }else{
             //if both left and right are not null, pick minimum element from right subtree and make that as the root
             BinaryTreeNode<Integer> minNode = root.right;
             while(minNode.Left!=null){
                 minNode = minNode.Left;
             }
             root.data = minNode.data;
             root.right = removeHelper(minNode.data, root.right);
             return root;   
                
            }
            
        }
        
        
    }
    //tree remove function
	public void remove(int data) {
		//Implement the remove() function
        root = removeHelper(data, root);
	}
	//tree print function
	private void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + ":";
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
	
	public void printTree() {
		printTree(root);
	}
    
	private boolean helperSearch(int data, BinaryTreeNode<Integer> root){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        else if(data > root.data){
            //call right
            return helperSearch(data, root.right);
        }else{
            //call left
            return helperSearch(data, root.Left);
        }
    }
	
	public boolean search(int data) {
		//Implement the search() function
        return helperSearch(data, root);
	}
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(20);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		bst.printTree();
		bst.remove(10);
		bst.printTree();
	}

}
