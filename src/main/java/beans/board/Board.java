
package beans.board;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Board {

    private Boolean closed;
    private String dateLastActivity;
    private String dateLastView;
    private Object datePluginDisable;
    private String desc;
    private Object descData;
    private String id;
    private String idOrganization;
    private List<Object> idTags;
    private List<Object> invitations;
    private Boolean invited;
    private LabelNames labelNames;
    private Limits limits;
    private List<Membership> memberships;
    private String name;
    private Boolean pinned;
    private List<Object> powerUps;
    private Prefs prefs;
    private String shortLink;
    private String shortUrl;
    private Boolean starred;
    private Boolean subscribed;
    private String url;

}
