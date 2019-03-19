
package beans.list;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class List<C> {

    private Boolean closed;
    private String id;
    private String idBoard;
    private Limits limits;
    private String name;
    private long pos;

}
