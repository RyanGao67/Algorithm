import java.util.Arrays;
import edu.princeton.cs.algs4.*;
public class Ex_1_1_29{
    public static void main(String[] args){
        In in = new In(args[0]);
        int[] whiteList = in.readAllInts();
        Arrays.sort(whiteList);
        
        
        String index="";
        String values="";
        for(int i=0;i<whiteList.length;i++){
            index+=String.format("%4d",i);
            value+=String.format("%4d",whiteList[i]);
        }
        System.out.println(index+"\n"+value);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
                    int k = rank(key,whiteList);
        int m = count(key,whiteList); 
        boolean b = verify(k,m,key,whiteList);
        System.out.printf("%4d+%4d+%10s",k,m,b);
        }

 
    }
    
    public static int rank(int key, int[] whiteList){
        int low =0;
        int high =whiteList.length-1;
        int mid=low+(high-low)/2;
        while(low<high){
            if(key<whiteList[mid]){high=mid;}
            else if(key>whiteList[mid]){low=mid;}
            mid=low+(high-low)/2;
        }
    }
    public static int count(int key,int[] whiteList){
    
    }
    public static boolean verify(int a, int b, int key,int[] whiteList){
        
    }

}