package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		UserDAO dao = new UserDAO();

		String username = request.getParameter("user");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		String confirmpass = request.getParameter("confirm");


		if (dao.checkuser(username)) {
			System.out.println("exit");
			request.setAttribute("error", "Username Exited!!!");
			
		} else if(!pass.equals(confirmpass)) {
			System.out.println("not same");
			request.setAttribute("error", "pass and confirm pass not same!!!");
	
		} else {
			User user = new User(username, mail, pass);
			dao.register(user);

			
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

	}

}
