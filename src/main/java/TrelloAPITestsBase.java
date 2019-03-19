import beans.board.Board;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static API.ResponseSpecifications.successResponse;
import static defaultTestName.BoardData.TEST_BOARD_DESCRIPTION;
import static defaultTestName.BoardData.TEST_BOARD_NAME;
import static enums.Backgrounds.ORANGE;
import static enums.QueryParams.DESC;
import static enums.QueryParams.PREFS_BACKGROUND;
import static enums.ResourceTypes.BOARD;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static utils.DeserializeResponse.deserializeResponse;

public class TrelloAPITestsBase {
    String description;
    String boardColor;
    String boardName;
    String boardId;

    @BeforeMethod(description = "Create new board for test")
    public void createBoardForTest() {
        // Generating board Name and description
        int randomNumber = Integer.parseInt(random(5, false, true));
        description = TEST_BOARD_DESCRIPTION.text + randomNumber;
        boardColor = ORANGE.color;
        boardName = TEST_BOARD_NAME.text + randomNumber;

        Response response;
        // Create new board
        response = API.TrelloResource
                .with()
                .addParam(DESC, description)
                .addParam(PREFS_BACKGROUND, boardColor)
                .createResource(BOARD, boardName);

        response.then().specification(successResponse());

        // Get created boardID to test
        boardId = deserializeResponse(response, Board.class).getId();
    }

    @AfterMethod(description = "Delete created board for test")
    public void deleteBoardAfterTest() {
        // Delete new board
        API.TrelloResource.with()
                .deleteResource(BOARD, boardId)
                .then().specification(successResponse());
    }

    // Create simple board
    static String createBoard(String name) {
        Response response = API.TrelloResource.with().createResource(BOARD, name);

        // Check board is created
        response.then().specification(successResponse());

        // Return created boardID
        return deserializeResponse(response, Board.class).getId();
    }

    // Delete board
    static void deleteBoard(String id) {
        API.TrelloResource.with()
                .deleteResource(BOARD, id)
                .then().specification(successResponse());
    }
}