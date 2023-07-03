package Test_Classes;
import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_API_Methods.Post_API_Method;
import Request_Repository.Post_Req_Repository;
import io.restassured.path.json.JsonPath;
public class Post_TC1 {
	@Test
	public static void extractor() throws IOException {
		
		int statusCode = Post_API_Method.ResponseStatuscode(Post_Req_Repository.BaseURI(), 
				Post_Req_Repository.Post_Resource(), 
		Post_Req_Repository.Post_Req_TC01());
	   System.out.println(statusCode);
	   
	   String ResponseBody = Post_API_Method.ResponseBody(Post_Req_Repository.BaseURI(), 
			   Post_Req_Repository.Post_Resource(), 
				Post_Req_Repository.Post_Req_TC01());
	    System.out.println(ResponseBody);

	    JsonPath reqb = new JsonPath (Post_Req_Repository.Post_Req_TC01());
		String req_name = reqb.getString("name");
		String req_job = reqb.getString("job");
		
	    //int req_id = reqb.getInt("id");
	    //System.out.println("Print ID from req TC01 "+req_id);
	    
		LocalDateTime currentdate =LocalDateTime.now();
		String Expecteddate =currentdate.toString().substring(0,11);

	    
	    JsonPath JspResponse = new JsonPath(ResponseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt = Res_createdAt.substring(0,11);
		//Validate the ResponseBody parameters
		Assert.assertEquals(req_name, Res_name);
		Assert.assertEquals(req_job, Res_job);
		Assert.assertEquals(Expecteddate,Res_createdAt);
		
		
	    
	}

}
