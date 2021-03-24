package ro.petShop.servleturi;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;
import ro.petShop.incapsulare.Client;

public class GenerareCautare extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("- in GenerareCautare metoda service -");
		
		String numeClient = req.getParameter("numeClient");
		System.out.println("numeClient: "+numeClient);
		
		
		Client clientDeCautat = new Client();
		
		if(numeClient != null && numeClient != "") {

		try {
			List<Client> clientCautat = InterogariDBUtil.getClientByName(numeClient);
			System.out.println(clientCautat.isEmpty());
			
			if(clientCautat.isEmpty() == true) {
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaClientInexistent.jsp"); 
				dispatcher.forward(req,resp);	
				
			}else {
			
				req.setAttribute("listaClientiDB", clientCautat);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/afisareClientCautat.jsp");
				dispatcher.forward(req,resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cautaClient.jsp"); 
			dispatcher.forward(req,resp);
			}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in GenerareCautare metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in GenerareCautare metoda doPost -");
		super.doPost(req, resp);
	}
	
}
