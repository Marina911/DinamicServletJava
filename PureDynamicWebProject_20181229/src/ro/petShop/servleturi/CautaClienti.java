package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
public class CautaClienti extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in CautaClienti metoda service -");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cautaClient.jsp");
		dispatcher.forward(req,resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in CautaClienti metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in CautaClienti metoda doPost -");
		super.doPost(req, resp);
	}


}
