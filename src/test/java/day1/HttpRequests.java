package day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpRequests {
	
	int id;
	
	@Test(priority=1)
	void getUser() 
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		
		RestAssured.basePath="posts";
		
		given()
		
		.when()
			.get()
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
		
	}
	
	@Test(priority=2)
	void getUserId()
	{
		given().queryParam("userId", "10")
		
		.queryParam("id", "81")
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
	}
	
	@Test(priority=3)
	void getUserDetail()
	{
		given().queryParam("userId", "1")
		
		.queryParam("id", "1")

		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
			
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.body("[0].userId", equalTo(1))
			.body("[0].id", equalTo(1))
			.body("[0].title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			.body("[0].body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
		
	}
	
	


}
