package control;

import java.util.List;

import model.EntityClient;

public interface PersonaService {
	public void inserisci(EntityClient p);
	public EntityClient aggiorna(String email);
    public void cancella(String email);  
	public EntityClient getClientByEmail(String email);
	
	public List<EntityClient> getAllPerson();
}
//	out = response.getWriter();