package defaultTestName;

public enum BoardData {
    TEST_BOARD_NAME("Test board "),
    TEST_BOARD_DESCRIPTION("Test Description "),
    TEST_BOARD_COMPLETE_TRUE("True"),
    TEST_BOARD_NAME_COPY("Copy of "),
    TEST_BOARD_WRONG_ID("wrong_board_id");

    public final String text;

    BoardData(String data) {
        this.text = data;
    }
}
