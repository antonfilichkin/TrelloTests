package enums;

public enum QueryParams {
    // Common
    KEY("key"),
    TOKEN("token"),
    NAME("name"),

    // New board
    DESC("desc"),
    PREFS_BACKGROUND("prefs_background"),

    //Update board
    CLOSED("closed"),
    PREFS_BACKGROUND_U("prefs/background"),

    //Post List
    ID_BOARD("idBoard"),
    ID_LIST_SOURCE("idListSource"),
    POS("pos"),

    //Post Card
    ID_LIST("idList"),
    DUE("due"),
    DUE_COMPLETE("dueComplete");

    public final String queryParam;

    QueryParams(String param) {
        this.queryParam = param;
    }
}

//    // New board
//    DEFAULT_LABELS("defaultLabels"),
//    DEFAULT_LISTS("defaultLists"),
//    DESC("desc"),
//    ID_ORGANIZATION("idOrganization"),
//    ID_BOARD_SOURCE("idBoardSource"),
//    KEEP_FROM_SOURCE("keepFromSource"),
//    POWER_UPS("powerUps"),
//    PREFS_PERMISSION_LEVEL("prefs_permissionLevel"),
//    PREFS_VOTING("prefs_voting"),
//    PREFS_COMMENTS("prefs_comments"),
//    PREFS_INVITATIONS("prefs_invitations"),
//    PREFS_SELF_JOIN("prefs_selfJoin"),
//    PREFS_CARD_COVERS("prefs_cardCovers"),
//    PREFS_BACKGROUND("prefs_background"),
//    PREFS_CARD_AGING("prefs_cardAging"),

//    //Actions
//    ACTIONS("actions"),
//    BOARD_STARS("boardStars"),
//    CARDS("cards"),
//    CARDS_PLUGIN_DATA("card_pluginData"),
//    CHECK_LISTS("checklists"),
//    CUSTOM_FIELDS("customFields"),
//    FIELDS("fields"),
//    LABELS("labels"),
//    LISTS("lists"),
//    MEMBERS("members"),
//    MEMBERSHIPS("memberships"),
//    MEMBERS_INVITED("membersInvited"),
//    MEMBERS_INVITED_FIELDS("membersInvited_fields"),
//    PLUGIN_DATA("pluginData"),
//    ORGANIZATION("organization"),
//    ORGANIZATION_PLUGIN_DATA("organization_pluginData"),
//    MY_PREFS("myPrefs"),
//    TAGS("tags");