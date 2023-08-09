package LearnBinaryTree;

//import LearnQueue.Node;

public class Node <T>{

	T data;
	Node<T> next;
	
	Node(T data){
		this.data = data;
		next = null;
	}
}
