package JUnit;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class optimizingApiRequest {

    private static RequestSpecification request;
    private static ResponseSpecification check;
    //reusing url
    @BeforeClass
    public static void useDefaultUrl(){
        request = new RequestSpecBuilder().setBaseUri("http://api.zippopotam.us").build();
    }
    @BeforeClass
    public static void useDefaultCheck(){
        check = new ResponseSpecBuilder().expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }
    @Test
    public void thirdMethod(){
        // storing value in string
        String value =
        given().
                spec(request). // adding default url
                when().get("us/90210").
                then().log().body().spec(check).extract().path("places[0].'place name'"); //adding check for reusable status

        Assert.assertEquals(value,"Beverly Hills");
    }
}
