package Person.sort;

import Person.Person;

import java.util.Comparator;

public class bubble implements sort {
	public void sort(Person[] arr, int personCount, Comparator<Person> comp) {
		for (int i = 0; i < personCount; i++) {
			for (int j = 0; j < personCount - 1; j++) {
				if (comp.compare(arr[j],arr[j+1]) == 1) {
					Person tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
