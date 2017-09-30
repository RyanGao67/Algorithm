import edu.princeton.cs.algs4.*;
public class Average {
 public static void main(String[] args){
  double sum=0.0;
  int count=0;
  while(!StdIn.isEmpty()){
   sum +=StdIn.readDouble();
   count++;
   
  }
  double avg=sum/count;
  StdOut.printf("Average is %.5f",avg);
 }

}
