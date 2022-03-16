package RestTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Trello 
{
	public static String baseurl = "https://api.trello.com";
	public static String id;
	
	@Test(priority = 0)
	public void createBoard()
	{
		
		//i want to fetch the base url so that i can add other thing to that base url
		//This is the first step to provide base url to the request
		RestAssured.baseURI = baseurl;
		
		//in rest assured we have three keyword
		//given : pre-condition includes like parameter,header, authorization,
		//when : condition i am testing like resource //iwe have to provide the name //that is called resource /1/board/ and the method name
		//then : post condition : is something like response check the response
		Response response = given().queryParam("name", "Divboard")
				.queryParam("key", "b39219fe7dbd1d6144c6700033e3b9a5")
				.queryParam("token", "475d47aa08cebeb6bdef7da62aecf29ba71113f671b5752437f0ab28744f2c62")
				.header("Content-Type", "application/json")
				
				.when()
				.post("/1/boards/")

		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();	
		//This is to fetch the response as a string
		String jsonresponse = response.asString();
		//i want to convert the response in to json format
		//why do i use jsonpath to convert the string in to a json format
		JsonPath js = new JsonPath(jsonresponse);
		//nw i have to fetch the id
		id = js.get("id");
		
	}
	
	//if i make any @Test method enabled =false/ that method will not execute
	
	@Test(priority = 1)
	public void getBoard()
	{
		RestAssured.baseURI = baseurl;
		
		Response response = given().queryParam("name", "Divboard")
				.queryParam("key", "b39219fe7dbd1d6144c6700033e3b9a5")
				.queryParam("token", "475d47aa08cebeb6bdef7da62aecf29ba71113f671b5752437f0ab28744f2c62")
				.header("Content-Type", "application/json")
		.when()
		.get("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();	
		String jsonresponse = response.asString();
		
		System.out.println(jsonresponse);
	}
	
	@Test(priority = 2)
	public void DeleteBoard()
	{
		RestAssured.baseURI = baseurl;
		
		
	Response response =	given().queryParam("name", "Divboard")
			.queryParam("key", "b39219fe7dbd1d6144c6700033e3b9a5")
			.queryParam("token", "475d47aa08cebeb6bdef7da62aecf29ba71113f671b5752437f0ab28744f2c62")
			.header("Content-Type", "application/json")
			

		
		.when()
		.delete("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();	
		String jsonresponse = response.asString();
		
		System.out.println(jsonresponse);
	}
}