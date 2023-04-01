package tests;

import BaseSuite.BaseClass;
import org.testng.annotations.Test;
import pojo.PostPOJO;
import rop.GetPostROP;

public class GetPostsTest extends BaseClass {

    @Test
    public void getAllPost() {

        PostPOJO[] postPOJOS = new GetPostROP().sendRequestPayload().assertRequestSuccess().getResponsePayload();

    }
}
