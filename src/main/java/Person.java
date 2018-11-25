import org.joda.time.DateTime;

public class Person {
  private int id;
  private String fullName;
  private String sex; // male/female
  private DateTime birthday;
  private int age;

  public void printPerson () {
    System.out.print("full name : " + this.fullName + ", sex: " + this.sex + ", birthday: " + this.birthday + ", age: " + this.age);
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

  public DateTime getBirthday() {
    return this.birthday;
  }

  public String getSex() {
    return this.sex;
  }

  public void setId() {
    this.id = DateTime.now().getMillisOfSecond();
  }

  public void setBirthday(DateTime birthday) {
    this.birthday = birthday;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  Person (String sex, DateTime bd) {
    setSex(sex);
    setBirthday(bd);
    setId();
  }
}
