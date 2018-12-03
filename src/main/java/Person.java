import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Person {
  private int id;
  private String fullName;
  private String sex; // male/female
  private LocalDate birthday;
  private int age;

  public void printPerson () {
    System.out.print("full name : " + getFullName() + ", sex: " + getSex() + ", birthday: " + getBirthday() + ", age: " + getAge() + " id: " + getId());
  }

  public int getId() {
    return this.id;
  }

  public String getFullName() {
    return this.fullName;
  }

  public int getAge() {
    return this.age;
  }

  public LocalDate getBirthday() {
    return this.birthday;
  }

  public String getSex() {
    return this.sex;
  }

  private void setId() {
    this.id = DateTime.now().getMillisOfSecond();
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  private void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }

  private void setSex(String sex) {
    this.sex = sex;
  }

  private void setAge() { // need seted birthday
    LocalDate tmpDateNow = new LocalDate(LocalDate.now());
    this.age = tmpDateNow.getYear() - getBirthday().getYear();
    int tmpAgeMounth = tmpDateNow.getMonthOfYear() - getBirthday().getMonthOfYear();
    int tmpAgeDays = tmpDateNow.getDayOfMonth() - getBirthday().getDayOfMonth();
    if (tmpAgeMounth < 0 || tmpAgeDays < 0) {
      this.age--;
    }
  }

  Person (String fullName, String sex, LocalDate bd) {
    setFullName(fullName);
    setSex(sex);
    setBirthday(bd);
    setId();
    setAge();
  }
}
