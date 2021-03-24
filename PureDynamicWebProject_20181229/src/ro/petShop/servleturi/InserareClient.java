package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;
import ro.petShop.incapsulare.Client;

/**
 * Servlet implementation class test
 */
public class InserareClient extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in InserareClient metoda service -");
		
		String numeClient = req.getParameter("numeClient");
		String prenumeClient = req.getParameter("prenumeClient");
		String localitate = req.getParameter("localitate");
		
		if(( numeClient != null && numeClient != "" && numeClient.matches("^[a-zA-Z]*$")) || ( prenumeClient != null && prenumeClient != "" && prenumeClient.matches("^[a-zA-Z]*$") ) || ( localitate != null && localitate != "" && localitate.matches("^[a-zA-Z]*$")) ){
			Client clientNou = new Client();
			
			try {
				InterogariDBUtil.insertClient( numeClient, prenumeClient, localitate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				req.setAttribute("listaClientiDB", InterogariDBUtil.getAllClienti());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/afisareClienti.jsp");
			dispatcher.forward(req,resp);
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaClienti.jsp");
			dispatcher.forward(req,resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in InserareClient metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in InserareClient metoda doPost -");
		super.doPost(req, resp);
	}


}
