import Person.Comparator.ComparatorForFullName;
import Person.Comparator.ComparatorForId;
import Person.Person;
import Person.sort.bubble;
import Person.sort.sort;

import java.util.logging.Logger;

public class Repository {

  private static Logger log = Logger.getLogger(Repository.class.getName());

  private Person[] persons;
  private Integer count;  //  кол-во элементов
  private Integer length; // максимальная длинна
  private sort sortType;

//  создает пустой репозиторий на 10 персон и пузырьковым сортировщиком
  public Repository () {
    this.persons = new Person[10];
    this.count = 0;
    this.length = 10;
    this.sortType = new bubble();
    log.info("repository created");
  }

  public Repository (sort sorter) {
    this.persons = new Person[10];
    this.count = 0;
    this.length = 10;
    this.sortType = sorter;
    log.info("repository created");
  }

  public Person[] getPersons() {
    return persons;
  }

  public Integer getCount() {
    return count;
  }

  public Integer getLength() {
    return length;
  }

  //добавляет пользователя в репозиторий, если занимается предпоследний слот, то расширяется в полтора раза
  public void addPerson (Person pers) {
    log.info("add person");
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
    log.info("try get person by full name");
    for (int i = 0; i < this.count; i++) {
      if (this.persons[i].getFullName() == fullName) {
        return this.persons[i];
      }
    }
    return null;
  }

  // удаление по fullname. Также уменьшает размерность на 1
  public void deletePersonByFullName (String fullName) {
    log.info("try del by full name");
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

  // принимает имя поля, по которому сортировать
  // fullName, id
  public void sort (String fieldName) {
    if (fieldName.equals("fullName")) {
      ComparatorForFullName comp = new ComparatorForFullName();
      this.sortType.sort(this.getPersons(), this.getCount(), comp);
    } else {
      if (fieldName.equals("id")) {
        ComparatorForId comp =  new ComparatorForId();
        this.sortType.sort(this.getPersons(), this.getCount(), comp);
      } else {  //  если ничего не подошло, то сортировать по имени
        ComparatorForFullName comp = new ComparatorForFullName();
        this.sortType.sort(this.getPersons(), this.getCount(), comp);
      }
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
