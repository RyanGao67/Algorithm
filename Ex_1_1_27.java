import  edu.princeton.cs.algs4.*;
public class Ex_1_1_27 {
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        
        Counter c = new Counter("calls");
        double n = binomial(a,b,p,c);
        
        StdOut.println(n);
        StdOut.println(c);
        
    }
    
    public static double binomial(int m , int n, double k, Counter counter){
        counter.increment();
        if(m==0&&n==0){return 1.0;}
        if(m<0||n<0){return 0.0;}
        return k*binomial(m-1,n-1,k,counter)+(1-k)*binomial(m-1,n,k,counter);
    }
}