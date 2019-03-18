import API.TrelloResource;
import beans.board.Board;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static API.ResponseSpecifications.successResponse;
import static enums.Backgrounds.ORANGE;
import static enums.QueryParams.DESC;
import static enums.QueryParams.PREFS_BACKGROUND;
import static enums.ResourceTypes.BOARD;
import static enums.defaultTestData.Board.TEST_BOARD_DESCRIPTION;
import static enums.defaultTestData.Board.TEST_BOARD_NAME;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static utils.utils.deserializeResponse;

public class trelloAPITestsBase {
    String description;
    String boardColor;
    String boardName;
    String boardId;

    @BeforeMethod(description = "Creation of new board")
    public void createBoardForTest() {
        // Generating board Name and description
        int randomNumber = Integer.parseInt(random(5, false, true));
        description = TEST_BOARD_DESCRIPTION.text + randomNumber;
        boardColor = ORANGE.color;
        boardName = TEST_BOARD_NAME.text + randomNumber;

        Response response;
        // Create new board
        response = TrelloResource.with()
                .addParam(DESC, description)
                .addParam(PREFS_BACKGROUND, boardColor)
                .createResource(BOARD, boardName);

        response.then().specification(successResponse());

        // Get created boardID to test
        boardId = deserializeResponse(response, Board.class).getId();
    }

    @AfterMethod(description = "Deletion of created board")
    public void deleteBoardAfterTest() {
        // Delete new board
        TrelloResource.with()
                .deleteResource(BOARD, boardId)
                .then().specification(successResponse());
    }

    static String createBoard(String name) {
        Response response;
        // Create new board
        response = TrelloResource.with()
                .createResource(BOARD, name);

        response.then().specification(successResponse());

        // return created boardID
        return deserializeResponse(response, Board.class).getId();
    }

    static void deleteBoard(String id) {
        // Delete new board
        TrelloResource.with()
                .deleteResource(BOARD, id)
                .then().specification(successResponse());
    }
}