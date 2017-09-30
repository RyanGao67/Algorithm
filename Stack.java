import java.util.*;
import edu.princeton.cs.algs4.*;

public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int n;
    private class Node{
        private Item item;
        private Node next;
    }
    public Stack(){
        first=null;
        n = 0;
        
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public Item peek(){
        if(this.isEmpty()){
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }
    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next=oldFirst;
        n++;
    }
    public Item pop(){
        if(this.isEmpty()){
            throw new RuntimeException("Stack underflow");
        }
        Item temp = first.item;
        first=first.next;
        n--;
        return temp;
    }
    @Override
    public String toString(){
        StringBuilder a = new StringBuilder();
        Node temp = first;
        while(temp!=null){
            a.append(temp.item+" ");
            temp=temp.next;
        }
        return a.toString();
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
            if(!hasNext())throw new NoSuchElementException();
            Item item = current.item;
            current=current.next;
            return item;
        }
        public void remove()  {};
    }
        public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}



















