/*
  @author   george
  @project   cafe
  @class  Client
  @version  1.0.0 
  @since 20.09.23 - 19.50
*/

import java.time.LocalDate;

public class Client extends Person{
    private String phoneNumber;

    public Client(String pib, LocalDate birthday, String phoneNumber) {
        super(pib, birthday);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
