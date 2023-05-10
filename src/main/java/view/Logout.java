package view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {



		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			
			//CHIUDO LA SESSIONE
			HttpSession session = request.getSession();
			session.invalidate();

			out.print("<br><h1>Logout effettuato. Alla prossima!</h1>");
			request.getRequestDispatcher("index.html").include(request, response);
			
			out.close();
		}

	}