package Testing;

import Base.BaseSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;

public class UserTest extends BaseSetup {
@Test (priority = 1)
    public void RegisterUserTest()
{
   Response response= given().

            baseUri("https://api-nodejs-todolist.herokuapp.com").
            when().
            get("/user/register").
            then().log().all().
            extract().response();
   verifyContentType(response);
}
@Test (priority = 2)
    public void LoginUserTest()
{

}
@Test (priority = 3)
    public void LogoutUserTest()
{

}
@Test (priority = 4)
    public void UpdateProfileTest()
{

}
@Test (priority = 5)
    public void UploadImageTest()
{

}
@Test (priority = 6)
    public void GetUserImageTest()
    {

    }

    @Test (priority = 7)
    public void DeleteImageTest()
    {

    }
    @Test (priority = 8)
    public void DeleteUserTest()
    {

    }
}
