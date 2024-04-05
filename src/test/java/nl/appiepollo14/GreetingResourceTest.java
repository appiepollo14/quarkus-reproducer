package nl.appiepollo14;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@QuarkusTestResource(ClientMock.class)
class GreetingResourceTest {

    @Inject
    GreetingResource sut;

    @Test
    public void testProcessing() {
        when().get("/hello").then().body(is(
                "Hello from Quarkus REST"));
    }

}