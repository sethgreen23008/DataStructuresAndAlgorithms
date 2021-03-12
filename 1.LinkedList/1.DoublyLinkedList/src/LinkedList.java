
public class LinkedList<E> implements List<E> {

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	public static void main(String[] args) {
		LinkedList<String> nations = new LinkedList<String>();
		/*********** Remove and Add to Front *************/
//		nations.addToFront("GB");
//		nations.addToFront("GER");
//		nations.addToFront("FR");
//		nations.addToFront("IT");
//		nations.addToFront("SP");
//		nations.print();
//		System.out.printf("removeToFront() : %s%n", nations.removeToFront());
//		nations.print();
//		System.out.printf("removeToFront() : %s%n", nations.removeToFront());
//		nations.print();
//		System.out.printf("removeToFront() : %s%n", nations.removeToFront());
//		nations.printFromFront();
		/*********** Remove and Add to End *************/
		
		nations.addToEnd("GB");
		nations.addToEnd("GER");
		nations.addToEnd("FR");
		nations.addToEnd("IT");
		nations.addToEnd("SP");
		nations.print();
		
		System.out.printf("removeFromEnd() : %s%n", nations.removeFromEnd());
		nations.print();
		
		System.out.printf("removeFromEnd() : %s%n", nations.removeFromEnd());
		nations.print();
		
		System.out.printf("removeFromEnd() : %s%n", nations.removeFromEnd());
		nations.print();
		/*********** Remove and Add using Indexes *************/
		nations.add("TN", 0);
		nations.print();
		nations.add("NE", 3);
		nations.print();
		nations.add("IN", 2);
		nations.print();
//		System.out.printf("size() : %s%n", nations.size());
		System.out.printf("remove(3) : %s%n", nations.remove(3));
		nations.print();
//		System.out.printf("size() : %s%n", nations.size());
		System.out.printf("remove(3) : %s%n", nations.remove(3));
		nations.print();
		System.out.printf("remove(0) : %s%n", nations.remove(0));
		nations.print();
	}

	
	@Override
	public boolean addToFront(E element) {
		//if the list is empty
		//link the head and the tail to the newly created Node
		if(isEmpty()) {
			head = tail = new Node<E>(element,null,null);
		}else {//if not empty
			//attache the head pointer to the new created Node and point its next pointer point to the head
			head = new Node<E>(element,head,null);
		}
		//increment the size
		size++;
		return true;
	}

	@Override
	public E removeToFront() {
		//if the list is null return null
		if(isEmpty())
			return null;
		//save the head into the removedNode
		Node<E> removedNode = head;
		//if we have more the one item in the list
		//let the head point the next not
		if(size()>1) {
			head =  head.next;			
		}else {//else mark the head and the tail pointers to point to null
			head = tail = null;
		}
		//decrement the size
		size--;
		//clean the pointer of the removed node
		removedNode.next =null;
		removedNode.prev=null;
		//return the data of the removedNode
		return removedNode.data;
	}

	@Override
	public boolean addToEnd(E element) {
		//if the list is empty
		//assign the head and tail pointer to the new createdNode
		if(isEmpty()) {
			head = tail = new Node<E>(element,null,null);
		}else {//else attribute the next of tail to the new created node
			tail.next = new Node<E>(element,null,tail);
			//advance the tail pointer the newly created node
			tail = tail.next;
		}
		size++;
		return true;	
	}

	@Override
	public E removeFromEnd() {
		//if the list is empty return null
		if(isEmpty())
			return null;
		//save the tail in the removedNode variable
		Node<E> removeNode = tail;
		//if the size is greater then 1
		if(size()>1) {
			//retreat the tail to its previous node
			tail = tail.prev;
			//assign the next of tail to null
			tail.next = null;
		}else {//else assign head ,tail pointers to null
			tail = head = null;
		}
		size--;
		//clean the linkes of the removedNode
		removeNode.next = null;
		removeNode.prev = null;
		return removeNode.data;
	}

	@Override
	public boolean add(E element, int index) {
		//chech if you have a valid index
		if(index<0 || index>size) {
			System.out.println("You are adding in a wrong index!!");
			return false;
		}
		
		//if the index is 0 it means you are going to add to front
		if(index==0) {
			addToFront(element);
			return true;
		}else if(index == size()){//if the index equal size it means you are going to add to end
			addToEnd(element);
			return true;
		}else{//else you are adding in the middle somewhere
			Node<E> parser = head;
			for(int i=0;i<index;i++)
				parser = parser.next;
			Node<E> node = new Node<E>(element,parser,parser.prev);
			parser.prev.next = node;
			parser.prev = node;
			size++;
			return true;
		}
		
	}

	@Override
	public E remove(int index) {
		//chech if you have a valid index
		if(index<0 || index>=size) {
			System.out.println("You are trying to remove in a wrong index!!");
			return null;
		}
		//if the index is 0 then we remove from the beginning
		if(index == 0) {
			return removeToFront();
		}else if(index == size()-1) {//if the index is equal to the size -1 the we are removing the last node
			return removeFromEnd();
		}else {//otherwise parser to the node before the one we will remove
			Node<E> parser = head;
			for(int i=0;i<index-1;i++)
				parser = parser.next;
			//save the node we will delete in the removeNode variable
			Node<E> removedNode = parser.next;
			//let the before the removedNode point to the next node 
			parser.next = parser.next.next;
			// the next node of the removedNode point its previous pointer to the previous node of the removedNode
			parser.next.prev = parser;
			//decrement the size
			size--;
			//return the data of the removednode
			return removedNode.data;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;// head==null 
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.println("[]");
			return ;
		}
		Node<E> parse = head;
		System.out.print("[");
		while(parse!=null) {
			System.out.printf(parse.data+(parse.next!=null?"\t":""));
			parse = parse.next;
		}
		System.out.println("]");
	}
	static class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		
		Node(E data){
			this.data = data;
		}
		Node(E data,Node<E> next, Node<E> prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

}
//output
/*
[GB	GER	FR	IT	SP]
removeFromEnd() : SP
[GB	GER	FR	IT]
removeFromEnd() : IT
[GB	GER	FR]
removeFromEnd() : FR
[GB	GER]
[TN	GB	GER]
[TN	GB	GER	NE]
[TN	GB	IN	GER	NE]
remove(3) : GER
[TN	GB	IN	NE]
remove(3) : NE
[TN	GB	IN]
remove(0) : TN
[GB	IN]
*/