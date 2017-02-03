package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import session.AccountFacadeLocal;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AccountFacadeLocal accountFacade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountServlet() {
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
		URL = "index.jsp";
		 if ("logout".equals(action)){
				
				HttpSession session= request.getSession();
				session.invalidate();
				
			URL="login.jsp";}
		 response.sendRedirect(URL);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String action, URL;
			String u, p;
			action = request.getParameter("action");
			URL = "index.jsp";
			
			
			if ("login".equals(action)){
				u= request.getParameter("username");
				p= request.getParameter("password");
				if (u.equals("admin")&&p.equals("admin")) {
					URL="adminMenu.jsp";
				} else {
				boolean logincheck= accountFacade.checkLogin(u, p);
				
				if (logincheck){
					request.getSession().setAttribute("login", u);
					URL="manager.jsp";
					
					
				}else 
				{
					URL="login.jsp?error=1";
				}
				}
			}else if ("insert".equals(action)){
				Account a= new Account();
				a.setUsename(request.getParameter("username"));
				a.setPassword(request.getParameter("password"));
				a.setEmail(request.getParameter("email"));
				a.setTel(request.getParameter("tel"));
				
				accountFacade.create(a);
				//URL="login.jsp";
				
				
			}
//			else if ("logout".equals(action)){
//				
//				HttpSession session= request.getSession();
//				session.invalidate();
//				
//				//URL="login.jsp";
//			}
//			
			response.sendRedirect(URL);
		} finally {
			out.close();
		}

	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		try {
//			String action, URL;
//			String u, p;
//			action = request.getParameter("action");
//			URL = "index.jsp";
//			
//			
//			if ("login".equals(action)){
//				u= request.getParameter("username");
//				p= request.getParameter("password");
//				boolean logincheck= accountFacade.checkLogin(u, p);
//				
//				if (logincheck){
//					
//					URL="manager.jsp";
//				}else 
//				{
//					URL="login.jsp";
//				}
//			}else if ("insert".equals(action)){
//				
//				
//			}
//			
//			response.sendRedirect(URL);
//		} finally {
//			out.close();
//		}

	}

}
