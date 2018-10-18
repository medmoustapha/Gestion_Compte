package gestion.compte.metier;

import java.util.List;

import gestion.compte.entities.Client;

public interface ClientMetier {
  public Client saveClient(Client c);
  public List<Client> listClient();
}
