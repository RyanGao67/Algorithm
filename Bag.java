import java.util.*;
import edu.princeton.cs.algs4.*;
public class Bag<Item> implements Iterable<Item>{
    public static void main(String[] args){
        Bag<String> test = new Bag<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            test.add(item);
        }
        Iterator<String> iterator = test.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    private class Node{
        Item item;
        Node next;
    }
    private int n;
    private Node first;
    public Bag(){
        first=null;
        n=0;
    }
    public void add(Item item){
        Node oldFirst=first;
        first=new Node();
        first.item=item;
        first.next=oldFirst;
        n++;
    }
    public int size(){
        return n; 
    }
    public boolean isEmpty(){
        return first==null;
    }
    @Override
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            Item item =current.item;
            current=current.next;
            return item;
        }
        public void remove(){}
    }
}








