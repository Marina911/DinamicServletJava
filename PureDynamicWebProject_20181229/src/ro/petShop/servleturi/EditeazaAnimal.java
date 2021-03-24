package ro.petShop.servleturi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;
import ro.petShop.incapsulare.Animal;

public class EditeazaAnimal extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in EditeazaAnimal metoda service -");
		
		String idAnimal = req.getParameter("id");
		System.out.println("idAnimal: "+idAnimal);
		
		Animal animalDeEditat = new Animal();
		
		 try {
			 animalDeEditat = InterogariDBUtil.getAnimalById(Integer.parseInt(idAnimal));
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		 
			String culoareAnimal = req.getParameter("culoareAnimal");
			String pret = req.getParameter("pret");
			
		if( (idAnimal != null && idAnimal != "" ) && ( culoareAnimal != null && culoareAnimal != "" ) && ( pret != null && pret != "" ) ){
			
			System.out.println("deEditat-pret: "+pret);
			System.out.println("deEditat-culoareAnimal: "+culoareAnimal);

			Animal animalNou = new Animal();
			
			animalNou.setIdSpecie(Integer.parseInt(idAnimal));
			animalNou.setCuloare(culoareAnimal);
			animalNou.setPret(Integer.parseInt(pret));
			animalNou.setIdAnimal(Integer.parseInt(idAnimal));

			try {
				InterogariDBUtil.updateAnimal(animalNou);
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
			
		}else{
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editareAnimale.jsp");
			req.setAttribute("animal", animalDeEditat);
		
			dispatcher.forward(req,resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in EditeazaAnimal metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in EditeazaAnimal metoda doPost -");
		super.doPost(req, resp);
	}
	
}
