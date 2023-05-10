package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateClient
 */
@WebServlet(urlPatterns = "/createClient")
public class CreateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection;
	  
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
				
				try {
					Statement statement = connection.createStatement();
					int result = statement.executeUpdate("INSERT INTO clienti(nome, cognome,email,passwrd, indirizzo, cap, citta)"
							+ " VALUES('" + firstName + "','" + lastName + "','" + email + "','" + password + "','"+ indirizzo + "','" + cap + "','"
							+ citta + "');");
				//TODO crea session e passagli resultset cosi passi a jsp che stampa
			//		session.setAttribute("name", email);
					PrintWriter out = response.getWriter();
					if (result > 0) {
						request.getRequestDispatcher("welcoming.jsp").include(request, response);
					} else {
						out.print("<h1>OPS, QUALCOSA E' ANDATO STORTO. ERRORE NELLA CREAZIONE</h1>");
						request.getRequestDispatcher("formUser.html").include(request, response);
					}
					
				
				} catch (SQLException e) {
					e.printStackTrace();
				
			}
				}

			
		/**
		 * @see Servlet#destroy()
		 */
		public void destroy() {
			//chiudo connessione
			try {
				System.out.println("destroy()");
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		

	}
