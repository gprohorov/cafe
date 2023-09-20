/*
  @author   george
  @project   cafe
  @class  CafeRecord
  @version  1.0.0 
  @since 20.09.23 - 20.00
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class CafeRecord {
    private Client client;
    private Item item;
    private Worker worker;
    private int price;
    private LocalDate date;
}
