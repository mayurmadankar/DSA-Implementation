package LearnQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollection {

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<5;i++)
        {
            queue.add(10+i);
        }
        System.out.print(queue.poll()+" "+queue.size());	}
}
