package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProDAO;
import model.Product;
import model.Card;
import model.Items;

/**
 * Servlet implementation class card
 */
@WebServlet("/card")
public class card extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Card card = new Card();
	List<Items> list = card.list;
	ProDAO prodao = new ProDAO();
	Items item = new Items();
	String listtxt;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public card() {
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
		String action = request.getParameter("action");
		if (request.getParameter("action") != null) {

			if (action.equals("add")) {

				int id = Integer.parseInt(request.getParameter("id"));
				if (card.checkItem(id)) {
					System.out.println("product exitted");
					request.setAttribute("error", "product exitted!!");
				} else {

					Product product = prodao.getpro(id);

					Items items = new Items(product, 1, product.getPrice());
					list.add(items);
				}
				listtxt = "";
				for (Items i : list) {

					listtxt += i.getPro().getProID() + "-" + i.getQuantity() + ".";
				}
				System.out.println("aaaaa" + listtxt);
				// listtxt = "1-1.2-2.3-1.";
				if (!listtxt.equals("")) {

					Cookie cookie = new Cookie("listtxt", listtxt);
					cookie.setMaxAge(60);

					response.addCookie(cookie);

					if (response.containsHeader("Set-Cookie")) {
						System.out.println("Cookie sent successfully");
					} else {
						System.out.println("Failed to send cookie");
					}

				}

				request.setAttribute("pronum", list.size());
				request.getRequestDispatcher("index.jsp").forward(request, response);

			} else if (action.equals("remove")) {
				int id = Integer.parseInt(request.getParameter("id"));

				card.removeItems(id);
				section.setAttribute("total", card.gettotal());
				listtxt = "";
				for (Items i : list) {

					listtxt += i.getPro().getProID() + "-" + i.getQuantity() + ".";
				}
				System.out.println("aaaaa" + listtxt);
				// listtxt = "1-1.2-2.3-1.";
				if (!listtxt.equals("")) {

					Cookie cookie = new Cookie("listtxt", listtxt);
					cookie.setMaxAge(60);

					response.addCookie(cookie);

					if (response.containsHeader("Set-Cookie")) {
						System.out.println("Cookie sent successfully");
					} else {
						System.out.println("Failed to send cookie");
					}

				}
				// request.getRequestDispatcher("card.jsp").forward(request, response);
				response.sendRedirect("card2.jsp");
				
			} else if (action.equals("minus")) {
				int id = Integer.parseInt(request.getParameter("id"));

				Iterator<Items> iterator = list.iterator();
				while (iterator.hasNext()) {
					Items items = iterator.next();
					if (items.getPro().getProID() == id && items.getQuantity() == 1) {
						iterator.remove();
					}
				}
				listtxt = "";
				for (Items i : list) {

					listtxt += i.getPro().getProID() + "-" + i.getQuantity() + ".";
				}
				System.out.println("aaaaa" + listtxt);
				// listtxt = "1-1.2-2.3-1.";
				if (!listtxt.equals("")) {

					Cookie cookie = new Cookie("listtxt", listtxt);
					cookie.setMaxAge(60);

					response.addCookie(cookie);

					if (response.containsHeader("Set-Cookie")) {
						System.out.println("Cookie sent successfully");
					} else {
						System.out.println("Failed to send cookie");
					}

				}
				card.minus(id);
				section.setAttribute("total", card.gettotal());

				// request.getRequestDispatcher("card.jsp").forward(request, response);
				response.sendRedirect("card2.jsp");
			} else if (action.equals("plus")) {
				int id = Integer.parseInt(request.getParameter("id"));

				card.plus(id);
				listtxt = "";
				for (Items i : list) {

					listtxt += i.getPro().getProID() + "-" + i.getQuantity() + ".";
				}
				System.out.println("aaaaa" + listtxt);
				// listtxt = "1-1.2-2.3-1.";
				if (!listtxt.equals("")) {

					Cookie cookie = new Cookie("listtxt", listtxt);
					cookie.setMaxAge(60);

					response.addCookie(cookie);

					if (response.containsHeader("Set-Cookie")) {
						System.out.println("Cookie sent successfully");
					} else {
						System.out.println("Failed to send cookie");
					}

				}
				section.setAttribute("total", card.gettotal());
				// request.getRequestDispatcher("card.jsp").forward(request, response);
				response.sendRedirect("card2.jsp");
			}

		}

		section.setAttribute("total", card.gettotal());

		// section.setAttribute("list", list);

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

}
