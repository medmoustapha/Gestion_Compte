package gestion.compte.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.compte.dao.ClientRepository;
import gestion.compte.entities.Client;

@Service
public class ClientMetierImpl implements ClientMetier{
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client saveClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public List<Client> listClient() {
		
		return clientRepository.findAll();
	}

}
