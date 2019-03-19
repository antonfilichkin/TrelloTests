package defaultTestName;

public enum CardData {
    TEST_CARD_NAME("Test card "),
    TEST_CARD_DESCRIPTION("Test Card Description "),
    TEST_CARD_DUE("2019-12-31");

    public final String text;

    CardData(String data) {
        this.text = data;
    }
}
