import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PutCall {
    @Test
    public void PutRequest(){
        baseURI = "https://reqres.in";
        File jsonData = new File("C:\\Users\\saksshukla\\IdeaProjects\\postmanssignments\\miniassign3\\src\\test\\java\\putdata.json");
        given()
                .body(jsonData)
                .header("Content-Type","application/json")
                .when()
                .put("/api/user/2")
                .then()
                .spec(CommonSpecifictn.commonSpec())
                .assertThat().body("name",equalTo("Arun"),"job",equalTo("Manager"));
    }
}
