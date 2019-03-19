import API.TrelloResource;
import beans.board.Board;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static API.ResponseSpecifications.*;
import static defaultTestName.BoardData.TEST_BOARD_NAME;
import static defaultTestName.BoardData.TEST_BOARD_WRONG_ID;
import static enums.Backgrounds.ORANGE;
import static enums.QueryParams.DESC;
import static enums.QueryParams.PREFS_BACKGROUND;
import static enums.ResourceTypes.BOARD;
import static enums.Responses.INVALID_ID;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static utils.DeserializeResponse.deserializeResponse;

public class TrelloAPITestsBasic {
    @Test(description = "Test: 1-3. Create, Get, Delete for board. Test 4: Get for deleted board")
    public void createGetDeleteGetDeletedBoardTest() {
        int randomNumber = Integer.parseInt(random(5, false, true));
        String description = defaultTestName.BoardData.TEST_BOARD_DESCRIPTION.text + randomNumber;
        String boardColor = ORANGE.color;
        String boardName = TEST_BOARD_NAME.text + randomNumber;

        Response response;

        //Create new board
        response = TrelloResource.with()
                .addParam(DESC, description)
                .addParam(PREFS_BACKGROUND, boardColor)
                .createResource(BOARD, boardName);

        //Assert response status is OK
        response.then().specification(successResponse());

        //Created board ID
        String boardId = deserializeResponse(response, Board.class).getId();

        //GET created board
        response = TrelloResource.with().getResource(BOARD, boardId);

        //Assert response status is OK
        response.then().specification(successResponse());

        //Deserialize Response
        Board board = deserializeResponse(response, Board.class);

        //Assert created board contains expected data
        assertThat(board.getName(), is(boardName));
        assertThat(board.getDesc(), is(description));
        assertThat(board.getPrefs().getBackground(), is(boardColor));

        //Delete created board
        API.TrelloResource.with()
                .deleteResource(BOARD, boardId)
                .then()
                .specification(successResponse());

        //Assert GET with deleted board returns 404
        TrelloResource.with()
                .getResource(BOARD, boardId)
                .then()
                .specification(resourceNotFound());
    }

    @Test(description = "Test 5: Get for board with wrong id - returns status 400")
    public void modifyBoardThatNotExists() {
        TrelloResource.with()
                .getResource(BOARD, TEST_BOARD_WRONG_ID.text)
                .then()
                .specification(badRequest())
                .assertThat()
                .body(is(INVALID_ID.body));
    }
}