import org.joda.time.LocalDate;

public class Repository {
  private Person[] persons;
  private Integer count;
  private Integer length;

  Repository() {
    this.persons = new Person[10];
    this.count = 0;
    this.length = 10;
  }

  public void addPerson (Person pers) {
    if (this.length - this.count <= 1) {
      this.length = (int)(this.length * 1.5);
      Person []tmpMass = new Person[length];
      for (int i = 0; i < this.count; i++) {
        tmpMass[i] = this.persons[i];
      }
      this.persons = tmpMass;
    }
    this.persons[this.count] = pers;
    this.count++;
  }

  public Person getPersonByFullName (String fullName) {
    for (int i = 0; i < this.count; i++) {
      if (this.persons[i].getFullName() == fullName) {
        return this.persons[i];
      }
    }
//    return new Person("error", "error", new LocalDate("01-01-999"));
    return null;
  }

  public void deletePersonByFullName (String fullName) {
    Person tmpPers = getPersonByFullName(fullName);
    if (tmpPers != null) {
      Person[] tmpMass = new Person[this.length - 1];
      for (int i = 0, j = 0; j < this.count; i++, j++) {
        if (!tmpPers.equals(this.persons[j])) {
          tmpMass[i] = this.persons[j];
        } else {
          tmpMass[i] = this.persons[++j];
        }
      }
      this.persons = tmpMass;
      this.count--;
      this.length--;
    }
  }

  public Person[] showRepository () {
    for (int i = 0; i < this.count; i++) {
      System.out.println(this.persons[i]);
    }
    System.out.println("count = " + this.count + " length = " + this.length);
    return this.persons;
  }
}
