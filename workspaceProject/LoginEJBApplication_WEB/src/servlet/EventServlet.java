package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Reservation;
import session.ArtisteFacade;
import session.ArtisteFacadeLocal;
import session.ReservationFacadeLocal;
import session.SeatFacadeLocal;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;

	@EJB
	private ArtisteFacadeLocal ArtisteFacade;

	@EJB
	private SeatFacadeLocal SeatFacade;

	@EJB
	private ReservationFacadeLocal reservationFacade;

	public EventServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action, URL;
		action = request.getParameter("action");
		request.getSession().setMaxInactiveInterval(30);
		if (action == null) {
			request.setAttribute("Artiste", ArtisteFacade.findAll());
			request.getRequestDispatcher("listEventClient.jsp").forward(request, response);
		}

		else if ("reservation".equals(action)) {

			int id = Integer.parseInt(request.getParameter("idArtiste"));
			request.getSession().setAttribute("idArtiste", id);

			request.getSession().setAttribute("category", request.getParameter("category"));
			request.getSession().setAttribute("idSeat", request.getParameter("seat"));
			request.setAttribute("id", id);
			request.setAttribute("idseat", request.getParameter("seat"));
			request.setAttribute("seat", SeatFacade.find(Integer.parseInt(request.getParameter("seat"))));

			request.getRequestDispatcher("reservation.jsp").forward(request, response);

		} else if ("reserver".equals(action)) {

		
		
			request.getRequestDispatcher("EventServlet").forward(request,
			 response);
			 

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action, URL;
		action = request.getParameter("action");
		Integer comp = 4;
		Long l = Long.valueOf(comp.longValue());
		Reservation reservation = new Reservation();
		// HttpSession session = request.getSession(false);

		if (action.equals("reserver")) {
			try {

				
					reservation.setIdArtiste(request.getParameter("artiste"));
					reservation.setIdSeat(request.getParameter("seat"));
					reservation.setNbrSeat(Integer.parseInt(request.getParameter("nbrSeat")));
					reservation.setSeatCat(request.getParameter("seatCat"));
					reservation.setUserName((String) request.getSession().getAttribute("login"));
					reservation.setGain(Double.parseDouble(request.getParameter("gain")));

					
					if (reservationFacade.checkNbrBooking(request.getParameter("seat"), request.getParameter("artiste"),
							(String) request.getSession().getAttribute("login")) >= l) {
						request.getRequestDispatcher("error.jsp").forward(request, response);
						// URL="reservation.jsp?error=1";
						// URL="error.jsp";
					}
				
					
					reservationFacade.create(reservation);
						response.sendRedirect("EventServlet");
					
					
				

			} catch (Exception e) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		}

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
