package com.goopai.carmaxcompute.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goopai.carmaxcompute.db.PageBean;
import com.goopai.carmaxcompute.entity.Car;
import com.goopai.carmaxcompute.entity.CarDAO;

/**
 * Servlet implementation class CarInfoServlet
 */
@WebServlet("/CarInfoServlet")
public class CarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarInfoServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String param = request.getParameter("page");
		System.out.println("param:" + param);
		PageBean page = PageBean.getInstance();
		List<Car> list = null;
		if (param.equals("first")) {
			page.setPage(1);
			CarDAO carDAO = new CarDAO();
			list = carDAO.getCarnewsChaSQL("car_news", page);
		} else if (param.equals("next")) {
			int nextpage = page.getNextPage();
			page.setPage(nextpage);
			CarDAO carDAO = new CarDAO();
			list = carDAO.getCarnewsChaSQL("car_news", page);
		} else if (param.equals("pre")) {
			int nextpage = page.getLastPage();
			page.setPage(nextpage);
			CarDAO carDAO = new CarDAO();
			list = carDAO.getCarnewsChaSQL("car_news", page);
		} else if (param.equals("last")) {
			page.setPage(page.getTotalPage());
			CarDAO carDAO = new CarDAO();
			list = carDAO.getCarnewsChaSQL("car_news", page);
		}
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("./listcarnews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
