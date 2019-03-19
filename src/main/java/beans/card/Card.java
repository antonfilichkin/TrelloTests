
package beans.card;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Card {

    private List<Object> attachments;
    private Badges badges;
    private List<Object> checkItemStates;
    private Boolean closed;
    private String dateLastActivity;
    private String desc;
    private DescData descData;
    private String due;
    private Boolean dueComplete;
    private Object dueReminder;
    private Object email;
    private String id;
    private Object idAttachmentCover;
    private String idBoard;
    private List<Object> idChecklists;
    private List<Object> idLabels;
    private String idList;
    private List<Object> idMembers;
    private List<Object> idMembersVoted;
    private long idShort;
    private List<Object> labels;
    private Limits limits;
    private Boolean manualCoverAttachment;
    private String name;
    private long pos;
    private String shortLink;
    private String shortUrl;
    private List<Object> stickers;
    private Boolean subscribed;
    private String url;

}
