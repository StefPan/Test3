package view;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

import model.EntityClient;
import control.PersonaServiceBeanLocal;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jakarta.ejb.EJB;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	PersonaServiceBeanLocal clientService;

	// Creo connessione al Db
	// ServletConfig serve per configurare, è fatto apposta
	public void init(ServletConfig config) throws ServletException {

	}

	// controllo se esiste email registrata e password,
	// se non esiste rimando a servlet per iscriversi
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// ASSEGNO PARAMETRI DAL FORM
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		EntityClient client = new EntityClient();
		client.setEmail(email);
		client.setPassword(password);
		try {
			EntityClient client2 = clientService.getClientByEmail(client.getEmail());

			HttpSession session = request.getSession();

			session.setAttribute("email", email);
			session.setAttribute("password", password);

			request.getRequestDispatcher("gestioneLogin.jsp").forward(request, response);

		} catch (jakarta.ejb.EJBTransactionRolledbackException e) {
			e.printStackTrace();
		}

		
	}

}
