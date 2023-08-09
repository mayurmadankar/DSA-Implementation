package backtrack;

public class RathinMaze {
	
	public static void ratInMaze(int maze[][]) {
		int n = maze.length;
		int path [][] = new int[n][n];
		printAllPath(maze , 0, 0 , path);
//		return solveMaze(maze , 0 ,0 , path);
	}
	
	public static void printAllPath(int maze[][] , int i , int j , int path[][]) {
        int n = maze.length;
        
//        checking if i,j path is valid or not
        if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
        	return ;
        }
//        include the cell in current path
        path[i][j]=1;
        
//        if Destination cell
        if(i == n-1 && j == n-1) {
        	for(int r =0 ; r < n ;r++) {
        		for(int c = 0 ; c < n ; c++) {
        			System.out.print(path[r][c]+" ");
        		}
        		System.out.println();
        		
        	}
        	System.out.println();
        	path[i][j]=0;
        	return ;
        }
//        Explore further in all direction
        
        
//        top
        printAllPath(maze , i-1 , j , path);
//        down
         printAllPath(maze , i+1 , j , path);
//        left
         printAllPath(maze , i , j-1 , path);
//        right
        printAllPath(maze , i , j+1 , path);
        
        path[i][j]=0;
        
	}
	
	
	
	
	public static boolean solveMaze(int maze[][] , int i , int j , int path[][]) {
        int n = maze.length;
        
//        checking if i,j path is valid or not
        if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0 || path[i][j]==1) {
        	return false;
        }
//        include the cell in current path
        path[i][j]=1;
        
//        if Destination cell
        if(i == n-1 && j == n-1) {
        	for(int r =0 ; r < n ;r++) {
        		for(int c = 0 ; c < n ; c++) {
        			System.out.print(path[r][c]+" ");
        		}
        		System.out.println();
        		
        	}
        	System.out.println();
//        	path[i][j]=0;
        	return true;
        }
//        Explore further in all direction
        
        boolean pathPossible= false;
//        top
        if(solveMaze(maze , i-1 , j , path)) {
        	pathPossible=true;
        }
//        down
        if(solveMaze(maze , i+1 , j , path)) {
        	pathPossible=true;
        }
//        left
        if(solveMaze(maze , i , j-1 , path)) {
        	pathPossible=true;
        }
//        right
        if(solveMaze(maze , i , j+1 , path)) {
        	pathPossible=true;
        }
        return pathPossible;
	}
	
	public static void main(String[] args) {
		int maze[][] = {{1,1,0} , {1,1,0} , {1,1,1}};
		  ratInMaze(maze);
//		System.out.println(pathPossible);
	}
}
