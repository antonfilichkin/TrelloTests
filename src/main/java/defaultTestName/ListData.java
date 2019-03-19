package defaultTestName;

public enum ListData {
    TEST_LIST_NAME("Test list"),
    TEST_LIST_COPY_NAME("Copy of Test list"),
    TEST_LIST_DESCRIPTION("Test List Description ");

    public final String text;

    ListData(String data) {
        this.text = data;
    }
}
