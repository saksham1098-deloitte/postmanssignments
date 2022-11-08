import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class GetCall {
    static RequestSpecification CommonSpec(){
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri("https://jsonplaceholder.typicode.com");
        RequestSpecification requestSpec= builder.build();
        return requestSpec;
    }
    @Test
    public void GetRequest(){
        Response response=given().
                spec(CommonSpec()).queryParam("id",40)

                .when().get("/posts");
        response.getBody().prettyPrint();
        assertThat(response.statusCode(),equalTo(200));
        assertThat(response.contentType(),equalTo("application/json; charset=utf-8"));
    }
}
