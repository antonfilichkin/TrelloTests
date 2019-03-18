package enums;

public enum FieldParams {
    CLOSED("closed"),
    DATE_LAST_ACTIVE("dateLastActivity"),
    DATE_LAST_VIEW("dateLastView"),
    DESC("desc"),
    DESC_DATA("descData"),
    ID_ORGANIZATIO("idOrganization"),
    INVITATIONS("invitations"),
    INVITED("invited"),
    LABEL_NAMES("labelNames"),
    MEMBERSHIPS("memberships"),
    NAME("name"),
    PINNED("pinned"),
    POWER_UPS("powerUps"),
    PREFS("prefs"),
    SHORT_LINK("shortLink"),
    SHORT_URL("shortUrl"),
    STARRED("starred"),
    SUBSCRIBED("subscribed"),
    URL("url");

    public String fieldParam;

    FieldParams(String param) {
        this.fieldParam = param;
    }
}
