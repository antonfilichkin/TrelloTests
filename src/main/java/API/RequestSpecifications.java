package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static config.TestProperties.getProperty;
import static enums.QueryParams.KEY;
import static enums.QueryParams.TOKEN;
import static io.restassured.http.ContentType.JSON;

class RequestSpecifications {
    static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .addQueryParam(KEY.queryParam, getProperty(KEY.queryParam))
                .addQueryParam(TOKEN.queryParam, getProperty(TOKEN.queryParam))
                .build();
    }

    static RequestSpecification requestSpecificationNoAuthentication() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .build();
    }

    static RequestSpecification requestSpecificationInvalidToken() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .addQueryParam(KEY.queryParam, getProperty(KEY.queryParam))
                .addQueryParam(TOKEN.queryParam, getProperty("invalid_token"))
                .build();
    }
}