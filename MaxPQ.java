import edu.princeton.cs.algs4.*;
import java.util.*;

public class MaxPQ<E> {
    private int number;
    private Comparator<E> comparator;
    private E[] pq;

    public MaxPQ(int n,Comparator<E> comparator){
        this.pq=(E[])new Object[n+1];
        this.number=0;
        this.comparator=comparator;
    }
    public MaxPQ(int n){
        this.pq=(E[])new Object[n+1];
        this.number=n;
    }
    public MaxPQ(E[] pq){
        this.pq=(E[])new Object[pq.length+1];
        for(int i=0;i<pq.length;i++){
            this.pq[i+1]=pq[i];
        }
        this.number = pq.length;
        for(int i=number/2;i>0;i--){
            sink(i);
        }
    }
    public MaxPQ(){
        this(1);
    }
    public MaxPQ(Comparator<E> comparator){
        this(1,comparator);
    }
    public int size(){
        return number;
    }
    public void resize(int N){
        E[] temp = (E[])new Object[N];
        for(int i=1;i<=number;i++){
            temp[i]=pq[i];
        }
        pq=temp;
    }
    public boolean isEmpty(){
        return this.number==0;
    }
    public E Max(){
        if (isEmpty()) throw new RuntimeException("Priority queue underflow");
        return pq[1];
    }
    public void exchange(int i,int j){
        E temp = pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }
    public boolean less(int i,int j){
        return comparator.compare(pq[i],pq[j])<0;
    }
    public void swim(int i){
        while(i>1&&less(i/2,i)){
         exchange(i,i/2);
         i=i/2;
        }
    }
    public void sink(int i){
        while((i*2)<=number){
            int j=i*2; 
                if((2*i+1)<=number&&less(2*i,2*i+1))j++;
                if(!less(i,j))break;
                exchange(i,j);
                i=j;
        }
    }
    public void insert(E e){
        
        if(pq.length==number+1){
            resize(pq.length*2);
        }
        pq[++number]=e;
        swim(number);
    }
    public E deleteMax(){
        if(number==0){
            throw new RuntimeException("Priority queue underflow");
        }
        E maxMax=pq[1];
        exchange(1,number);
        number--;
        pq[number+1]=null;
        sink(1);
        if ((number> 0) && (number == (pq.length - 1) / 4)) resize(pq.length / 2);
        return maxMax;
    }
    
     public static void main(String[] args) {
         MaxPQ<String> pq = new MaxPQ<String>(new Comparator<String>(){
             @Override
             public int compare(String a,String b){
                 return a.compareTo(b);
             }
         });
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.insert(item);
            else if (!pq.isEmpty()) StdOut.print(pq.deleteMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");
    }

}






























