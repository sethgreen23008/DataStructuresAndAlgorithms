
public class LinkedList<E> implements List<E> {
	private Node<E> head = new Node<E>();
	private int size = 0;
	
	public static void main(String[] args) {
		LinkedList<String> nations = new LinkedList<String>();
		nations.add("GER");
		nations.add("TN");
		nations.add("GB");
		nations.add("IT");
		nations.add("HU");
		nations.print();
		System.out.println("remove(): "+nations.remove());
		nations.print();
	}


	
	@Override
	public boolean add(E element) {
		//here the new node will have as next the head and as previous the head.previous
		//for the first element the next and previous is the head then with that we will have like a ring linked list
		//after that any element will be having as next the head and as previous the previous of the head which is the last element of the list
		//then itself it will point as the previous then become the last
		head.prev=head.prev.next= new Node<E>(element,head,head.prev);
		size++;
		return true;
	}



	@Override
	public E remove() {
		//we save the removedNode 
		Node<E> removedNode = head.next;
		//head next node will be the head next next node
		head.next = head.next.next;
		//the previous of the head next next node will be head
		head.next.prev = head;
		size--;
		removedNode.next = null;
		removedNode.prev = null;
		return removedNode.data;
	}



	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}	
	
	public void print() {
		Node<E> parse = head.next;
		System.out.print("[");
		while(parse!=head) {
			System.out.print(parse.data+(parse.next!=head?"\t":""));
			parse = parse.next;
		}
//		System.out.println(parse.data);
		System.out.println("]");
	}
	
	static class Node<E>{
		E data;
		Node<E> next;
		Node<E> prev;
		
		Node(){
			this.next = this.prev = this;
		}
		Node(E data, Node<E> next, Node<E> prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
}
