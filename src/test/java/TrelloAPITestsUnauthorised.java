import API.TrelloResource;
import beans.member.Member;
import config.TestProperties;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static API.ResponseSpecifications.*;
import static defaultTestName.BoardData.TEST_BOARD_NAME;
import static enums.ResourceTypes.BOARD;
import static enums.ResourceTypes.MEMBER;
import static enums.Responses.INVALID_TOKEN;
import static enums.Responses.UNAUTHORIZED;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static utils.DeserializeResponse.deserializeResponse;

public class TrelloAPITestsUnauthorised extends TrelloAPITestsBase {
    @Test(description = "Test 6: Get with no authorisation data - returns status 401")
    public void getResourceUnauthorised() {
        TrelloResource
                .with()
                .getResourceUnauthorised(BOARD, boardId)
                .then()
                .assertThat()
                .specification(unauthorised())
                .assertThat()
                .body(is(UNAUTHORIZED.body));
    }

    @Test(description = "Test 7: Post with incorrect Token - returns status 401")
    public void postResourceWithIncorrectToken() {
        TrelloResource.with()
                .createResourceUnauthorised(BOARD, TEST_BOARD_NAME.text)
                .then()
                .specification(unauthorisedWrongToken())
                .assertThat()
                .body(is(INVALID_TOKEN.body));
    }

    @Test(description = "Test 8: Get Member data without authorization is possible")
    public void getMemberUnauthorised() {
        Response response;

        //GET created board
        response = TrelloResource.with()
                .getResourceUnauthorised(MEMBER, TestProperties.getProperty("memberId"));

        //Assert response status is OK
        response.then().specification(successResponse());

        //Deserialize response
        Member member = deserializeResponse(response, Member.class);

        //Assert number of boards available is null
        assertThat(member.getIdBoards(), hasSize(0));
    }
}
