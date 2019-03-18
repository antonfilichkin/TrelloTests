package enums;

public enum ResourceTypes {
    BOARD("boards/"),
    CARDS("cards/"),
    CHECKLISTS("checklists/"),
    CUSTOM_FIELDS("customfields/"),
    MEMBER("members/");

    public final String path;

    ResourceTypes(String path) {
        this.path = path;
    }
}
