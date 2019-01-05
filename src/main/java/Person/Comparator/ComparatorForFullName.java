package Person.Comparator;

import Person.Person;

import java.util.Comparator;

public class ComparatorForFullName implements Comparator<Person> {
  public int compare(Person p1, Person p2) {
    int res = p1.getFullName().compareTo(p2.getFullName());
    if (res > 0) {
      return 1;
    } else {
      if (res < 0) {
        return -1;
      } else {
        return 0;
      }
    }
  }
}
