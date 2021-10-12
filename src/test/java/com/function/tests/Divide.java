package com.function.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.function.utils.XMLUtils;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Divide {
	
	private String filepath = ".\\SoapRequests\\DivideRequest.xml";

	@Test
	public void validateDivideFunctionWithNegativeInputs() throws IOException {
		String a = "-10";
		String b = "-5";
		XMLUtils.setXMLRequestParams(a, b, filepath);
		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		RestAssured.baseURI = "http://www.dneonline.com";

		Response response = given().header("Content-Type", "text/xml").and()
				.body(IOUtils.toString(fileInputStream, "UTF-8")).when().post("/calculator.asmx").then().statusCode(200)
				.and().log().all().extract().response();

		XmlPath jsXpath = new XmlPath(response.asString());

		String result = jsXpath.getString("GetDivideResult");

		System.out.println("Divide Result for intput A : " + a + " and input B : " + b + " = " + result);
		Reporter.log("Divide Result for intput A : " + a + " and input B : " + b + " = " + result);

	}

	@Test
	public void validateDivideFunctionWithPositiveInputs() throws IOException {

		String a = "20";
		String b = "10";
		XMLUtils.setXMLRequestParams(a, b, filepath);
		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		RestAssured.baseURI = "http://www.dneonline.com";

		Response response = given().header("Content-Type", "text/xml").and()
				.body(IOUtils.toString(fileInputStream, "UTF-8")).when().post("/calculator.asmx").then().statusCode(200)
				.and().log().all().extract().response();

		XmlPath jsXpath = new XmlPath(response.asString());


		String result = jsXpath.getString("GetDivideResult");

		System.out.println("Divide Result for intput A : " + a + " and input B : " + b + " = " + result);
		Reporter.log("Divide Result for intput A : " + a + " and input B : " + b + " = " + result);


	}

	@Test
	public void validateDivideFunctionWithPositiveAndNegativeInputs() throws IOException {

		String a = "50";
		String b = "-10";
		XMLUtils.setXMLRequestParams(a, b, filepath);
		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		RestAssured.baseURI = "http://www.dneonline.com";

		Response response = given().header("Content-Type", "text/xml").and()
				.body(IOUtils.toString(fileInputStream, "UTF-8")).when().post("/calculator.asmx").then().statusCode(200)
				.and().log().all().extract().response();

		XmlPath jsXpath = new XmlPath(response.asString());


		String result = jsXpath.getString("GetDivideResult");

		System.out.println("Divide Result for intput A : " + a + " and input B : " + b + " = " + result);
		Reporter.log("Divide Result for intput A : " + a + " and input B : " + b + " = " + result);


	}

}
