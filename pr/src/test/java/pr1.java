import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;

import static org.hamcrest.CoreMatchers.*;

public class pr1 {
    @Test
    public void get_test_call()
    {
        RequestSpecification requestSpecification = with().baseUri("https://regres.in.api");
        Response response = requestSpecification.get("/users");
        assertThat(response.statusCode(),equalTo(200));

    }
}
