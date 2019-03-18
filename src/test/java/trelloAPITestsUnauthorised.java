import API.TrelloResource;
import beans.member.Member;
import config.TestProperties;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static API.ResponseSpecifications.*;
import static enums.ResourceTypes.BOARD;
import static enums.ResourceTypes.MEMBER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static utils.utils.*;

public class trelloAPITestsUnauthorised extends trelloAPITestsBase {
    @Test
    public void getResourceUnauthorised() {
        Response response;
        //GET created board
        response = TrelloResource.with().getResourceUnauthorised(BOARD, boardId);

        //Assert response status is 401
        response.then().specification(unauthorised());
    }

    @Test
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
        assertThat(member.getIdBoards(),hasSize(0));
    }
}
