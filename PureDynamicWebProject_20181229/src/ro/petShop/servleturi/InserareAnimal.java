package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;
import ro.petShop.incapsulare.Animal;

public class InserareAnimal extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in InsereazaAnimal metoda service -");
		

		String idSpecie = req.getParameter("specie");
		System.out.println("specie: "+idSpecie);
		
		String culoareAnimal = req.getParameter("culoareAnimal");
		System.out.println("culoareAnimal: "+culoareAnimal);
		
		String pret = req.getParameter("pret");
		System.out.println("pret: "+pret);
		
		if( (idSpecie != null && idSpecie != "" ) || ( culoareAnimal != null && culoareAnimal != "" && culoareAnimal.matches("^[a-zA-Z]*$")) || ( pret != null && pret != "" ) ){
			Animal animalNou = new Animal();
			try {
				InterogariDBUtil.insertAnimal(Integer.parseInt(idSpecie), culoareAnimal, Integer.parseInt(pret));
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
			
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaAnimale.jsp");
			dispatcher.forward(req,resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in InsereazaAnimal metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in InsereazaAnimal metoda doPost -");
		super.doPost(req, resp);
	}
	
}
