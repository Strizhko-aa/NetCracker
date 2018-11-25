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
    if (this.length - this.count <= 2) {
      this.persons = new Person[this.length + (int) java.lang.Math.round(this.length * 0.1)];
    }
    this.persons[this.count] = pers;
    this.count++;
  }

  public Person[] showRepository () {
    for (int i = 0; i < this.count; i++) {
      this.persons[i].printPerson();
    }
    return this.persons;
  }
}
