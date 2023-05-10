
package control;


import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import model.EntityClient;
/**
 * Session Bean implementation class PersonaServiceBean
 */
@Stateless
public class PersonaServiceBean implements PersonaServiceBeanRemote, PersonaServiceBeanLocal {


	@PersistenceContext
	private EntityManager manager;
    /**
     * Default constructor. 
     */
    public PersonaServiceBean() {
        
    }
	@Override
	public void inserisci(EntityClient p) {
		manager.persist(p);
		
	}
	@Override
	public EntityClient aggiorna(String email) {
		Query query3 = manager.createQuery("UPDATE Persona p SET p.nome = 'Federico', p.anni = 23 WHERE p.id = :id");
    	query3.setParameter("email", email).executeUpdate();//associo a parametro "id" l'attributo passato al metodo id
    	return manager.find(EntityClient.class, email); //ritorna la persona trovata nel db con id = id 	    

	}
	@Override
	public void cancella(String email) {
		Query query = manager.createQuery("DELETE FROM Persona p WHERE p.id = :id");
		query.setParameter("email", email).executeUpdate();		
	
		
	}
	@Override
	public EntityClient getClientByEmail(String email) {
		return manager.find(EntityClient.class, email);

}
	
	@Override
	public List<EntityClient> getAllPerson() {
		Query q = manager.createQuery("SELECT p FROM Persona p");
		return q.getResultList();	
	}

}
