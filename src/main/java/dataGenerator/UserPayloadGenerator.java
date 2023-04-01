package dataGenerator;

import com.github.javafaker.Faker;
import pojo.PostPOJO;


public class UserPayloadGenerator {

    public Faker faker() {
        return Faker.instance();
    }

    public Integer generateUserId(){
        return faker().number().numberBetween(1,10);
    }

}
