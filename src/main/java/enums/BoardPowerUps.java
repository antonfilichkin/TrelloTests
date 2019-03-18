package enums;

public enum BoardPowerUps {
    ALL("all"),
    CALENDAR("calendar"),
    CARD_AGING("cardAging"),
    RECAP("recap"),
    VOTING("voting");

    public final String powerUp;

    BoardPowerUps(String powerUps) {
        this.powerUp = powerUps;
    }
}
