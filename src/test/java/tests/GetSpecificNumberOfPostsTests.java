package tests;

import BaseSuite.BaseClass;
import dataGenerator.UserPayloadGenerator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pojo.PostPOJO;
import rop.GetSpecificNumberOfPostsROP;

public class GetSpecificNumberOfPostsTests extends BaseClass {

    @Test
    public void GetSpecificNumberOfPostsTest() {

        UserPayloadGenerator userPayloadGenerator = new UserPayloadGenerator();
        Integer postLimiter = userPayloadGenerator.generatePostLimiter();

        PostPOJO[] postPOJOS = new GetSpecificNumberOfPostsROP().setPostLimit(postLimiter).sendRequestPayload().assertRequestSuccess().getResponsePayload();

        Assertions.assertThat(postPOJOS.length).isEqualTo(postLimiter);
    }

}
