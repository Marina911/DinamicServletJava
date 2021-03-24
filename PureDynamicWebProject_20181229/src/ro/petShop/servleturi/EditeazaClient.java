package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;
import ro.petShop.incapsulare.Client;

public class EditeazaClient extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in EditeazaClient metoda service -");
		
		String idClient = req.getParameter("id");
		System.out.println("idClient: "+idClient);
		
		Client clientDeEditat = new Client();
		
		try {
			clientDeEditat = InterogariDBUtil.getClientById(Integer.parseInt(idClient));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String numeClient = req.getParameter("numeClient");
		String prenumeClient = req.getParameter("prenumeClient");
		String localitate = req.getParameter("localitate");

		if((idClient != null && idClient != "" ) && ( numeClient != null && numeClient != "" ) && ( prenumeClient != null && prenumeClient != "" ) && ( localitate != null && localitate != "" ) ) {
			
			System.out.println("numeClient: "+numeClient);
			System.out.println("prenumeClient: "+prenumeClient);
			System.out.println("prenumeClient: "+localitate);
			
			Client clientNou = new Client();
			
			clientNou.setNume(numeClient);
			clientNou.setPrenume(prenumeClient);
			clientNou.setLocalitate(localitate);
			clientNou.setIdClient(Integer.parseInt(idClient));
			
			try {
				InterogariDBUtil.updateClient(clientNou);
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
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editareClient.jsp");
			req.setAttribute("client", clientDeEditat);
			
			dispatcher.forward(req,resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in EditeazaClient metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in EditeazaClient metoda doPost -");
		super.doPost(req, resp);
	}
	


}
