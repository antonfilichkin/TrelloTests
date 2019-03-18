package API;

import enums.QueryParams;
import enums.ResourceTypes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static API.RequestSpecifications.requestConfiguration;
import static config.TestProperties.getProperty;
import static enums.QueryParams.*;

public class TrelloResource {
    private static final String BASE_URI = getProperty("path");

    private Map<String, String> params = new HashMap<>();

    public static class QueryBuilder {
        TrelloResource resource;

        private QueryBuilder(TrelloResource resource) {
            this.resource = resource;
        }

        public TrelloResource.QueryBuilder addParam(QueryParams param, String value) {
            this.resource.params.put(param.queryParam, value);
            return this;
        }

        public TrelloResource.QueryBuilder addParam(QueryParams param, Boolean value) {
            this.resource.params.put(param.queryParam, String.valueOf(value));
            return this;
        }

        public TrelloResource.QueryBuilder addParams(Map<String, String> params) {
            this.resource.params.putAll(params);
            return this;
        }

        public TrelloResource.QueryBuilder addAuthorization() {
            addParam(KEY, getProperty(KEY.queryParam));
            addParam(TOKEN, getProperty(TOKEN.queryParam));
            return this;
        }

        public Response createResource(ResourceTypes type, String name) {
            return RestAssured
                    .given(requestConfiguration())
                    .with()
                    .queryParam(NAME.queryParam, name)
                    .queryParams(this.resource.params)
                    .log().all()
                    .post(BASE_URI + type.path)
                    .prettyPeek();
        }

        public Response getResource(ResourceTypes type, String id) {
            return RestAssured
                    .given(requestConfiguration())
                    .with()
                    .queryParams(this.resource.params)
                    .log().all()
                    .get(BASE_URI + type.path + id)
                    .prettyPeek();
        }

        public Response updateResource(ResourceTypes type, String id) {
            return RestAssured
                    .given(requestConfiguration())
                    .with()
                    .queryParams(this.resource.params)
                    .log().all()
                    .put(BASE_URI + type.path + id)
                    .prettyPeek();
        }

        public Response deleteResource(ResourceTypes type, String id) {
            return RestAssured
                    .given(requestConfiguration())
                    .with()
                    .log().all()
                    .delete(BASE_URI + type.path + id)
                    .prettyPeek();
        }

        public Response getResourceUnauthorised(ResourceTypes type, String id) {
            return RestAssured
                    .with()
                    .queryParams(this.resource.params)
                    .log().all()
                    .get(BASE_URI + type.path + id)
                    .prettyPeek();
        }
    }

    public static TrelloResource.QueryBuilder with() {
        TrelloResource api = new TrelloResource();
        return new TrelloResource.QueryBuilder(api);
    }
}