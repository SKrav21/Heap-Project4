/*
 * Class to create the Heap
 * @author Steven Kravitz
 * @version 1.1
 * created 4/20/21
 * Last edited 5/12/21
 */
import java.util.ArrayList;
public class Heap<E extends Comparable<E>> {
	private ArrayList<E> list;
	
	public Heap(){ //O(1)
		list = new ArrayList<>();
	}
	public Heap(E[] data) { 
		list = new ArrayList<>();
		for(int i=0; i<data.length; i++)
			insert(data[i]); //O(log n)
	}
	public Heap(ArrayList<E> data) { 
		list = new ArrayList<>();
		for(int i=0; i<data.size(); i++) {
			Sort.iterations[5]++;
			insert(data.get(i)); //O(log n)
		}
	}
	public int insert(E item) {
		int iterations = 0;
		list.add(item); //append item to the heap
		int currentIndex = list.size()-1;
		 //index of the last element
		while(currentIndex > 0) { //O(log n)
			Sort.iterations[5]++;
			iterations++;
			int parentIndex = (currentIndex-1)/2;
			//swap if current is greater than its parent
			E current = list.get(currentIndex);
			E parent = list.get(parentIndex);
			if(current.compareTo(parent) > 0) {
				list.set(currentIndex, parent);
				list.set(parentIndex, current);
			}
			else
				break; // the tree is a heap
			currentIndex = parentIndex;
		}
		return iterations;
	}
	public E delete() {
		if(list.size() == 0) return null;
		E removedItem = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			Sort.iterations[5]++;
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			//find the maximum of the two children
			if (left >= list.size()) 
				break;//reached the end
			int maxIndex = left;
			E max = list.get(maxIndex);
			if (right < list.size())
				if(max.compareTo(list.get(right)) < 0)
					maxIndex = right;
			// swap if current is less than the maximum
			E current = list.get(currentIndex);
			max = list.get(maxIndex);
			if(list.get(currentIndex).compareTo(max) < 0) {
				list.set(maxIndex, current);
				list.set(currentIndex, max);
				currentIndex = maxIndex;
			}
			else
				break; // the tree is a heap
		}
		return removedItem;
	}
	public int search(E item) {
		int iterations = 0;
		for(int i=0; i<list.size(); i++) {
			iterations++;
			if(list.get(i).equals(item)) {
				return iterations;
			}
		}
			return iterations;
	}
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void clear(){
		list.clear();
	}
	public String toString(){
		return list.toString();
	}
}