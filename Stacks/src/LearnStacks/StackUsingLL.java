package LearnStacks;

public class StackUsingLL <T>{

	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
	
		head = null;
		size = 0;
	}
	int size() {
		return size;
	}
	T top() throws StackEmptyException{
		if(size()==0) {
			throw new StackEmptyException();
		}
		return head.data;
	}
	boolean isEmpty() {
		return size()==0; 
	}
	void push(T element) {
		Node<T> newNode = new Node<T>(element);
		newNode.next = head;
		head = newNode;
		size++;
	}
	T pop()throws StackEmptyException{
		if(size()==0) {
			throw new StackEmptyException();
		}
		T tempdata = head.data;
		head = head.next;
		size--;
		return tempdata;
	}
}
