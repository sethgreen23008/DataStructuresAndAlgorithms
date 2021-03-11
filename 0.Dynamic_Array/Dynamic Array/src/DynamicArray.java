
public class DynamicArray<T> {
	private T[] data;
	private final int CAPACITY=4;
	private int size=0;
	private  Class<T> genericType;
	public DynamicArray() {
		data = (T[]) new Object[CAPACITY];
	}
	
	public DynamicArray(int capacity) {
		data = (T[]) new Object[capacity];
	}


    //add element function
	public void add(T element) {
		//check if the new size equal the length of the backup array if so resize the backup array
		if((size+1)==data.length) {
			resize();
		}
		data[size++]=element;
	}
	
	public T remove(int index) {
		//if the index less the 0 and great of equal the size the throw exception
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		//remove the element at the index
		T removed = data[index];
		//do the necessary shifting
		System.arraycopy(data, index+1, data, index, data.length-index-1);
		//decrement the size
		size--;
		return removed;
	}
	
	public T removeObject(Object o) {
		T element = (T)o;
		for(int i=0;i<data.length;i++) {
			T current = data[i];
			if(current.equals(element)) {
				return remove(i);
			}
		}
		return null;
	}
	
	private void resize() {
		int length = data.length;
		int size = size();
		//give the new array double the size of the old one
		Object[] temp = new Object[length*2];
		//copy all the elements of the old array to the new one
		System.arraycopy(data, 0, temp, 0, size);
		data = (T[])temp;
	}
	public  int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void print() {
		//print the element 
		for(int i=0;i<size;i++) {
			System.out.print(data[i]+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DynamicArray<String> list = new DynamicArray<String>();
		list.add("TN");
		list.add("GB");
		list.add("GER");
		list.add("IT");
		list.add("HU");
		list.add("SP");
		list.print();
		String removed = list.removeObject("SP");
		System.out.println("removeObject(\"SP\") :"+removed);
		list.print();
		removed = list.remove(2);
		System.out.println("remove(2) :"+removed);
		list.print();
		list.add("IN");
		list.add("CAM");
		list.add("SEN");
		list.add("POL");
		list.add("AUS");
		list.add("POR");
		list.print();
		DynamicArray<Player> list1 = new DynamicArray<Player>();
		list1.add(new Player("James"));
		list1.add(new Player("Harden"));
		list1.add(new Player("Brown"));
		Player p = list1.removeObject(new Player("James"));
		System.out.println("removeObject(\"James\") :"+p);
		list1.print();
		
	}
}
//output
/*
TN	GB	GER	IT	HU	SP	
removeObject("SP") :SP
TN	GB	GER	IT	HU	
remove(2) :GER
TN	GB	IT	HU	
TN	GB	IT	HU	IN	CAM	SEN	POL	AUS	POR	
removeObject("James") :Player [name=James]
Player [name=Harden]	Player [name=Brown]
 */