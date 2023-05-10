package model;

import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;


@Entity

@Table(name = "clienti")
public class EntityClient {
	
		private static final long serialVersionUID = 1L;
		
		
		
		private Long id;
		private String nome;
		private String cognome;
		private String email;
		private String password;
		private String indirizzo;
		private String cap;
		private String citta;
		
	

		public EntityClient () {}
		
		public EntityClient(Long id, String nome, String cognome, String email, String password, String indirizzo,
				String cap, String citta) {
			super();
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.password = password;
			this.indirizzo = indirizzo;
			this.cap = cap;
			this.citta = citta;
		}
		
	
		@Id
		@Column(name="id_clienti")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		@Column(name="nome", nullable=false)
		public String getNome() {
			return nome;
		}
		@Column(name="cognome")
		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCognome() {
			return cognome;
		}

		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		@Column(name="email")
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		@Column(name="passwrd")
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		@Column(name="indirizzo")
		public String getIndirizzo() {
			return indirizzo;
		}
		
		public void setIndirizzo(String indirizzo) {
			this.indirizzo = indirizzo;
		}
		@Column(name="cap")
		public String getCap() {
			return cap;
		}

		public void setCap(String cap2) {
			this.cap = cap2;
		}
		@Column(name="citta")
		public String getCitta() {
			return citta;
		}

		public void setCitta(String citta) {
			this.citta = citta;
		}

		

		@Override
		public int hashCode() {
			return Objects.hash( id, nome,cognome,email, password, indirizzo, cap, citta);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EntityClient other = (EntityClient) obj;
			return Objects.equals(cognome, other.cognome) && id == other.id 
					&& Objects.equals(nome, other.nome) && Objects.equals(email, other.email) 
					&& Objects.equals(password, other.password)
					 && Objects.equals(indirizzo,other.indirizzo)
					 && Objects.equals(cap,other.cap)
					&& Objects.equals(citta, other.citta);
		}
		
		
		
		
		
	}
