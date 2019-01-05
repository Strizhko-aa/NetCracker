package Person.Comparator;

import Person.Person;

import java.util.Comparator;

public class ComparatorForId implements Comparator<Person> {

  public int compare(Person p1, Person p2) {
    if (p1.getId() > p2.getId()) {
      return 1;
    } else {
      if (p1.getId() < p2.getId()) {
        return -1;
      } else {
        return 0;
      }
    }
  }
}
