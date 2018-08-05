package skeleton;

import org.skyscreamer.jsonassert.JSONAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class Stepdefs {
	Response response;

	@Given("^Rest service is deployed on \"([^\"]*)\"$")
	public void rest_service_is_deployed_on(String arg1) throws Throwable {
		RestAssured.baseURI = arg1;
	};


	@When("^I created post on \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_created_post_on_with(String arg1, String arg2)
			throws Throwable {
		Object a = JSONReader.readJSON(arg2, "SendData.json");
		response = given().contentType("application/json").body(a).when()
				.post(arg1);

	}
	
	@When("^I requested card details with \"([^\"]*)\"$")
	public void i_requested_card_details_on_with(String arg1)
			throws Throwable {
		Object a = JSONReader.readJSON(arg1, "SendData.json");
		String loginname = JSONReader.gettingValueFromJSONObject(a,"Login-name");
        String pan = JSONReader.gettingValueFromJSONObject(a,"Pan");
        String password = JSONReader.gettingValueFromJSONObject(a,"Password");
        String finalurl ="/user/"+loginname+"/card/"+pan;
        response = given().contentType("application/json").auth().preemptive().basic(loginname, password).when().get(finalurl);
        System.out.println(response.getBody().asString());
	}

	@When("^I registered an user on \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_registered_an_user_on_with(String arg1, String arg2)
			throws Throwable {
		Object a = JSONReader.readJSON(arg2, "SendData.json");
		response = given().contentType("application/json").body(a).when()
				.put(arg1);
	}

	@Then("^I should get response as \"([^\"]*)\" and status code as \"([^\"]*)\"$")
	public void i_should_get_response_as_and_status_code_as(String arg1,
			String arg2) throws Throwable {
		Object a = JSONReader.readJSON(arg1, "Response.json");
		JSONAssert.assertEquals(a.toString(), response.getBody().asString(),
				true);
		assertEquals(response.statusCode(), Integer.parseInt(arg2));
	}
	
	@When("^I requested card lock service with \"([^\"]*)\"$")
	public void i_requested_card_lock_service_with(String arg1) throws Throwable {
		Object a = JSONReader.readJSON(arg1, "SendData.json");
		String loginname = JSONReader.gettingValueFromJSONObject(a, "Login-name");
		String pan = JSONReader.gettingValueFromJSONObject(a, "Pan");
        String password = JSONReader.gettingValueFromJSONObject(a, "Password");
        String lock_ref_id = JSONReader.gettingValueFromJSONObject(a, "lock-ref-id");
        String locking_reason= JSONReader.gettingValueFromJSONObject(a, "locking-reason");
        String finalurl ="/user/"+loginname+"/card/"+pan+"/lock/"+lock_ref_id;
		Map<String,String> Body = new HashMap<>();
        Body.put("locking-reason", locking_reason);
        response = given().contentType("application/json").auth().preemptive().basic(loginname, password).body(Body).when().put(finalurl);
	}

	@Then("^I should get status code as \"([^\"]*)\"$")
	public void i_should_status_code_as(String arg1) throws Throwable {
		assertEquals(Integer.parseInt(arg1),response.statusCode());
	}

}
