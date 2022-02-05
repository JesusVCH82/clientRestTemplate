package com.client.restTemplate.service;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.client.restTemplate.models.Cliente;
import com.google.gson.Gson;

public class ClientRestTemplateService {
	
	private static final String PATH_API = "http://localhost:8080/serviceREST-JAX-RS/api/v1/clientes";
	private RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
	 
	//Override timeouts in request factory
	private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
	    //Connect timeout
	    clientHttpRequestFactory.setConnectTimeout(2000);
	    //Read timeout
	    clientHttpRequestFactory.setReadTimeout(2000);
	    return clientHttpRequestFactory;
	}

	public List<Cliente> getClients() {
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 HttpEntity <String> entity = new HttpEntity <String> (null, headers);
		 ResponseEntity <String> result = restTemplate.exchange(PATH_API, HttpMethod.GET, entity, String.class);
		 Cliente[] clientes = new Gson().fromJson(result.getBody(), Cliente[].class);
		 return Arrays.asList(clientes);
	}
	
	public Cliente getClient(int id) throws SocketTimeoutException{
		String cliente = restTemplate.getForObject(PATH_API + "/" + String.valueOf(id), String.class);
		//ResponseEntity<Cliente> entityClient = restTemplate.getForEntity(PATH_API + "/" + String.valueOf(id), Cliente.class);
		return new Gson().fromJson(cliente, Cliente.class);
	}
	
	public String saveClient(Cliente cliente) {
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 String clientJson = new Gson().toJson(cliente);
		 HttpEntity <String> entity = new HttpEntity <String> (clientJson, headers);
		 ResponseEntity <String> result = restTemplate.exchange(PATH_API, HttpMethod.POST, entity, String.class);
		return result.getBody();
	}
	
	public String updateClient(Cliente cliente, int id) {
		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 String clientJson = new Gson().toJson(cliente);
		 HttpEntity <String> entity = new HttpEntity <String> (clientJson, headers);
		 ResponseEntity <String> result = restTemplate.exchange(PATH_API + "/" + String.valueOf(id), HttpMethod.PUT, entity, String.class);
		 return result.getBody();
	}
	
	public String deleteClient(int id) {
		HttpEntity <String> entity = new HttpEntity <String> (null, new HttpHeaders());
		ResponseEntity <String> result = restTemplate.exchange(PATH_API + "/" + String.valueOf(id), HttpMethod.DELETE, entity, String.class);
		return result.getBody();
	}
	
	public ResponseEntity<String> getClientsWithResponseEntity() {
		HttpEntity <String> entity = new HttpEntity <String> (null, new HttpHeaders());
		ResponseEntity <String> result = restTemplate.exchange(PATH_API, HttpMethod.GET, entity, String.class);
		return result;
	}
	
	
	
	
	
}
