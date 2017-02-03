package servlet;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.*;
import session.*;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/ArtisteServlet")
public class ArtisteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ArtisteFacade artisteFacade= new ArtisteFacade();
	@EJB
	private ReservationFacade reservationFacade= new ReservationFacade();
	@EJB
	private SeatFacadeLocal seatFacade;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArtisteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String action = request.getParameter("action");
			
		if (action == null) {
			request.setAttribute("Artiste", artisteFacade.findAll());
	request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
	} else if (action.equalsIgnoreCase("gain")){
			request.setAttribute("Reservation", reservationFacade.findAll());
			request.getRequestDispatcher("gain.jsp").forward(request, response);
		}
		
		else if (action.equalsIgnoreCase("viewSeatDispo")){
			int x = Integer.parseInt(request.getParameter("seat"));
			
			request.setAttribute("Seat", seatFacade.find(x));
			request.getRequestDispatcher("seat.jsp").forward(request, response);
		}
		
		
		
		
	else if (action.equalsIgnoreCase("delete")){
try {
			
			int id_artiste = Integer.parseInt(request.getParameter("id_artiste"));
			int seat = Integer.parseInt(request.getParameter("seat"));

			artisteFacade.remove(artisteFacade.find(id_artiste));
			
			seatFacade.remove(seatFacade.find(seat));
			response.sendRedirect("ArtisteServlet");
			
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			request.setAttribute("Artiste", artisteFacade.findAll());
			request.getRequestDispatcher("eventManagement.jsp").forward(request, response);
		}
	} 
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		String action = request.getParameter("action");

		
			
			
			
			
			if ("add".equals(action)){
				
				try { String URL;
				URL = "addEvent.jsp";
				Artiste a= new Artiste();
				Seat b = new Seat();
				
				b.setSeat_CA(request.getParameter("w"));
				b.setSeat_CB(request.getParameter("x"));
				b.setSeat_CD(request.getParameter("y"));
				b.setSeat_CC(request.getParameter("z"));
				
				
				a.setA_name(request.getParameter("a_name"));
				a.setA_category(request.getParameter("a_category"));
				a.setDate(request.getParameter("date"));
		

		
		
		a.setSeat(b);
		seatFacade.create(b);	
				
				
				//URL="login.jsp";
				artisteFacade.create(a);
				

				response.sendRedirect(URL);
				
			} 
			
				
			
		 finally {
			//out.close();
		}
			}
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}	
}
