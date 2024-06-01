package JUnit;

import com.tngtech.java.junit.dataprovider.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class parameterizedapitesting {
    @DataProvider
    public  static Object[][] zipcodeAndPlaces(){
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"}
        };
    }

    @Test
    @UseDataProvider("zipcodeAndPlaces")
    public void firstTest(String country,String zipcode,String place){
        given().
                pathParam("countryCode", country).pathParam("zipCode", zipcode).
                when().get("http://zippopotam.us/{countryCode}/{zipCode}").
                then().log().body().assertThat().body("places[0].'place name'", equalTo(place));
    }
}
