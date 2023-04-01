package rop;

import ConfigRequest.RequestConfiguration;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import pojo.PostPOJO;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.*;

public class GetPostROP extends BaseRequestObjectPattern<GetPostROP, PostPOJO[]>{

    @Override
    protected Type responsePayload() {
        return PostPOJO[].class;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    public GetPostROP sendRequestPayload() {
        response = given()
                .spec(RequestConfiguration.getConfigRequest())
                .when()
                .get("/posts");
        return this;
    }
}
