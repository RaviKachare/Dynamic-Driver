package Request_Repository;

import java.io.IOException;
import java.util.ArrayList;

import Common_API_Methods.Common_Utility_Method;

public class Put_Req_Repository 
    {
	public static String BaseURI() 
	{
		String baseuri = "https://reqres.in";
		return baseuri;	
	}
	public static String Put_Resource() 
	{
		String put_Resource = "/api/users/2";
		return put_Resource;
	}
	public static String Put_Req_TC01() throws IOException 
	{
		ArrayList<String> Req_Data = Common_Utility_Method.ReadDataExcel("Put_Ref", "TC5"); 
		 
		String Req_name = Req_Data.get(1);
		 
		String Req_job = Req_Data.get(2);
		 
		String RequestBody = "{\r\n"
				+ "    \"name\": \""+Req_name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}
	
    }