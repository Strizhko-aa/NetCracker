package Person.checker;

import Person.Person;

public class CheckByFullName implements Checker {
  public boolean check(Person p, Object o) {
    if (p.getFullName() == ((String)o)) {
      return true;
    } else {
      return false;
    }
  }
}
