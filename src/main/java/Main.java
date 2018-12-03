import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    Repository repo = new Repository();
    Person vasya = new Person("Vasya Vasua","male", new LocalDate("2000-12-04"));
    repo.addPerson(vasya);
    repo.showRepository();
  }
}
