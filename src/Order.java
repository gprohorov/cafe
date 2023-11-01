import lombok.*;

/*
  @author   george
  @project   cafe
  @class  Order
  @version  1.0.0 
  @since 01.11.23 - 12.44
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private  int id;
    private String name;
    private int price;
    private Client client;
}
