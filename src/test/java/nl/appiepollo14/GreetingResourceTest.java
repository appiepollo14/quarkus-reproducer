package nl.appiepollo14;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    public void testProcessing() {
        when().get("/hello").then().body(is(
                "23F218$$12%%3##HJ"));
    }

}