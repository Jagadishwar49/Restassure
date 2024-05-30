package JUnit;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

//api testing we use "https://www.zippopotam.us/"

public class FirstTest {

    @Test // if we don't mention @test then we don't have run button, or it will not execute  method when we execute class
    //<Access modifier> <returnType> methodName(arg1,arg2...){}
    // Junit Doesn't require access So we can ignore (It does not allow to add access modifier to mention)
    void firstMethod() {
        System.out.println("FirstTest method executed");
        /*
        REST Assured provides support for all known HTTP methods. In the example in the previous chapter, we saw a HTTP GET, but REST Assured just as easily supports POST, PUT, PATCH, DELETE, and all other existing HTTP methods.
         REST Assured also supports the Gherkin syntax — the Given/ When/Then. Now, you either love or you hate the syntax. REST Assured doesn't force you to use it. It just gives you the option to do so.
         */
        //------------------------------------------------------------------------------------------------------------------//
        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().all().
                assertThat().body("places[0].'place name'", equalTo("Beverly Hills"));
        //------------------------------------------------------------------------------------------------------------------//
        // ❤️‍🔥 to check status code
        given().
                when().get("http://zippopotam.us/us/90210").
                then().
                assertThat().statusCode(200);
        //------------------------------------------------------------------------------------------------------------------//
    }

    @Test
    void secondMethod(){
        /*
        Checking the Response Content Type
        to check what type of data API will return EX; JSON and XML depending on data typ e we perform validation.
         */
        given().
                when().get("https://us-central1-testautomationu-9e0b6.cloudfunctions.net/app/learningPaths").then().log().body().assertThat().body("learningPathId[1]", equalTo("learningPathCodeless"));;
        // ❤️‍🔥 to check status Content Type
        given().
                when().get("https://us-central1-testautomationu-9e0b6.cloudfunctions.net/app/learningPaths").then().assertThat().contentType(ContentType.JSON);
        //------------------------------------------------------------------------------------------------------------------//
    }
    //----------------------------------------------------------------------------------------------------------------------//
    /*
    👺1] log().body() --> print body response of api
    👺2] log().all() --> print all values response , response type , header , status ect
     */
    //----------------------------------------------------------------------------------------------------------------------//

    @Test
    void thirdMethod(){
        // ❤️‍🔥 to check  hasItem method
        given().
        when().get("https://us-central1-testautomationu-9e0b6.cloudfunctions.net/app/learningPaths").then().assertThat().body("[0].path",hasItem("course31"));
    }

    @Test
    void forthMethod(){
        // ❤️‍🔥 to check  hasSize method
        given().
                when().get("https://us-central1-testautomationu-9e0b6.cloudfunctions.net/app/learningPaths").then().assertThat().body("[0].path",hasSize(7));
    }
}
