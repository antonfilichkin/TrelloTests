
package beans.member;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class Member {

    private Object aaEmail;
    private Object aaId;
    private Object avatarHash;
    private String avatarSource;
    private Object avatarUrl;
    private String bio;
    private Object bioData;
    private Boolean confirmed;
    private String email;
    private String fullName;
    private String gravatarHash;
    private String id;
    private List<String> idBoards;
    private Object idBoardsPinned;
    private Object idEnterprise;
    private List<Object> idEnterprisesAdmin;
    private List<Object> idEnterprisesDeactivated;
    private Object idMemberReferrer;
    private List<Object> idOrganizations;
    private List<Object> idPremOrgsAdmin;
    private String initials;
    private Boolean isAaMastered;
    private Limits limits;
    private List<String> loginTypes;
    private MarketingOptIn marketingOptIn;
    private String memberType;
    private List<Object> messagesDismissed;
    private NonPublic nonPublic;
    private Boolean nonPublicAvailable;
    private List<String> oneTimeMessagesDismissed;
    private Prefs prefs;
    private List<Object> premiumFeatures;
    private List<Object> products;
    private String status;
    private List<Object> trophies;
    private Object uploadedAvatarHash;
    private Object uploadedAvatarUrl;
    private String url;
    private String username;

}
