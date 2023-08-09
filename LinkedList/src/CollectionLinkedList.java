import java.util.*;

public class CollectionLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.addFirst(2);
		list.add(30); 
		list.addFirst(5);
		System.out.println(list.size());
		
		for(int i=0 ; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	

}
