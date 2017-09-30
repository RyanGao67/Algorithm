import edu.princeton.cs.algs4.*;
public class RandomSeq {
 public static void main(String[] args){
  int a = Integer.parseInt(args[0]);
  double b = Double.parseDouble(args[1]);
  double c = Double.parseDouble(args[2]);
  for(int i=0;i<a;i++){
   double x = StdRandom.uniform(b,c);
   StdOut.println(x);
  }
 }

}
