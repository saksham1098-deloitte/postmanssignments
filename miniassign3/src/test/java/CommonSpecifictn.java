import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
public class CommonSpecifictn {
    static ResponseSpecification commonSpec(){
        ResponseSpecBuilder builder=new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType("application/json; charset=utf-8");
        ResponseSpecification responseSpecation=builder.build();
        return responseSpecation;
    }
}
