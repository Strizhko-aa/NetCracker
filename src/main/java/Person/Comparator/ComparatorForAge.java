package Person.Comparator;

import Person.Person;

import java.util.Comparator;

public class ComparatorForAge implements Comparator <Person> {
  public int compare (Person p1, Person p2) {
    if (p1.getAge() > p2.getAge()) {
      return 1;
    } else {
      if (p1.getAge() < p2.getAge()) {
        return -1;
      } else {
        return 0;
      }
    }
  }
}
