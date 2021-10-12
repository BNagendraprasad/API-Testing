package com.function.tests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.function.utils.XMLUtils;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Add {

	private String filepath = ".\\SoapRequests\\AddRequest.xml";

	@Test
	public void validateAddFunctionWithNegativeInputs() throws IOException {
		String a = "-10";
		String b = "-5";
		XMLUtils.setXMLRequestParams(a, b, filepath);
		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		RestAssured.baseURI = "http://www.dneonline.com";

		Response response = given().header("Content-Type", "text/xml").and()
				.body(IOUtils.toString(fileInputStream, "UTF-8")).when().post("/calculator.asmx").then().statusCode(200)
				.and().log().all().extract().response();

		XmlPath jsXpath = new XmlPath(response.asString());

		String result = jsXpath.getString("GetAddResult");

		System.out.println("Add Result for intput A : " + a + " and input B : " + b + " = " + result);
		Reporter.log("Add Result for intput A : " + a + " and input B : " + b + " = " + result);

	}

	@Test
	public void validateAddFunctionWithPositiveInputs() throws IOException {

		String a = "20";
		String b = "10";
		XMLUtils.setXMLRequestParams(a, b, filepath);
		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		RestAssured.baseURI = "http://www.dneonline.com";

		Response response = given().header("Content-Type", "text/xml").and()
				.body(IOUtils.toString(fileInputStream, "UTF-8")).when().post("/calculator.asmx").then().statusCode(200)
				.and().log().all().extract().response();

		XmlPath jsXpath = new XmlPath(response.asString());


		String result = jsXpath.getString("GetAddResult");

		System.out.println("Add Result for intput A : " + a + " and input B : " + b + " = " + result);
		Reporter.log("Add Result for intput A : " + a + " and input B : " + b + " = " + result);


	}

	@Test
	public void validateAddFunctionWithPositiveAndNegativeInputs() throws IOException {

		String a = "50";
		String b = "-10";
		XMLUtils.setXMLRequestParams(a, b, filepath);
		FileInputStream fileInputStream = new FileInputStream(new File(filepath));
		RestAssured.baseURI = "http://www.dneonline.com";

		Response response = given().header("Content-Type", "text/xml").and()
				.body(IOUtils.toString(fileInputStream, "UTF-8")).when().post("/calculator.asmx").then().statusCode(200)
				.and().log().all().extract().response();

		XmlPath jsXpath = new XmlPath(response.asString());


		String result = jsXpath.getString("GetAddResult");

		System.out.println("Add Result for intput A : " + a + " and input B : " + b + " = " + result);
		Reporter.log("Add Result for intput A : " + a + " and input B : " + b + " = " + result);


	}

}
