import Person.Person;

public class Repository {
  private Person[] persons;
  private Integer count;
  private Integer length;

  Repository() {
    this.persons = new Person[10];
    this.count = 0;
    this.length = 10;
  }

  //добавляет пользователя в репозиторий, если занимается предпоследний слот, то расширяется в полтора раза
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

//  поиск по имени

  /**
   *
   * @param fullName
   * @return Person.Person or null
   */
  public Person getPersonByFullName (String fullName) {
    for (int i = 0; i < this.count; i++) {
      if (this.persons[i].getFullName() == fullName) {
        return this.persons[i];
      }
    }
    return null;
  }

  // удаление по fullname. Также уменьшает размерность на 1
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

  // вывод репозитория
  public Person[] showRepository () {
    for (int i = 0; i < this.count; i++) {
      System.out.println(this.persons[i]);
    }
    System.out.println("count = " + this.count + " length = " + this.length);
    return this.persons;
  }
}
