import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.*;
import java.util.*;
public class Graph{
    private int v;
    private int e;
    private Bag<Integer>[] adj;
    public Graph(int v){
        this.v=v;
        e=0;
        adj=(Bag<Integer>[])new Bag[v];
        for(int i=0;i<v;i++){
            adj[i]=new Bag<Integer>();
        }
    }
    public Graph(In in){
        this(in.readInt());
        this.e=in.readInt();
        int m =e;
        e=0;
        for(int i=0;i<m;i++){
          
            int w = in.readInt();
          
            int y = in.readInt();
          
            addEdge(w,y);
        }
    }
    public int getV(){
        return this.v;
    }
    public int getE(){
        return this.e;
    }
    public Iterable<Integer> getAdjI(int i){
        return this.adj[i];
    }
    public void addEdge(int i,int j){
        adj[i].add(j);
        adj[j].add(i);
        e++;
    }
    public Graph(Graph g){
        this(g.getV());
        this.e=g.getE();
        for(int i=0;i<v;i++){
            Iterator<Integer> iterator=g.getAdjI(i).iterator();
            while(iterator.hasNext()){
                this.adj[i].add(iterator.next());
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder=new StringBuilder();
        String nextLine = System.getProperty("line.separator");
        stringBuilder.append(v+"verticles;"+e+"edges;");
        stringBuilder.append(nextLine);
        for(int i=0;i<v;i++){
            stringBuilder.append(i+":");
            for(int j:adj[i]){
                stringBuilder.append(" "+j);
            }
            stringBuilder.append(nextLine);
        }
        return stringBuilder.toString();
    }
    
    public static void main(String[] args){
        In in = new In(args[0]);
        Graph graph= new Graph(in);
        StdOut.println(graph.toString());
    }
}







