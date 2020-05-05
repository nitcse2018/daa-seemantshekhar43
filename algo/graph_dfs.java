// Java program to print DFS traversal from a given given graph 
import java.io.*; 
import java.util.*; 


class Graph 
{ 
	private int n; // no of vertices
    private LinkedList<Integer> aList[]; // adjacency list


	public Graph(int n){
        this.n  = n;
        aList = new LinkedList[n];
        for(int i = 0; i < n; i++){
            aList[i] = new LinkedList();
        }
    }

    public void addEdge(int a, int b){
        aList[a].add(b); // adding b to list of a
    }

    public void dfsIterator(int n, boolean traversed[]){
            traversed[n] = true;
            System.out.print(n + " ");
            Iterator<Integer> iterator = aList[n].listIterator();
            while(iterator.hasNext()){
                int x = iterator.next();
                if(!traversed[x]){
                    dfsIterator(x, traversed);
                }
            }
    }

    public void dfs(int v){
        boolean traversed[] = new boolean[n]; // keeping track of traversed elements
        dfsIterator(v, traversed);
    }

	public static void main(String args[]) 
	{ 
		Graph g = new Graph(4); 

		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 

		System.out.println("Dfs iteration starting from vertex "; 

		g.dfs(2); 
	} 
} 
// This code is contributed by Aakash Hasija 
