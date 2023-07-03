package Common_API_Methods;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class Put_API_Method {
	

	
	public static int ResponseStatuscode(String BaseURI,String Resource, String RequestBody) {
		
	      RestAssured.baseURI = BaseURI;
	      
	      int statusCode = given().header("Content-Type","application/json").body(RequestBody).
					when().put(Resource).then().extract().statusCode();
		return statusCode;
}

public static String ResponseBody(String BaseURI,String Resource, String RequestBody) {
	
  RestAssured.baseURI = BaseURI;
  
  String Responsebody = given().header("Content-Type","application/json").body(RequestBody).
				when().put(Resource).then().extract().response().asPrettyString();
	return Responsebody;

}


}
