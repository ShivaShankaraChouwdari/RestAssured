package com.qa.RestAPI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class TestResponseSpecBuilder {
	ResponseSpecification respspec;
	
	@BeforeClass
	public void setup() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		respspec=builder.build();
	}
     
	@Test
	public void testResponse() {
		when().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10/").then().spec(respspec).time(lessThan(4000L)).log().headers();
		
	}
}

