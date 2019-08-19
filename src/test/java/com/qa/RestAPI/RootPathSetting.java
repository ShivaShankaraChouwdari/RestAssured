package com.qa.RestAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class RootPathSetting {
	
	/*
	 * Setting Root Path
	 * 
	 * 
	 */
	@Test(priority = 1)
	public void testXMLCodeContainsText() {
 			
		given().
		  get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").
		  then().body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
		   log().all();
	}

}
