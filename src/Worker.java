/*
  @author   george
  @project   cafe
  @class  Worker
  @version  1.0.0 
  @since 20.09.23 - 19.56
*/

import java.time.LocalDate;

public class Worker extends Person{
    private String occupation;

    public Worker(String pib, LocalDate birthday, String occupation) {
        super(pib, birthday);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return super.toString() + " Worker{" +
                "occupation='" + occupation + '\'' +
                '}';
    }
}
