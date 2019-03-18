package API;

import io.restassured.response.Response;

import static enums.ResourceTypes.BOARD;

public class Boards extends TrelloResource {
    public static Response createNewBoard(String name) {
        return API.Boards.with().createResource(BOARD, name);
    }

    public static Response getBoard(String name) {
        return API.Boards.with().getResource(BOARD, name);
    }
}
