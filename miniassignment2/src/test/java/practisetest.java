import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class practisetest {
    @Test (priority = 1)
    public void test_get_call()
    {
       given().
               baseUri("https://jsonplaceholder.typicode.com").

               when().
                get("/posts?id=40&userId=4").
               then().

               statusCode(200).header("Content-Type" , "application/json; charset=utf-8").
               body("userId", hasItems(4),"[0].id",is(equalTo(40)));



//https://reqres.in/api/users/
    }
    @Test (priority  =2)
    public void test_put_call()
    {
        File jsonData= new File("C:\\Users\\saksshukla\\miniassignment2\\src\\test\\sources\\putdata.json");

        given().baseUri("https://reqres.in").
                body(jsonData).
                when().
                put("/api/users/").
                then().statusCode(200).header("Content-Type","application/json; charset=utf-8");


    }


}
