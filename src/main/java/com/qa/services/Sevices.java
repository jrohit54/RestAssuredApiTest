package com.qa.services;

import java.util.List;
import java.util.TreeMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Sevices {
	
	
	public void getUsers(String url)
	{
		RequestSpecification spec = RestAssured.given();
		Response response = spec.get(url);
		System.out.println("status code is --->"+response.getStatusCode());
        System.out.println("respponse body is --->"+response.getBody().asString());		
	}
	
	public void createUser(String url,String name, String job) throws JSONException
	{
		JSONObject json=new JSONObject();
		json.put("name", "morphous");
		json.put("job", "leader");
		
		RequestSpecification spec = RestAssured.given();
		spec.header("content-type","application/json");
		spec.body(json.toString());
		Response postResponse = spec.post(url);
		
		System.out.println("status code is --->"+postResponse.getStatusCode());
		System.out.println("response body is --->"+postResponse.getBody().asString());
		TreeMap<String,String> hm=new TreeMap<String, String>();
	    List<Header> asList = postResponse.getHeaders().asList();
	    for (Header header : asList) {
			hm.put(header.getName(), header.getValue());
		}
	    System.out.println("header in response are  ---> "+hm);
		
		
	}
	

}
