package Testing;

import Base.BaseSetup;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTest extends BaseSetup {
    public String token;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api-nodejs-todolist.herokuapp.com");
        requestSpecification = RestAssured.with().spec(requestSpecBuilder.build());
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON);
        responseSpecification = specBuilder.build();
    }

    @Test
    public void register() {
        File jsonData = new File("C:\\Users\\saksshukla\\IdeaProjects\\postmanssignments\\MainAssignmentTodolist\\src\\test\\java\\Testing\\registerdata.json");
        given().
                spec(requestSpecification).
                header("Content-Type", "application/json").
                body(jsonData).
                when().
                post("/user/register").
                then().
                statusCode(201);

    }

    @Test
    public void login() {
        RestAssured.baseURI = "https://api-nodejs-todolist.herokuapp.com";
        RequestSpecification request = RestAssured.given();
        String payload = "{\n" +
                "\t\"email\":\"shreyshukla6@gmail.com\",\n" +
                "\"password\": \"9452145301\"\n" +
                " \n" +
                "}";
        request.header("Content-Type", "application/json");
        Response response = request.body(payload).post("/user/login");
        response.prettyPrint();
        String jsonString = response.getBody().asString();
        token = JsonPath.from(jsonString).get("token");
        System.out.println(token);
    }

    @Test
    public void validateUserByTokens() {
        given().spec(requestSpecification).auth().oauth2(tokenn).get("/user/me").then().statusCode(200);
    }


}