package Testing;
import Base.BaseSetup;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Tasktest  extends BaseSetup {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;



    @BeforeClass
    public void setup()
    {
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api-nodejs-todolist.herokuapp.com");
        requestSpecification= RestAssured.with().spec(requestSpecBuilder.build());
        ResponseSpecBuilder specBuilder=new ResponseSpecBuilder().expectContentType(ContentType.JSON);
        responseSpecification=specBuilder.build();
    }


    @Test
     public void taskValidation () throws IOException {
        String excelFile="C:\\Users\\saksshukla\\IdeaProjects\\postmanssignments\\MainAssignmentTodolist\\src\\test\\java\\Testing\\TaskData.xlsx";
        FileInputStream fis=new FileInputStream(excelFile);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet=wb.getSheetAt(0);
        XSSFRow row=null;
        XSSFCell cell=null;
        String desc=null;

for(int task=1;task<=20;task++) {
    String addTask = "readingbooks" + task;
    String jsondata = "{\n" + "   \"discription\" : \"s\" \n" + "}";
    Response response = given().auth().basic("shreyshukla6@gmail.com", "9452145301").baseUri("https://api-nodejs-todolist.herokuapp.com").body(jsondata).when().post("/task");
    verifyTaskStatusCode(response);
    verifyTaskContentType(response);
}
for(int task=1;task<=20;task++)
{
    String validatetask ="readingbooks" +task;
    String jsondata = "{\n" + "   \"discription\" : \"s\" \n" + "}";
    Response response =given().baseUri("https://api-nodejs-todolist.herokuapp.com").body(jsondata).when().get("/task");
    verifyTaskStatusCode(response);
    verifyTaskContentType(response);

}
    }
    @Test
    public void verifyGetUserByPagination()
    {


    }
}
