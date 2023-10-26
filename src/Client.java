/*
  @author   george
  @project   cafe
  @class  Client
  @version  1.0.0 
  @since 20.09.23 - 19.50
*/

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    private int id;
    private String pib;
    private String phone;
}
