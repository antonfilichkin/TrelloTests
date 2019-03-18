
package beans.board;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Membership {

    private String id;
    private String idMember;
    private String memberType;
    private Boolean unconfirmed;

}
