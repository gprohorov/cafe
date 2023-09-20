/*
  @author   george
  @project   cafe
  @class  Person
  @version  1.0.0 
  @since 20.09.23 - 19.48
*/

import java.time.LocalDate;

public abstract class Person {
    private String pib;
    private LocalDate birthday;

    public Person() {
    }

    public Person(String pib, LocalDate birthday) {
        this.pib = pib;
        this.birthday = birthday;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pib='" + pib + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
