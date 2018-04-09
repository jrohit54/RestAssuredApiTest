package com.qa.test;

import org.json.JSONException;
import org.testng.annotations.Test;

import com.qa.services.Sevices;

public class ApiTest {

	
	
	@Test
	public void getUsers()
	{
		Sevices service=new Sevices();
		service.getUsers("https://restcountries.eu/rest/v1/name/norway");
		
	}
	@Test
	public void createUser() throws JSONException
	{
		Sevices service=new Sevices();
		service.createUser("https://reqres.in/api/users", "morphous", "leader");
	}
	
	
}
