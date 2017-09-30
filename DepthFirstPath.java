import java.util.*;
import edu.princeton.cs.algs4.*;
public class DepthFirstPath{
    int[] edgeTo;
    int s;
    boolean[] marked;
    DepthFirstPath(Graph g, int s){
        edgeTo = new int[g.getV()];
        this.s=s;
        marked=new boolean[g.getV()];
        dfs(g,s);
    }
    public void dfs(Graph g, int a){
        marked[a]=true;
        Iterable<Integer> iterable= g.getAdjI(a);
        for(int i : iterable){
            if(!marked[i]){
                edgeTo[i]=a;
                dfs(g,i);
            }
        }
    }
    public boolean hasPathTo(int j){
        return marked[j];
    }
    public Iterable<Integer> path(int j){
        if(hasPathTo(j)==false)return null;
        else{
            int k =j;
            Stack<Integer> stack = new Stack<Integer>();
            while(edgeTo[k]!=s){
                stack.push(k);
                k=edgeTo[k];
            }
            stack.push(s);
            return stack;
        }
        
        
    }
    
    public static void main(String[] args){
        In in = new In(args[0]);
        Graph g = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstPath dfs = new DepthFirstPath(g,s);
                for (int v = 0; v < g.getV(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.path(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }
    
}








