package graphs;

import java.util.*;

public class Graphs {
	
	public static void printDFSHelper(int edges[][] , int sv , boolean visited[]) {
		System.out.println(sv);
		visited[sv] = true;
		int n = edges.length;
		
		for(int i=0 ; i<n ; i++) {
			if(edges[sv][i]==1 && !visited[i]) {
				printDFSHelper(edges , i , visited);
			}
		}
	}
	public static void DFS(int edges[][]) {
		boolean visited[] = new boolean[edges.length];
		int n = edges.length;
		for(int i=0 ; i<n ; i++) {
			if(!visited[i]) {
				printDFSHelper(edges , i , visited);
			}
		}
	}
	
	
	public static void printBFSHelper(int edges[][] , int sv , boolean visited[]) {
		QueueUsingLL<Integer> q = new QueueUsingLL<>();
		q.enqueue(sv);
		visited[sv]=true;
		int n = edges.length;
		while(!q.isEmpty()) {
			int front = q.dequeue();
			System.out.println(front);
			for(int i=0 ; i<n ;i++) {
				if(edges[front][i]==1 && !visited[i]) {
					q.enqueue(i);
					visited[i]=true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		int n ;
		int e ;
		
		Scanner s = new Scanner(System.in);
	    n = s.nextInt();
	    e = s.nextInt();
	    
	    int edges[][] = new int[n][n];
	    
	    for(int i=0 ; i< e ;i++) {
	    	int fv = s.nextInt();
	    	int sv = s.nextInt();
	    	edges[fv][sv] =1;
	    	edges[sv][fv] =1;
	    	
	    }
		print(edges);
	}

}
