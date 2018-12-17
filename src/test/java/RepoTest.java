import org.joda.time.LocalDate;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RepoTest {

  Person user1 = new Person("Petya", "male", new LocalDate("2000-12-01"));
  Person user2 = new Person("Petya2", "male", new LocalDate("2000-12-31"));

  @Test
  public void testComputedAge () {
    int expected = 18;
    int actual = user1.getAge();
    int expected2 = 17;
    int actual2 = user2.getAge();
    assertEquals(expected, actual);
    assertEquals(expected2, actual2);
  }

  public void testAddRepo () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
  }
}
