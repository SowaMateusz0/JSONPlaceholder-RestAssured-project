package rop;

import ConfigRequest.RequestConfiguration;
import org.apache.http.HttpStatus;
import pojo.PostPOJO;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.*;

public class GetAllPostsROP extends BaseRequestObjectPattern<GetAllPostsROP, PostPOJO[]>{

    @Override
    protected Type responsePayload() {
        return PostPOJO[].class;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    public GetAllPostsROP sendRequestPayload() {
        response = given()
                .spec(RequestConfiguration.getConfigRequest())
                .when()
                .get("/posts");
        return this;
    }
}
