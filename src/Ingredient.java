/*
  @author   george
  @project   cafe
  @class  Food
  @version  1.0.0 
  @since 20.09.23 - 19.27
*/

import java.time.LocalDate;

public class Ingredient implements IFreshness{
    private String name;
    private LocalDate expirationDate;

    public Ingredient() {
    }

    public Ingredient(String name, LocalDate expirationDate) {
        this.name = name;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
