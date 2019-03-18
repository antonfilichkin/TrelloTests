
package beans.board;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Prefs {

    private String background;
    private String backgroundBottomColor;
    private String backgroundBrightness;
    private String backgroundImage;
    private List<BackgroundImageScaled> backgroundImageScaled;
    private Boolean backgroundTile;
    private String backgroundTopColor;
    private Boolean calendarFeedEnabled;
    private Boolean canBeEnterprise;
    private Boolean canBeOrg;
    private Boolean canBePrivate;
    private Boolean canBePublic;
    private Boolean canInvite;
    private String cardAging;
    private Boolean cardCovers;
    private String comments;
    private String invitations;
    private String permissionLevel;
    private Boolean selfJoin;
    private String voting;

}
