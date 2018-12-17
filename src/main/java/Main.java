import org.joda.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    Repository repo = new Repository();
    Person vasya = new Person("Vasya Vasua","male", new LocalDate("2000-12-24"));
    Person vasya2 = new Person("Vasya Vasua2","male", new LocalDate("2000-12-24"));
    Person vasya3 = new Person("Vasya Vasua3","male", new LocalDate("2000-12-24"));
    repo.addPerson(vasya);
    repo.addPerson(vasya2);
    repo.addPerson(vasya3);
    repo.deletePersonByFullName("Vasya Vasua");
    repo.showRepository();
    System.out.println("i found -> " + repo.getPersonByFullName("Vasya Vasua"));
  }
}
