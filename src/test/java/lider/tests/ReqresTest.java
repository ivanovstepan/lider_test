package lider.tests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import models.ResponseSingleUser;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ENV;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class ReqresTest {

    String path = "/api/users/2";
    Response response;

    @BeforeClass
    public void execureRequest() {
        response =
                given()
                        .baseUri(ENV.reqresUrl)
                        .basePath(path)
                        .contentType(ContentType.JSON)
                        .log()
                        .all()
                        .request(Method.GET);
    }

    @Test
    public void statusCodeTest() {
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Response status is not 200");
    }

    @Test
    public void firstNameTest() {
        ResponseSingleUser model = new Gson().fromJson(response.asString(), ResponseSingleUser.class);
        assertEquals(model.getData().getFirstName(), "Janet", "first name field is incorrect");
    }

}
