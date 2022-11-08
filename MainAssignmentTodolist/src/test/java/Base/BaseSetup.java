package Base;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeTest;
import static org.hamcrest.CoreMatchers.containsString;
import  static org.hamcrest.MatcherAssert.assertThat;

public class BaseSetup {
    @BeforeTest
    public void verifycontentType()
    {
        //assertThat(response.conteType(),containsString(String.valueOf(ContentType.JSON)));
    }
}
