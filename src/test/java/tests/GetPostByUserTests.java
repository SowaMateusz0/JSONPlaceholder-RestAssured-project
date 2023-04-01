package tests;

import BaseSuite.BaseClass;
import dataGenerator.UserPayloadGenerator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pojo.PostPOJO;
import rop.GetPostByUserROP;

public class GetPostByUserTests extends BaseClass {


    @Test
    public void getPostByUserId() {

        UserPayloadGenerator userPayloadGenerator = new UserPayloadGenerator();
        Integer userId = userPayloadGenerator.generateUserId();

        PostPOJO[] postPOJOS = new GetPostByUserROP().setUsername(userId).sendRequestPayload().assertRequestSuccess().getResponsePayload();

        for (PostPOJO post : postPOJOS) {
            Assertions.assertThat(post.getUserId()).isEqualTo(userId);
        }
    }

}
