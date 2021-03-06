import Person.Comparator.ComparatorForFullName;
import Person.Comparator.ComparatorForId;
import Person.Person;
import Person.sort.bubble;
import Person.sort.pasteSort;
import Person.sort.shakeSort;
import Person.sort.sort;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;


// тест вычисления дат
public class RepoTest {

  private static Logger log = Logger.getLogger(RepoTest.class.getName());

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
    repo.addPerson(user3);
    repo.addPerson(user4);
    repo.addPerson(user5);
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

  //  сортировка пузырьком по Имени
  @Test
  public void testBubbleSortByName () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
    repo.addPerson(user3);
    repo.addPerson(user4);
    repo.addPerson(user5);
    sort bubbleSorter = new bubble();
    ComparatorForFullName compFN = new ComparatorForFullName();
    System.out.println("before testBubbleSortByName");
    repo.showRepository();
    bubbleSorter.sort(repo.getPersons(), repo.getCount(), compFN);
    System.out.println("after testBubbleSortByName");
    repo.showRepository();
  }

  // сортировка пузырьком по ИД
  @Test
  public void testBubbleSortById () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
    repo.addPerson(user3);
    repo.addPerson(user4);
    repo.addPerson(user5);
    sort bubbleSort = new bubble();
    ComparatorForId compId = new ComparatorForId();
    System.out.println("before testBubbleSortById");
    repo.showRepository();
    bubbleSort.sort(repo.getPersons(), repo.getCount(), compId);
    System.out.println("after testBubbleSortById");
    repo.showRepository();
  }


  // сортировка вставкой по имени
  @Test
  public void testPasteSortName () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
    repo.addPerson(user3);
    repo.addPerson(user4);
    repo.addPerson(user5);
    sort bubbleSort = new pasteSort();
    ComparatorForFullName compName = new ComparatorForFullName();
    System.out.println("before testPasteSortName");
    repo.showRepository();
    bubbleSort.sort(repo.getPersons(), repo.getCount(), compName);
    System.out.println("after testPasteSortName");
    repo.showRepository();
  }

  // сортировка перемешиванием по ИД
  @Test
  public void testShakeSortId () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
    repo.addPerson(user3);
    repo.addPerson(user4);
    repo.addPerson(user5);
    sort shakeSort = new shakeSort();
    ComparatorForId compId = new ComparatorForId();
    System.out.println("before testShakeSortId");
    repo.showRepository();
    shakeSort.sort(repo.getPersons(), repo.getCount(), compId);
    System.out.println("after testShakeSortId");
    repo.showRepository();
  }

  @Test
  public void createRepoWithSort () {
    sort shake = new shakeSort();
    Repository repo = new Repository(shake);
    repo.addPerson(user2);  // Petya
    repo.addPerson(user1);  // Vicheslav
    System.out.println("before createRepoWithSort");
    repo.showRepository();
    repo.sort("fullName");
    System.out.println("after createRepoWithSort");
    repo.showRepository();
  }

  // тест injection Если при стандартном конструкторе сортровка вставкой, занчит это значение из файла
  @Test
  public void testInjection () {
    Repository repo = new Repository();
    repo.addPerson(user1);
    repo.addPerson(user2);
    repo.addPerson(user3);
    repo.addPerson(user4);
    repo.addPerson(user5);
    repo.sort("fullName");
    String expected = "Person.sort.pasteSort";
    String actualy = repo.getSortType();
  }
}
