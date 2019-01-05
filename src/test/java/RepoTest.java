import Person.Comparator.ComparatorForFullName;
import Person.Person;
import org.joda.time.LocalDate;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


// тест вычисления дат
public class RepoTest {

  Person user1 = new Person("Petya Ivanov", "male", new LocalDate("2000-12-01"));
  Person user2 = new Person("Vicheslav Stroganov", "male", new LocalDate("2001-12-31"));
  Person user3 = new Person("Petuhov Ilia", "male", new LocalDate("2000-12-31"));
  Person user4 = new Person("Skebko Lubov", "female", new LocalDate("2000-12-31"));
  Person user5 = new Person("Petya Ivanov2", "male", new LocalDate("2000-12-31"));

  @Test
  public void testComputedAge () {
    int expected = 18;
    int actual = user1.getAge();
    int expected2 = 17;
    int actual2 = user2.getAge();
    assertEquals(expected, actual);
    assertEquals(expected2, actual2);
  }

  @Test
  public void testAddRepo () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
  }

  @Test
  public void testCompFullName () {
    ComparatorForFullName compFN = new ComparatorForFullName();
    int actual = compFN.compare(user1, user4);  //  Petua and Skebko
    assertEquals(-1, actual);
    int actual2 = compFN.compare(user4, user1);  //  Skebko and Petua
    assertEquals(1, actual2);
    int actual3 = compFN.compare(user1, user1); //  equals name
    assertEquals(0, actual3);
  }
}
