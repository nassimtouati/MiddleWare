package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import session.ArtisteFacadeLocal;

/**
 * Servlet implementation class reservationServlet
 */
@WebServlet("/reservationServlet")
public class reservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB  
	   private ArtisteFacadeLocal artisteFacade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setAttribute("Artiste", artisteFacade.findAll());
		
		request.getRequestDispatcher("listEventClient.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
