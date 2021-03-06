package Person;

import org.joda.time.LocalDate;


public class Person {
  private int id;
  private String fullName;
  private String sex; // male/female
  private LocalDate birthday;
  private int age;

  /**
   * @return строку с всеми данными о пользователе
   */
  @Override
  public String toString () {
    return "full name : " + getFullName() + ", sex: " + getSex() + ", birthday: " + getBirthday() + ", age: " + getAge() + " id: " + getId();
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

  public void setId() {
    this.id = (int) (Math.random() * 100);
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    setAge();
  }

  public void setSex(String sex) {
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

  @Override
  public boolean equals(Object other){
    if (other == null) return false;
    if (other == this) return true;
    if (!(other instanceof Person))return false;
    if (((Person) other).age == this.age && ((Person) other).fullName == this.fullName && ((Person) other).id == this.id) {
      return true;
    } else {
      return false;
    }
  }

  // конструктор. принимает полное имя(String), пол(String "male/female"), дату (LocalDate)

  /**
   *
   * @param fullName
   * @param sex
   * @param bd
   */
  public Person(String fullName, String sex, LocalDate bd) {
    setFullName(fullName);
    setSex(sex);
    setBirthday(bd);
    setId();
  }
}
