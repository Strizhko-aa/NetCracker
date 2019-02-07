package Person.sort;

import Person.Person;

import java.util.Comparator;
import java.util.logging.Logger;

public class pasteSort implements sort {

	private static Logger log = Logger.getLogger(pasteSort.class.getName());

	public void sort(Person[] arr, int personCount, Comparator<Person> comp) {
		log.info("start paste sort, comparator: " + comp.getClass().getName());
		for (int i = 0; i < personCount; i++) {
			int mini = i;
			for (int j = i; j < personCount; j++) {
				if (comp.compare(arr[j], arr[mini]) == -1) {
					mini = j;
				}
			}
			Person tmp = arr[i];
			arr[i] = arr[mini];
			arr[mini] = tmp;
		}
		log.fine("paste sort success");
	}
}
