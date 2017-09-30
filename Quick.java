import edu.princeton.cs.algs4.*;

public class Quick<E implements Comparable<E>>{
    public static void main(String[] args){
        String[] s = StdIn.readStrings();
        Quick.sort(s);
        show(s);
        StdOut.println();
        for(int i=0;i<s.length;i++){
            String a = Quick.select(i);
            StdOut.println(a);
        }
    }
    public static boolean less(E a, E b){
        return a.compareTo(b)<0;
    }
    public static void exchange(E[] list,int i,int j){
        E temp = list[i];
        list[i]=list[j];
        list[j]=temp;
    }
    public static void show(E[]){
        for(int i=0;i<E.length;i++){
        Stdout.println(E[i]);
        }
    }
    public static boolean isSorted(E[] list){
        for(int i=1,i<list.length;i++){
            if(list[i].compareTo(list[i-1])<0)
                return false;
        }
        return true;
    }
        public static E select(E[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new RuntimeException("Selected element out of bounds");
        }
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }
        public static void sort(E[] list, int low, int high){
            if(low>=high) return;
            if()
           
        }

}








