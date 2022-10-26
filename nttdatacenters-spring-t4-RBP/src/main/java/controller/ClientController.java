package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.ClientDTO;
import service.ClientService;

@ResponseBody
@Controller
public class ClientController {

	@Autowired
	ClientService serviceClient;

	// produces = MediaType.APPLICATION_JSON_VALUE
	
	//, consumes = MediaType.APPLICATION_JSON_VALUE
	
	// Crear nuevo cliente
	@PostMapping(path = "/newClient")
	public void createClient(@RequestBody ClientDTO newClientDTO) {

	
		
		serviceClient.createCliente(newClientDTO);
	}

	// Eliminar cliente
	@DeleteMapping(path = "/deleteClient")
	public void deleteClient(@RequestParam("id") Integer idClientDTO) {

		
		serviceClient.deleteClientById(idClientDTO);

	}

	// Actualizar  cliente
	@PutMapping(path = "/updateClient")
	public void updateClient(@RequestBody ClientDTO newClientDTO) {


		serviceClient.updateCliente(newClientDTO);
	}

	//listar Todos los clientes
	@GetMapping("/listClients")
	public ResponseEntity<List<?>> findAll() {
		
		System.out.println("ok entra");
		
		
		List<ClientDTO> listClientDTO = serviceClient.findAll();
		
		if (!listClientDTO.isEmpty()) {
			return new ResponseEntity<>(listClientDTO, HttpStatus.OK);
		}

		else {

			return new ResponseEntity<>(new ArrayList(), HttpStatus.OK);
		}
	}
	
	
	//Devolver Cliente por  id
	@GetMapping("/returnClient")
	public ClientDTO findById(@RequestParam("id") Integer idClient) {
		
		ClientDTO newClientDTO = serviceClient.findById(idClient);
	
		return newClientDTO;
	}
	
	
	//listar clientes por nombre
	@GetMapping("/listClientsByName")
	public ResponseEntity<List<ClientDTO>> findAllByName(@RequestParam("nameClient") String nameClient) {
				
		List<ClientDTO> listClientDTO = serviceClient.findByName(nameClient);
		
		if (!listClientDTO.isEmpty()) {
			return new ResponseEntity<>(listClientDTO, HttpStatus.OK);
		}

		else {

			return new ResponseEntity<>(new ArrayList(), HttpStatus.OK);
		}
	}
	
	
	
	
	

}
