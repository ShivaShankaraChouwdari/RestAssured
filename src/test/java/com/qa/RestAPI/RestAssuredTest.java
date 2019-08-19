package com.qa.RestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssuredTest {

	@Test(priority = 1)
	public void testStatusCode() {
 Response resp=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
			System.out.println("Hi Response: "+resp.getStatusCode());
			
	}
	
	@Test(priority = 3)
	public void testXMLCodeContainsString() {
 			
		given().
		  get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		  then().body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue"))).
		   log().all();
	}
	
	@Test(priority = 4)
	public void testXMLCodeContainsText() {
 			
		given().
		  get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		  then().body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
		   log().all();
	}
	
	@Test(priority = 5)
	public void testXMLCodeContainsAnyText() {
 			
		given().
		  get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
		  then().body(hasXPath("/INVOICEList/INVOICE[text()='40']")).
		   log().all();
	}
	@Test(priority = 2)
	public void testLogging() {
		
		// Response resp=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
			//System.out.println("Response: "+resp.getStatusCode());

		//http://services.groupkt.com/country/get/all
		//http://www.thomas-bayer.com/sqlrest/
		
			given().
			  get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
			  then().
			   statusCode(200).
			   log().all();
			
	}
	
	//@Test
	public void testSetHeaderandParams() {
		
		// Response resp=get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
			//System.out.println("Response: "+resp.getStatusCode());

		//http://services.groupkt.com/country/get/all
			given().
			    param("key1", "value1").
			    header("headA", "ValuA").
			 when().
			    get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
			 then().
			   statusCode(200).
			   log().all();
			
	}
}
