package enums;

public enum Responses {
    INVALID_ID("invalid id"),
    INVALID_TOKEN("invalid token"),
    UNAUTHORIZED("unauthorized permission requested");

    public final String body;

    Responses(String body) {
        this.body = body;
    }
}
