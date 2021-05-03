package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.rainbow.business.service.ClientService;
import edu.mum.rainbow.common.model.Client;


@RestController
@RequestMapping({ "/clients" })
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@RequestMapping({"","/all"})
	public List<Client> findAll() {
		List<Client> clientList = clientService.findAll();
		return clientList;

	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addClient(@RequestBody Client client) {
		clientService.addClient(client);
 
	}
	

}
