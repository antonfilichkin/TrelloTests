package utils;

import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.List;

public class utils {
    public static <B> List<B> deserializeResponseToList(Response response, Class<List<B>> beanClass) {
        return new Gson().fromJson(response.asString().trim(), beanClass);
    }

    public static <B> B deserializeResponse(Response response, Class<B> beanClass) {
        return new Gson().fromJson(response.asString().trim(), beanClass);
    }
}
