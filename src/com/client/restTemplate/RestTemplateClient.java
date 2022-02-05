package com.client.restTemplate;

import java.net.SocketTimeoutException;
import org.springframework.web.client.ResourceAccessException;
import com.client.restTemplate.models.Cliente;
import com.client.restTemplate.service.ClientRestTemplateService;

public class RestTemplateClient {
		
	public static void main(String[] args) {		
		ClientRestTemplateService clientService = new ClientRestTemplateService();
		Cliente cliente = new Cliente(1, "Jesus", "Vazquez", 28, "JVCH1112221234", "Hidalgo 62", "554431981");
		try {
			//GET
			System.out.println("GET: " + clientService.getClient(1));
			
			//GET
			System.out.println("List of clients: ");
			clientService.getClients().forEach( (clienteList) -> System.out.println(clienteList));
			
			//POST
			System.out.println("POST: " + clientService.saveClient(cliente));
			
			//PUT
			System.out.println("PUT: " + clientService.updateClient(cliente, 1));
			
			//DELETE
			System.out.println("DELETE: " + clientService.deleteClient(1));	

			//ResponseEntity
			System.out.println("RESPONSE ENTITY");
			System.out.println("STATUS HTTP: " + clientService.getClientsWithResponseEntity().getStatusCodeValue());
			System.out.println("HEADERS: " + clientService.getClientsWithResponseEntity().getHeaders());
			System.out.println("RESPONSE: " + clientService.getClientsWithResponseEntity().getBody());
			
		} catch (SocketTimeoutException e) {
				System.out.println(e.getMessage());
		} catch (ResourceAccessException e) {
				System.out.println(e.getMessage());
		}
	}
}
