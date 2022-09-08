/*
 * Class to test sorting methods
 * @author Steven Kravitz
 * @version  1.0
 * created 5/12/2021
 * last edited 5/12/2021
 */
import java.util.ArrayList;
import java.util.Random;
public class Testing {
	public static void main(String[] args) {
		//creation of lists
		ArrayList<Integer> randomList = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 10000; i++) {
			randomList.add(random.nextInt(100000));
		}
		ArrayList<Integer> sortedList = (ArrayList)randomList.clone();
		java.util.Collections.sort(sortedList);
		ArrayList<Integer> reversedList = (ArrayList)sortedList.clone();
		java.util.Collections.reverse(reversedList);
		//lists of iterations for each
		int[] randomIterations = new int[6];
		int[] sortedIterations = new int[6];
		int[] reversedIterations = new int[6];
		
		//selectionSort
		Sort.selectionSort(randomList);
		java.util.Collections.shuffle(randomList);
		randomIterations[0] =  Sort.iterations[0];
		Sort.selectionSort(sortedList);
		sortedIterations[0] =  Sort.iterations[0];
		Sort.selectionSort(reversedList);
		java.util.Collections.reverse(reversedList);
		reversedIterations[0] =  Sort.iterations[0];
		
		//insertionSort
		Sort.insertionSort(randomList);
		java.util.Collections.shuffle(randomList);
		randomIterations[1] =  Sort.iterations[1];
		Sort.insertionSort(sortedList);
		sortedIterations[1] =  Sort.iterations[1];
		Sort.insertionSort(reversedList);
		java.util.Collections.reverse(reversedList);
		reversedIterations[1] =  Sort.iterations[1];
		
		//bubbleSort
		Sort.bubbleSort(randomList);
		java.util.Collections.shuffle(randomList);
		randomIterations[2] =  Sort.iterations[2];
		Sort.bubbleSort(sortedList);
		sortedIterations[2] =  Sort.iterations[2];
		Sort.bubbleSort(reversedList);
		java.util.Collections.reverse(reversedList);
		reversedIterations[2] =  Sort.iterations[2];
		
		//mergeSort
		Sort.mergeSort(randomList);
		java.util.Collections.shuffle(randomList);
		randomIterations[3] =  Sort.iterations[3];
		Sort.iterations[3] = 0;
		Sort.mergeSort(sortedList);
		sortedIterations[3] =  Sort.iterations[3];
		Sort.iterations[3] = 0;
		Sort.mergeSort(reversedList);
		java.util.Collections.reverse(reversedList);
		reversedIterations[3] =  Sort.iterations[3];
		
		//quickSort
		Sort.quickSort(randomList);
		java.util.Collections.shuffle(randomList);
		randomIterations[4] =  Sort.iterations[4];
		Sort.iterations[4] = 0;
		Sort.quickSort(sortedList);
		sortedIterations[4] =  Sort.iterations[4];
		Sort.iterations[4] = 0;
		Sort.quickSort(reversedList);
		java.util.Collections.reverse(reversedList);
		reversedIterations[4] =  Sort.iterations[4];
		
		//heapSort
		Sort.heapSort(randomList);
		randomIterations[5] =  Sort.iterations[5];
		Sort.iterations[5] = 0;
		Sort.heapSort(sortedList);
		sortedIterations[5] =  Sort.iterations[5];
		Sort.iterations[5] = 0;
		Sort.heapSort(reversedList);
		reversedIterations[5] =  Sort.iterations[5];
		
		//prints the results
		System.out.printf("%-16s\t%-20s\t%-20s\t%-20s\n", "Sorting Algorithm", "Random List", "Sorted List", "Reversed List");
		String[] algorithms = {"Selection Sort", "Insertion Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
		for(int i = 0; i < 6; i++) {
			System.out.printf("%-16s\t%-20d\t%-20d\t%-20d\n", algorithms[i], randomIterations[i], sortedIterations[i], reversedIterations[i]);
		}
		
		//RESULTS DISCUSSED
		/*
		 * For the random list, the heap sort had the best performance and was closely followed by the quick and merge sort.
		 * The bubble sort, insertion sort, and selection sort all performed at or close to worst case performance.
		 * For the sorted list, the Insertion and bubble sort methods had the best performance and were followed by the heap and merge sort.
		 * The Selection and quick sort performed at or close to worst case performance.
		 * For the reversed list, the heap sort had the best performance and was closely followed by the merge sort.
		 * The Selection, insertion, bubble, and quick sort methods all performed at or close to worst case performance. 
		 * 
		 * In general, the heap and merge sorts had the best overall performance.
		 * The quick sort was really good for when the list is  random but if it is sorted at all, the performance will be very bad. 
		 * The insertion and bubble sort methods performed amazingly when the method was pre-sorted in order.
		 * This is a very unrealistic scenario for most applications. In the other scenarios, these algorithms performed terribly.
		 * The worst algorithm was the selection sort method. It had or was tied for the worst performance in every scenario.
		 * There is almost no reason to ever use this algorithm.
		 */
	}
}
