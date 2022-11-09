package Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.mozilla.javascript.tools.shell.Global;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseSetup {

// to verify the content type of request
    public void verifyUserContentType(Response response) {
        assertThat(response.contentType(), containsString(String.valueOf(ContentType.HTML)));

    }
    // to verify the statuscode of request
    public void verifyUserStatusCode(Response response) {
        assertThat(response.statusCode(), CoreMatchers.is(HttpStatus.SC_CREATED));

    }
    // to verify the content type of request
    public void verifyTaskContentType(Response response) {
        assertThat(response.contentType(), containsString(String.valueOf(ContentType.JSON)));

    }
    // to verify the statuscode of request
    public void verifyTaskStatusCode(Response response) {
        assertThat(response.statusCode(), CoreMatchers.is(HttpStatus.SC_UNAUTHORIZED));

    }

    public String tokenn = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzZhN2Y2NDAwOGY2ZjAwMTdjMzk4NWIiLCJpYXQiOjE2Njc5NjEyNTZ9.OK7ZqyNDNgbpB4dY7KOZz2mPb413yjOXiyexEaWzD5s";
}
