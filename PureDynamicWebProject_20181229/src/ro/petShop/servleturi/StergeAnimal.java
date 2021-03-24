package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;


public class StergeAnimal extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("- in StergeAnimal metoda service -");
		
		int idAnimal = Integer.parseInt(req.getParameter("id"));
		System.out.println("idAnimal: "+idAnimal);
		
		try {
			InterogariDBUtil.deleteAnimal(idAnimal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			req.setAttribute("listaAnimaleDB", InterogariDBUtil.getAllAnimale());
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/afisareAnimale.jsp");
		dispatcher.forward(req,resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in StergeAnimal metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in StergeAnimal metoda doPost -");
		super.doPost(req, resp);
	}
	
}
