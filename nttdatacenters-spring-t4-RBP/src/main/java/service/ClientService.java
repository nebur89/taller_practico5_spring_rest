package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Client;
import model.ClientDTO;
import repository.ClientRepository;
import service.interfaces.ClientServiceInterface;

@Service
public class ClientService implements ClientServiceInterface {

	@Autowired
	ClientRepository clientRep;



	@Override
	public void createCliente(ClientDTO newClient) {

		Client cliente = createClient(newClient);

		clientRep.save(cliente);

	}

	@Override
	public void deleteClientById(Integer idCliente) {

		clientRep.deleteById(idCliente);
	}

	@Override
	public void updateCliente(ClientDTO updateCliente) {

		Client cliente = createClient(updateCliente);

		clientRep.save(cliente);
	}

	@Override
	public List<ClientDTO> findAll() {

	 List<ClientDTO> listadoClientDTO= new ArrayList<>();
		
		List<Client> listadoClient = clientRep.findAll();
		
		for (Client client : listadoClient) {
			
			ClientDTO clientDTO= createClientDTO(client);
			listadoClientDTO.add(clientDTO);	
		}

		return listadoClientDTO;

	}

	@Override
	public ClientDTO findById(Integer idCliente) {
		
		ClientDTO clienteDTO = null;

		Optional<Client> cliente = clientRep.findById(idCliente);

		if (!cliente.isEmpty()) {

			clienteDTO = createClientDTO(cliente.get());
		}

		return clienteDTO;

	}

	@Override
	public List<ClientDTO> findByName(String nameCliente) {
		
	 List<ClientDTO> listadoClientDTO= new ArrayList<>();
		
		List<Client> listadoClient = clientRep.findByName(nameCliente);
		
		for (Client client : listadoClient) {
			
			ClientDTO clientDTO= createClientDTO(client);
			listadoClientDTO.add(clientDTO);
			
		}

		return listadoClientDTO;
		
		
	}

	
	//Conversor de clientDTO a clients
	private Client createClient(ClientDTO clientDTO) {

		Client cliente = new Client();

		cliente.setId(clientDTO.getId());
		cliente.setName(clientDTO.getName());
		cliente.setSurname(clientDTO.getSurname());
		cliente.setDni(clientDTO.getDni());
		cliente.setDateOfBirth(clientDTO.getDateOfBirth());

		return cliente;
	}

	//Conversor de client a clientDTO
	private ClientDTO createClientDTO(Client client) {

		ClientDTO clienteDTO = new ClientDTO();

		clienteDTO.setId(client.getId());
		clienteDTO.setName(client.getName());
		clienteDTO.setSurname(client.getSurname());
		clienteDTO.setDni(client.getDni());
		clienteDTO.setDateOfBirth(client.getDateOfBirth());

		return clienteDTO;
	}

}
