import java.util.*;
import edu.princeton.cs.algs4.*;
public class Queue<Item> implements Iterable<Item>{
    Node first;
    Node last;
    int n;
    private class Node{
        Item item;
        Node next;
    }
    public Queue(){
        first=null;
        last=null;
        n=0;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int sizeOf(){
        return n;
    }
    public void enqueue(Item item){
        Node node = new Node();
        node.item=item;
        if(this.isEmpty()){
            first=node;
            last=node;
        }else{
            last.next=node;
            last=node;
        }
        n++;
    }
    public Item dequeue(){
        if(isEmpty()) throw new RuntimeException("Queue underflow");
        Node node = first;
        first=first.next;
        n--;
        if(isEmpty())last=null;
        return node.item;
    }
    @Override
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
    
    public static void main(String[] args){
        Queue<String> q = new Queue<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))q.enqueue(item);
            else if(!q.isEmpty())StdOut.print(q.dequeue()+" ");
        }
        StdOut.println("("+q.sizeOf()+" left on queue");
    }
    
}







