package service.interfaces;

import java.util.List;

import model.ClientDTO;

public interface ClientServiceInterface {

	
	public void createCliente(ClientDTO newClient);
	public void deleteClientById(Integer idCliente);
	public void updateCliente(ClientDTO updateCliente);
	public List<ClientDTO> findAll();
	public ClientDTO findById(Integer idCliente);
	public List<ClientDTO> findByName(String nameCliente);
	
	
}
