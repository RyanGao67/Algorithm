/*
import java.util.Arrays;
import edu.princeton.cs.algs4.*;
public class BinarySearch{
    public static void main(String[] args){
                In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whitelist)<0){
                StdOut.println(key);
            }
        }
    }
    public static int rank(int key,int[] a){
        int lo =0;
        int hi= a.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(key<a[mid])hi=mid-1;
            else if(key>a[mid])lo=mid+1;
            else return mid;
        }
        return -1;
    }
}
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class BinarySearch {

  
    private BinarySearch() { }


    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

   
    @Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }


    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
        System.out.println(args[0]);
    }
}
