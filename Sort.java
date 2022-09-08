/*
 * Class to sort methods
 * @author Steven Kravitz
 * @version  1.0
 * created 5/8/2021
 * last edited 5/12/2021
 */
import java.util.ArrayList;
public class Sort {
	//data member for iterations of each sort
	public static int[] iterations = new int[6];
	/*
	 * Method to sort an arrayList using a selection sort
	 */
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {//O(n^2)
		int minIndex;
		iterations[0] = 0;
		for (int i = 0; i<list.size() - 1; i++) {//O(n)
			iterations[0]++;
			E min = list.get(i);
			minIndex = i;
			for (int j = i + 1; j < list.size(); j++){//O(n)
				iterations[0]++;
				if (list.get(j).compareTo(min) < 0){
					min = list.get(j);
					minIndex = j;
				}
			}
			E temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}
	/*
	 * Method to sort an arrayList using an insertion sort
	 */
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {//O(n^2)
		iterations[1] = 0;
		for (int i = 1; i < list.size(); i++) {//O(n)
			iterations[1]++;
			//Insert element i in the sorted sub-list
			E currentVal = list.get(i);
			int j = i;
			while (j > 0 && currentVal.compareTo(list.get(j - 1)) < 0) {//O(n)
				iterations[1]++;
				// Shift element (j-1) into element (j)
				list.set(j, list.get(j - 1));
				j--;
			}
			// Insert currentVal at position i
			list.set(j, currentVal);
		}
	}
	/*
	 * Method to sort an arrayList using a bubble sort
	 */
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {//O(n^2)
		iterations[2] = 0;
		boolean sorted = false;
		for (int k = 1; k < list.size() && !sorted; k++) {//O(n)
			iterations[2]++;
			sorted = true;
			for (int i = 0; i<list.size() - k; i++) {//O(n)
				iterations[2]++;
				if (list.get(i).compareTo(list.get(i + 1)) > 0) {
					// swap
					E temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1,  temp);
					sorted = false;
				}
			}
		}
	}
	/*
	 * Method to sort an arrayList using a merge sort
	 */
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		iterations[3]++;
		if (list.size() > 1) { // base case
			ArrayList<E> firstHalf = subList(list, 0, list.size()/2);
			ArrayList<E> secondHalf = subList(list, list.size()/2, list.size());
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		}
	}
	public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end){
		ArrayList<E> newList = new ArrayList<>();
		for(int index =start; index < end; index++) {
			iterations[3]++;
			newList.add(list.get(index));
		}
		return newList;
	}
	public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
		int i1=0, i2=0, i=0;
		while( i1 < list1.size() && i2 < list2.size()) {
			iterations[3]++;
			if (list1.get(i1).compareTo(list2.get(i2)) < 0) {
				list.set(i++,list1.get(i1++));
			}
			else {
				list.set(i++, list2.get(i2++));
			}
		}
		while(i1 < list1.size()) {
			iterations[3]++;
			list.set(i++, list1.get(i1++));
		}
		while(i2 < list2.size()) {
			iterations[3]++;
			list.set(i++, list2.get(i2++));
		}
	}
	/*
	 * Method to sort an arrayList using a quick sort
	 */
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quickSort(list, 0, list.size() - 1);
	}
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
		iterations[4]++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex+1, last);
		}
	}
	public static <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last) {
		E pivot;
		int index, pivotIndex;
		pivot = list.get(first);// pivot is the first element
		pivotIndex = first;
		for (index = first + 1; index <= last; index++) {
			iterations[4]++;
			if (list.get(index).compareTo(pivot) < 0) {
				pivotIndex++;
				swap(list, pivotIndex, index);
			}
		}
		swap(list, first, pivotIndex);
		return pivotIndex;
	}
	public static <E> void swap(ArrayList<E> list, int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	/*
	 * Method to sort an arrayList sing a heapSort
	 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<>(list);
		for (int i=list.size() - 1; i>=0; i--) {
			iterations[5]++;
			list.set(i, heap.delete());
		}
	}
}