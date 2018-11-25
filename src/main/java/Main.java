import org.joda.time.DateTime;

public class Main {
  public static void main(String[] args) {
    Repository repo = new Repository();
    Person vasya = new Person("male", new DateTime("2000-01-02"));
    repo.addPerson(vasya);
    repo.showRepository();
  }
}
