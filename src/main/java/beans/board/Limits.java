
package beans.board;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Limits {

    private Attachments attachments;
    private Boards boards;
    private Cards cards;
    private Checklists checklists;
    private CustomFields customFields;
    private Labels labels;
    private Lists lists;

}
