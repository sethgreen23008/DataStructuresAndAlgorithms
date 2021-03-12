
public interface List<E> {
	public boolean addToFront(E element);
	public E removeToFront();
	public boolean addToEnd(E element);
	public E removeFromEnd();
	public boolean add(E element,int index);
	public E remove(int index);
	public int size();
	public boolean isEmpty();
	
}
