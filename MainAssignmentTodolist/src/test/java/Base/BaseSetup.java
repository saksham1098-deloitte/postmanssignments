package Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import  static org.hamcrest.MatcherAssert.assertThat;

public class BaseSetup {
  public void verifyContentType(Response response)
  {
      assertThat(response.contentType(),containsString(String.valueOf(ContentType.HTML)));

  }
    public void verifyStatusCode(Response response)
    {
        assertThat(response.statusCode(),CoreMatchers.is(HttpStatus.SC_OK));

    }

}
