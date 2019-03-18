import API.TrelloResource;
import beans.board.Board;
import beans.member.Member;
import config.TestProperties;
import io.restassured.response.Response;
import org.testng.annotations.*;

import java.util.List;

import static API.ResponseSpecifications.successResponse;
import static enums.Backgrounds.GREEN;
import static enums.QueryParams.*;
import static enums.ResourceTypes.BOARD;
import static enums.ResourceTypes.MEMBER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.utils.deserializeResponse;

public class trelloAPITestsWithExistingBoards extends trelloAPITestsBase {
    @Test(description = "Check if it is possible to update board")
    public void updateBoardTest() {
        Response response;
        Board board;

        //GET board
        response = TrelloResource.with().getResource(BOARD, boardId);
        response.then().specification(successResponse());

        //Deserialize Response
        board = deserializeResponse(response, Board.class);

        //Assert board contains expected data
        assertThat(board.getName(), is(boardName));
        assertThat(board.getDesc(), is(description));
        assertThat(board.getPrefs().getBackground(), is(boardColor));

        //Change data used for creation
        String newDescription = description + description;
        String newBoardColor = GREEN.color;
        String newBoardName = boardName + boardName;

        //Update existing board
        response = TrelloResource.with()
                .addParam(DESC, newDescription)
                .addParam(PREFS_BACKGROUND_U, newBoardColor)
                .addParam(NAME, newBoardName)
                .updateResource(BOARD, boardId);

        //Assert response status is OK
        response.then().specification(successResponse());

        //GET updated board
        response = TrelloResource.with().getResource(BOARD, boardId);
        response.then().specification(successResponse());

        //Deserialize Response
        board = deserializeResponse(response, Board.class);

        //Assert updated board contains expected data
        assertThat(board.getName(), is(newBoardName));
        assertThat(board.getDesc(), is(newDescription));
        assertThat(board.getPrefs().getBackground(), is(newBoardColor));
    }

    @Test(description = "Check if it is possible to reopen closed board")
    public void reopenClosedBoardTest() {
        Response response;

        // Close new board
        TrelloResource.with()
                .addParam(CLOSED, true)
                .updateResource(BOARD, boardId)
                .then().specification(successResponse());

        //Get list of member boards
        response = TrelloResource.with()
                .getResource(MEMBER, TestProperties.getProperty("memberId"));

        //Assert response status is OK
        response.then().specification(successResponse());

        //Get list of memeber boards
        List<String> boardsIds = deserializeResponse(response, Member.class).getIdBoards();

        //Assert list contains boardId
        assertThat(boardsIds, hasItem(boardId));

        //Get board
        response = TrelloResource.with().getResource(BOARD, boardId);

        //Assert response status is OK
        response.then().specification(successResponse());

        //Assert board is is closed
        assertThat(deserializeResponse(response, Board.class).getClosed(), is(true));

        //Reopen closed board
        response = TrelloResource.with()
                .addParam(CLOSED, false)
                .updateResource(BOARD, boardId);

        //Assert response status is OK
        response.then().specification(successResponse());

        //GET updated board
        response = TrelloResource.with().getResource(BOARD, boardId);
        response.then().specification(successResponse());

        //Assert board is not closed
        assertThat(deserializeResponse(response, Board.class).getClosed(), is(false));
    }
}