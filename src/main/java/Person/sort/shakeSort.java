package Person.sort;

import Person.Person;

import java.util.Comparator;
import java.util.logging.Logger;

public class shakeSort implements sort {

	private static Logger log = Logger.getLogger(shakeSort.class.getName());

	public void sort(Person[] arr, int personCount, Comparator<Person> comp) {
		log.info("start bubble sort, comparator: " + comp.getClass().getName());
		Person buff;
		int left = 0;
		int right = personCount - 1;
		do {
			for (int i = left; i < right; i++) {
				if (comp.compare(arr[i], arr[i+1]) == 1) {
					buff = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = buff;
				}
			}
			right--;
			for (int i = right; i > left; i--) {
				if (comp.compare(arr[i], arr[i-1]) == -1) {
					buff = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = buff;
				}
			}
			left++;
		} while (left <right);
		log.fine("shake sort success");
	}
}
