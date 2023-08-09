package Complete_BinaryTree;

import java.util.ArrayList;

public class Priority_Queue {

	private ArrayList<Integer> heap;
	
	public Priority_Queue() {
		
		heap = new ArrayList<>();
		
	}
	boolean isEmpty() {
		return heap.size()==0;
	}
	int size() {
		return heap.size();
	}
	int getMin() throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	void insert(int element) {
		heap.add(element);
		
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2;
		
		while(childIndex >0) {
			if(heap.get(childIndex)<heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}else {
				return;
			}
		}
	}
	public void DownHeapify() {
		int parentIndex=0;
		int LeftChildIndex=2*parentIndex+1;
		int RightChildIndex = 2*parentIndex+2;
		int minIndex=0;
		
		while(LeftChildIndex< heap.size()) {
			
			if(heap.get(LeftChildIndex)<heap.get(minIndex)){
				minIndex = LeftChildIndex;
			}
			if(RightChildIndex<heap.size()&& heap.get(RightChildIndex)<heap.get(minIndex)) {
				minIndex = RightChildIndex;
			}
			if(minIndex!=parentIndex) {
				int temp = heap.get(parentIndex);
				heap.set(parentIndex , heap.get(minIndex));
				heap.set(minIndex , temp);
				
				parentIndex = minIndex;
				 LeftChildIndex=2*parentIndex+1;
				 RightChildIndex = 2*parentIndex+2;
			}else {
				break;
			}
		}
	}
	int remove()throws PriorityQueueException {
		if(isEmpty()) {
			throw new PriorityQueueException();
		}
		int minElement = heap.get(0);
		heap.set(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		DownHeapify();
		return minElement;
		
	}
}
