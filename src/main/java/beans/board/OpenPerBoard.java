
package beans.board;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class OpenPerBoard {

    private long disableAt;
    private String status;
    private long warnAt;

}
