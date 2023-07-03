package Test_Classes;
import org.testng.annotations.Test;

import Common_API_Methods.Get_API_Method;
import Request_Repository.Get_Req_Repository;
//import org.testng.Assert;
//import Request_Repository.Post_Req_Repository;
//import io.restassured.path.json.JsonPath;
public class Get_TC1 {
	@Test
	public static void extractor() {
		
		int statusCode = Get_API_Method.ResponseStatuscode(Get_Req_Repository.BaseURI(),
		Get_Req_Repository.Get_Resource());
	   System.out.println(statusCode);
	   
	   String ResponseBody = Get_API_Method.ResponseBody(Get_Req_Repository.BaseURI(),
				Get_Req_Repository.Get_Resource());
	    System.out.println(ResponseBody);
	}}