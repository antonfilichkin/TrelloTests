
package beans.card;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Badges {

    private long attachments;
    private AttachmentsByType attachmentsByType;
    private long checkItems;
    private long checkItemsChecked;
    private long comments;
    private Boolean description;
    private String due;
    private Boolean dueComplete;
    private String fogbugz;
    private Boolean location;
    private Boolean subscribed;
    private Boolean viewingMemberVoted;
    private long votes;

}
