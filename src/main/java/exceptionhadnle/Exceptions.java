package exceptionhadnle;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileReader;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Exceptions  {
	
	 public static String getSessionKey()
	 {
	 	  String b= "{\"username\": \"bhabani.m\", \"password\": \"goddezza@123\" }";

	       
	 	  
	 	  RestAssured.baseURI="http://localhost:8090";
	 	  
	 	  Response resp=  given().header("Content-Type","application/json").and().body(b).
	 	  when().post("/rest/auth/1/session").
	 	  then().assertThat().statusCode(200).extract().response();
	 	
	 	    String s =     resp.asString();
	 	    JsonPath js= new JsonPath(s);
	 	    String sessionid= js.get("session.value");
	 	    System.out.println(sessionid);
	 	    return sessionid;
	   }
	 
	 public static void createIssue()
	  {
		  String id= getSessionKey();
		  String line="",res="";
	  try
	  {
			BufferedReader br= new BufferedReader(new FileReader("/Users/bhabanimishra/Desktop/bug.json"));
			line= br.readLine();
			StringBuilder sb= new StringBuilder();
			while(line!= null)
			{
			 sb.append(line);
			 line=br.readLine();
			 
			}
			 res= sb.toString();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  System.out.println(res);
		  
		  RestAssured.baseURI="http://localhost:8090";
		  
		Response cb=  given().header("content-type","application/json").
		  header("Cookie","JSESSIONID="+id).
		  body(res).
		  when().post("/rest/api/2/issue/").then().assertThat().statusCode(201).extract().response();
		
		System.out.println(cb);
		
		String k=cb.asString();
		JsonPath js= new JsonPath(k);
		String bugid= js.get("");
	  }

}
