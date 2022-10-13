package com.web.controllers;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Employee;

@RestController
public class MainRestController {
	
	@Autowired
	Employee emp;
	
	CloseableHttpClient client = HttpClients.createDefault();
	HttpGet Getclient;
	
	@GetMapping("/")
	public Employee getEmployee() {
		return emp;
	}
	
	
	@GetMapping("/call")
	public String getEmployeeName() {
		
		String data = "sin datos.";
		this.Getclient = new HttpGet("http://localhost:8080/SpringRestBase");
		
		this.Getclient.setHeader("Accept", "application/json");
		this.Getclient.setHeader("Content-type", "application/json");
		try {
			CloseableHttpResponse response = client.execute(this.Getclient);
			InputStream instream = response.getEntity().getContent();
		    byte[] bytes = IOUtils.toByteArray(instream);
		    data  = new String(bytes, "UTF-8");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
