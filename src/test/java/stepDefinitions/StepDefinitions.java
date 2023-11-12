package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojo.AddPlaceResponse;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

public class StepDefinitions extends Utils {
    private Response response;
    private TestDataBuild testDataBuild = new TestDataBuild();
    private RequestSpecification requestSpecification;


    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        requestSpecification = getRequestSpecification(testDataBuild.getAddPlacePayload(name, language, address));
    }

    @When("user calls {string} using {string} https request")
    public void user_calls_using_https_request(String resource, String httpsMethod) {

        ApiResources apiResources = ApiResources.valueOf(resource);

        if(httpsMethod.equalsIgnoreCase("POST")) {
            response = RestAssured.given().log().all().spec(requestSpecification)
                    .when().post(apiResources.getApiResource())
                    .then().log().all().extract().response();
        } else if(httpsMethod.equalsIgnoreCase("GET")) {
            response = RestAssured.given().log().all().spec(requestSpecification)
                    .when().get(apiResources.getApiResource())
                    .then().log().all().extract().response();
        } else if(httpsMethod.equalsIgnoreCase("DELETE")) {
            response = RestAssured.given().log().all().spec(requestSpecification)
                    .when().delete(apiResources.getApiResource())
                    .then().log().all().extract().response();
        }

    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int statusCode) {

        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String responseParameter, String value) {

        AddPlaceResponse addPlaceResponse;
        addPlaceResponse = response.as(AddPlaceResponse.class);

        if(responseParameter.equals("status")) {
            Assert.assertEquals(value, addPlaceResponse.getStatus());
        } else if (responseParameter.equals("scope")) {
            Assert.assertEquals(value, addPlaceResponse.getScope());
        }
    }
}
