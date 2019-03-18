package enums.defaultTestData;

public enum Board {
    TEST_BOARD_NAME("Test board "),
    TEST_BOARD_DESCRIPTION("Test Description "),
    TEST_BOARD_ORGANIZATION("Test Organisation"),
    TEST_BOARD_NAME_COPY("Copy of ");

    public final String text;

    Board(String data) {
        this.text = data;
    }
}
