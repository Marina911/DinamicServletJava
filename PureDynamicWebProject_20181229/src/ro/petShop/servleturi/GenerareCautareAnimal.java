package ro.petShop.servleturi;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.petShop.ajutorare.InterogariDBUtil;
import ro.petShop.incapsulare.Animal;

public class GenerareCautareAnimal extends HttpServlet {
	
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("- in GenerareCautareAnimal metoda service -");
		
		String pretMinim = req.getParameter("pretMinim");
		String pretMaxim = req.getParameter("pretMaxim");
		System.out.println("pretMinim: "+pretMinim);
		System.out.println("pretMaxim: "+pretMaxim);
		
		if((pretMinim != null && pretMinim != "") || (pretMaxim != null && pretMaxim != "") ) {
		try {
			List<Animal> animaleCautate = InterogariDBUtil.getAnimaleBetweenPret(Integer.parseInt(pretMinim), Integer.parseInt(pretMaxim));
			System.out.println(animaleCautate.isEmpty());
			
			if(animaleCautate.isEmpty() == true) {
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/paginaAnimalInexistent.jsp"); 
				dispatcher.forward(req,resp);	
				
			}else {
			
				try {
					req.setAttribute("listaAnimaleDB", animaleCautate);
				} catch (Exception e) {
					e.printStackTrace();
				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/afisareAnimaleCautate.jsp");
				dispatcher.forward(req,resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cautaAnimal.jsp"); 
			dispatcher.forward(req,resp);
			}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in GenerareCautareAnimal metoda doGet -");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("- in GenerareCautareAnimal metoda doPost -");
		super.doPost(req, resp);
	}
	
}