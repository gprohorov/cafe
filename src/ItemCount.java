/*
  @author   george
  @project   cafe
  @class  ItemCount
  @version  1.0.0 
  @since 21.09.23 - 11.58
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@AllArgsConstructor
public class ItemCount {
    private String name;
    private long count;


}
