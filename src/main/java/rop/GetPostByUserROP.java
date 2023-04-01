package rop;

import ConfigRequest.RequestConfiguration;
import org.apache.http.HttpStatus;
import pojo.PostPOJO;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;



public class GetPostByUserROP extends BaseRequestObjectPattern<GetPostByUserROP, PostPOJO[]>{

    private Integer userId;

    @Override
    protected Type responsePayload() {
        return PostPOJO[].class;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    public GetPostByUserROP sendRequestPayload() {
        response = given()
                .spec(RequestConfiguration.getConfigRequest())
                .queryParam("userId",userId)
                .when()
                .get("/posts");
        return this;
    }

    public GetPostByUserROP setUsername(Integer userId) {
        this.userId = userId;
        return this;
    }

}
