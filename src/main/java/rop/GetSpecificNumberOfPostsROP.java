package rop;

import ConfigRequest.RequestConfiguration;
import org.apache.http.HttpStatus;
import pojo.PostPOJO;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class GetSpecificNumberOfPostsROP extends BaseRequestObjectPattern<GetSpecificNumberOfPostsROP, PostPOJO[]>{

    private Integer postLimit;

    @Override
    protected Type responsePayload() {
        return PostPOJO[].class;
    }

    @Override
    protected int getSuccessStatusCode() {
        return HttpStatus.SC_OK;
    }

    @Override
    public GetSpecificNumberOfPostsROP sendRequestPayload() {
        response = given()
                .spec(RequestConfiguration.getConfigRequest())
                .queryParam("_limit",postLimit)
                .when()
                .get("posts");
        return this;
    }

    public GetSpecificNumberOfPostsROP setPostLimit(Integer postLimit){
        this.postLimit = postLimit;
        return this;
    }
}
