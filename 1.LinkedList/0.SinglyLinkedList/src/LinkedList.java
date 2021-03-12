import java.util.ArrayList;

public class LinkedList<E> implements List<E> {

	private Node<E> head;
	private int size = 0;

	public LinkedList() {
		this.head = null;
	}
	
	@Override
	public void add(E element) {
		//the add operation is O(1) because we are adding in the begging of the linkedlist
		if(head == null) {
			head = new Node<E>(element,null);
		}else {
			head = new Node<E>(element,head);
		}
		size++;
		
	}
	

	@Override
	public E remove() {
		//the remove operation is O(1) because we are removing in the begging of the linkedlist
		if(head == null)
			return null;
		Node<E> element = head;
		head = head.next;
		element.next=null; 
		size--;
		return element.data;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	public void print() {
		//the print operation is O(n) because we are parsing the hole linkedlist
		if(head==null) {
			System.out.println("[]");
			return ;
		}
		Node<E> parser = head;
		System.out.print("[");
		while(parser!=null) {
			System.out.print(parser.data+(parser.next==null?"":"\t"));
			parser = parser.next;
		}
		System.out.println("]");
	}
	
	
	
	private static class Node<E>{
		E data;
		Node<E> next;
		
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> nations = new LinkedList<String>();
		nations.add("TN");
		nations.add("GB");
		nations.add("GER");
		nations.add("RUS");
		nations.add("IN");
		nations.print();
		String elementRemoved = nations.remove();
		System.out.printf("nations.remove(): %s%n",elementRemoved);
		nations.print();
		elementRemoved = nations.remove();
		System.out.printf("nations.remove(): %s%n",elementRemoved);
		nations.print();
		elementRemoved = nations.remove();
		System.out.printf("nations.remove(): %s%n",elementRemoved);
		nations.print();
		System.out.printf("nations.isEmpty() : %s%n",nations.isEmpty());
		elementRemoved = nations.remove();
		System.out.printf("nations.remove(): %s%n",elementRemoved);
		nations.print();
		elementRemoved = nations.remove();
		System.out.printf("nations.remove(): %s%n",elementRemoved);
		nations.print();
		System.out.printf("nations.isEmpty() : %s%n",nations.isEmpty());
	}
	
	
	

}

//output
/*
[IN	RUS	GER	GB	TN]
nations.remove(): IN
[RUS	GER	GB	TN]
nations.remove(): RUS
[GER	GB	TN]
nations.remove(): GER
[GB	TN]
nations.isEmpty() : false
nations.remove(): GB
[TN]
nations.remove(): TN
[]
nations.isEmpty() : true
*/
