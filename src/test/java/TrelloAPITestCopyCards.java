import API.TrelloResource;
import beans.card.Card;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static API.ResponseSpecifications.successResponse;
import static defaultTestData.BoardData.TEST_BOARD_NAME_COPY;
import static defaultTestData.CardData.TEST_CARD_DUE;
import static defaultTestData.CardData.TEST_CARD_NAME;
import static defaultTestData.ListData.TEST_LIST_COPY_NAME;
import static defaultTestData.ListData.TEST_LIST_NAME;
import static enums.Positions.BOTTOM;
import static enums.Positions.TOP;
import static enums.QueryParams.*;
import static enums.ResourceTypes.CARDS;
import static enums.ResourceTypes.LIST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.DeserializeResponse.cardsDeserializeResponseToList;
import static utils.DeserializeResponse.deserializeResponse;

public class TrelloAPITestCopyCards extends TrelloAPITestsBase {
    private String copyBoardName;
    private String copyBoardId;

    @BeforeMethod(description = "Create additional board for test")
    public void createAdditionalBord() {
        copyBoardName = TEST_BOARD_NAME_COPY.text + boardName;
        copyBoardId = createBoard(copyBoardName);
    }

    @AfterMethod(description = "Delete additional board created for test")
    public void deleteAdditionalBord() {
        deleteBoard(copyBoardId);
    }

    @Test(description = "Test 11: It is possible to copy lists with cards between boards. " +
            "Test 12: Cards not preserving status on copying")
    public void copyListWithCardsBetweenTwoBoards() {
        Response response;

        //Add list to first board
        response = TrelloResource.with()
                .addParam(ID_BOARD, boardId)
                .addParam(POS, BOTTOM.position)
                .createResource(LIST, TEST_LIST_NAME.text);

        //Assert response status is OK
        response.then().specification(successResponse());

        String listId = deserializeResponse(response, beans.list.List.class).getId();

        //Add cards with status Complete
        int cardsToAdd = 3;
        List<String> generatedCardNames = new ArrayList<>();
        for (int i = 0; i < cardsToAdd; i++) {
            String cardName = TEST_CARD_NAME.text + i;

            TrelloResource.with()
                    .addParam(ID_LIST, listId)
                    .addParam(DUE_COMPLETE, true)
                    .addParam(DUE, TEST_CARD_DUE.text)
                    .createResource(CARDS, cardName)
                    .then()
                    .specification(successResponse());

            //Save generated names for later assert
            generatedCardNames.add(cardName);
        }

        //Copy List
        response = TrelloResource.with()
                .addParam(ID_BOARD, copyBoardId)
                .addParam(ID_LIST_SOURCE, listId)
                .addParam(POS, TOP.position)
                .createResource(LIST, TEST_LIST_COPY_NAME.text);

        //Assert response status is OK
        response.then().specification(successResponse());

        String newListId = deserializeResponse(response, beans.list.List.class).getId();

        //Get cards from new board
        response = TrelloResource.with()
                .getNestedResources(LIST, newListId, CARDS);

        List<Card> cards = cardsDeserializeResponseToList(response);

        //Assert list and card are the same as expected
        assertThat(cards, hasSize(cardsToAdd));

        List<String> newListCards = new ArrayList<>();
        //Assert that copied list has correct data with card status not preserved
        for (Card card : cards) {
            assertThat(card.getDueComplete(), is(false));
            assertThat(card.getDue(), containsString(TEST_CARD_DUE.text));
            newListCards.add(card.getName());
        }

        // Assert cards has correct names
        assertThat(newListCards, containsInAnyOrder(generatedCardNames.toArray()));
    }
}