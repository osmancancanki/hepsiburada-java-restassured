import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestRequest {
    RequestHelper requestHelper = new RequestHelper();

    public void getAllProducts() {
        RestAssured.given().spec(requestHelper.requestSpecification)
                .when().get("/allGrocery")
                .then().spec(requestHelper.responseSpecification).log().all();
    }

    public void getProductByName(String name) {
        RestAssured.given().spec(requestHelper.requestSpecification)
                .when().get("/allGrocery/"+name)
                .then().spec(requestHelper.responseSpecification).log().all();
    }

    public void postProduct() {
        RestAssured.given().spec(requestHelper.requestSpecification)
                .body("{\n" +
                        "    \"id\": 4,\n" +
                        "    \"name\": \"string\",\n" +
                        "    \"price\": 12.3,\n" +
                        "    \"stock\": 3\n" +
                        "}")
                .when().post("/add")
                .then().spec(requestHelper.responseSpecification).log().all();
    }

    public void getProductByWrongName(String name) {
        Response response = RestAssured.given().spec(requestHelper.requestSpecification)
                .when().get("/allGrocery/"+name)
                .then().statusCode(404).extract().response();
    }

    public void postProductWithWrongInfo() {
        Response response = RestAssured.given().spec(requestHelper.requestSpecification)
                .body("{\n" +
                        "    \"id\": 4,\n" +
                        "    \"price\": 12.3,\n" +
                        "    \"stock\": 3\n" +
                        "}")
                .when().post("/add")
                .then().statusCode(400).extract().response();
    }
}
