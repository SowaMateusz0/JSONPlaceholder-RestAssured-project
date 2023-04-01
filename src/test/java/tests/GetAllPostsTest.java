package tests;

import BaseSuite.BaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pojo.PostPOJO;
import rop.GetAllPostsROP;

public class GetAllPostsTest extends BaseClass {

    @Test
    public void getAllPost() {

        PostPOJO[] postPOJOS = new GetAllPostsROP().sendRequestPayload().assertRequestSuccess().getResponsePayload();
        Assertions.assertThat(postPOJOS.length).isEqualTo(100);
    }
}
