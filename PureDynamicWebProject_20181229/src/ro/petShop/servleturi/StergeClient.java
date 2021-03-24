package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.incapsulare.Client;
import ro.petShop.ajutorare.InterogariDBUtil;

public class StergeClient  extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("- in StergeClient metoda service -");
		String idClient = req.getParameter("id");
		System.out.println("idClient: "+idClient);
		
		String id_client = req.getParameter("id_client");
		
		Client clientDeSters = new Client();
		
		try {
			InterogariDBUtil.deleteClient(Integer.parseInt(idClient));
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

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in StergeClient metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in StergeClient metoda doPost -");
		super.doPost(req, resp);
	}
	
}
