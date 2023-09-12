	package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.HistoryDAO;
import DAO.ProDAO;
import DAO.UserDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import model.Card;
import model.History;
import model.Items;
import model.User;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Card card = new Card();
	List<Items> list = card.list;
	List<History> listh = new ArrayList<>();
	List<History> listh1 = new ArrayList<>();
	int tong;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkout() {
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

		HttpSession section = request.getSession();
		User user = (User) request.getSession().getAttribute("user");

		UserDAO userdao = new UserDAO();
		HistoryDAO hisdao = new HistoryDAO();

		// list = (List<Items>) section.getAttribute("list");
		
		
		//lấy list bằng cookie
		List<Items> listitem=new ArrayList<>();
		
		Cookie[] cookies = request.getCookies(); // Get all the cookies
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("listtxt")) { 
			String cookieValue = cookie.getValue(); // Retrieve the value of the cookie
			// Do something with the cookie value
			System.out.println(cookieValue+"jsp");
			ProDAO dao=new ProDAO();
			 
			list=dao.getlistpro(cookieValue);
			
		break;
		}
		}
		}
		//hết

		for (Items items : list) {

			History his = new History(userdao.getiduser(user.getUsername()), items.getPro().getProID(),
					items.getQuantity(), items.getQuantity() * items.getPro().getPrice(), getdate());
			listh.add(his);
			tong += items.getQuantity() * items.getPro().getPrice();
		}
		list.clear();

		hisdao.insert(listh);
		listh1 = hisdao.getlist1(userdao.getiduser(user.getUsername()));
		section.setAttribute("listh", listh1);
		section.setAttribute("totalorder", tong);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String getdate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);

	}

}
