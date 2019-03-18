package API;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static config.TestProperties.getProperty;
import static enums.QueryParams.KEY;
import static enums.QueryParams.TOKEN;
import static io.restassured.http.ContentType.JSON;

class RequestSpecifications {
    static RequestSpecification requestConfiguration() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setAccept(JSON)
                .addQueryParam(KEY.queryParam, getProperty(KEY.queryParam))
                .addQueryParam(TOKEN.queryParam, getProperty(TOKEN.queryParam))
                .build();
    }
}