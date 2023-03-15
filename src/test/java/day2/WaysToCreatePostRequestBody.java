package day2;


import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class WaysToCreatePostRequestBody {
	
	
	@Test
	void testPostUsingHashmap()
	{
		JSONObject data = new JSONObject();
		data.put("userId", 11);
		data.put("id", 101);
		data.put("title", "BDD");
		data.put("body", "this is restassured tutorial");
				
		
		given()
			.contentType("application/json; charset=utf-8")
			.body(data.toString())
			
		.when()
			.post("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(201)
			.body("userId", equalTo(11))
			.body("id", equalTo(101))
			.body("title",equalTo("BDD"))
			.body("body", equalTo("this is restassured tutorial"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	

}
