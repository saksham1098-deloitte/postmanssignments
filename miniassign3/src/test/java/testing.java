import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;

import static org.hamcrest.CoreMatchers.*;

public class testing{

  RequestSpecification reqspec;
  ResponseSpecification resspec;
 @BeforeClass
  public void setup()
  {
    RequestSpecBuilder builder =new RequestSpecBuilder();
    builder.setBaseUri("https://jsonplaceholder.typicode.com");
    builder.setAccept("application/json");
    builder.setContentType("application/json");
    reqspec =  RestAssured.with().spec(builder.build());
    ResponseSpecBuilder responseSpecBuilder =new ResponseSpecBuilder().expectContentType(ContentType.JSON);
    resspec =responseSpecBuilder.build();


  }
  @Test
    public void getCall()
  {
      given().log().all().spec(reqspec).
              when().
              get("/posts?id=40&userId=4").
              then().spec(resspec).assertThat().statusCode(200);

  }
  @Test
    public void putcall()
  {
      given().log().all().spec(reqspec).
              when().
              get("/posts?id=40&userId=4").
              then().spec(resspec).assertThat().statusCode(200);
  }


}



