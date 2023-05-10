package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import control.PersonaServiceBeanLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EntityClient;

/**
 * Servlet implementation class CreateClient
 */
@WebServlet(urlPatterns = "/createClient")
public class CreateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
@EJB
PersonaServiceBeanLocal clientService;

	  
		/**
		 * @see Servlet#init(ServletConfig)
		 *///servletConfig serve per configurare, è fatto apposta
		public void init(ServletConfig config) throws ServletException {
			
		}

		
			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//creo tt ciò che serve per inserimento dati
				//i parametri email password li prendo dalla form in index.html
				
				System.out.println("doPost()");
				String firstName = request.getParameter("nome");
				String lastName = request.getParameter("cognome");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				String indirizzo = request.getParameter("indirizzo");
				String cap = request.getParameter("cap");
				String citta = request.getParameter("citta");
				
				EntityClient client= new EntityClient();
				client.setNome(firstName);
				client.setCognome(lastName);
				client.setEmail(email);
				client.setPassword(password);
				client.setIndirizzo(indirizzo);
				client.setCap(cap);
				client.setCitta(citta);
				
				try {
					clientService.inserisci(client);
				//TODO crea session e passagli resultset cosi passi a jsp che stampa
			//		session.setAttribute("name", email);
					
						request.getRequestDispatcher("welcoming.jsp").include(request, response);
					
					
				
				} catch (jakarta.ejb.EJBTransactionRolledbackException e) {
					e.printStackTrace();
					response.setContentType("text/html");
					PrintWriter out=response.getWriter();
					out.print("<h1>OPS, QUALCOSA E' ANDATO STORTO. ERRORE NELLA CREAZIONE</h1>");
					request.getRequestDispatcher("erroreRegistrazione.jsp").include(request, response);
					out.close();
				
			}
				}

			
		/**
		 * @see Servlet#destroy()
		 */
		public void destroy() {
			
		}

		

	}
