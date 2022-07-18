import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestHelper {
    ConfigReader configReader = new ConfigReader();
    public RequestSpecification requestSpecification;
    public ResponseSpecification responseSpecification;

    public RequestHelper() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri(configReader.getConfigProperty("base_url"))
                .setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.BODY);
        responseSpecification = responseSpecBuilder.build();
    }
}
