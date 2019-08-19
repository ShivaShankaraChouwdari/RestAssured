package com.qa.RestAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_RequestSpec {
	RequestSpecification reqSpec;
	
	@BeforeClass
	public void setup() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addParam("parameter1", "parameterValue");
		reqSpec=builder.build();
}
	@Test
	public void testRequest() {
		given().spec(reqSpec).when().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").then().statusCode(200);
		
	}
}
