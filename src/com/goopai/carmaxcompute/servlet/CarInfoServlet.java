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
		String pageParam = request.getParameter("page");
		String action = request.getParameter("action");
		System.out.println("param:" + pageParam);
		System.out.println("action:" + action);
		PageBean page = PageBean.getInstance();
		List<Car> list = null;
		if (pageParam != null) {
			if (pageParam.equals("first")) {
				page.setPage(1);
				CarDAO carDAO = new CarDAO();
				list = carDAO.getCarnewsChaSQL("car_news", page);
			} else if (pageParam.equals("next")) {
				int nextpage = page.getNextPage();
				page.setPage(nextpage);
				CarDAO carDAO = new CarDAO();
				list = carDAO.getCarnewsChaSQL("car_news", page);
			} else if (pageParam.equals("pre")) {
				int nextpage = page.getLastPage();
				page.setPage(nextpage);
				CarDAO carDAO = new CarDAO();
				list = carDAO.getCarnewsChaSQL("car_news", page);
			} else if (pageParam.equals("last")) {
				page.setPage(page.getTotalPage());
				CarDAO carDAO = new CarDAO();
				list = carDAO.getCarnewsChaSQL("car_news", page);
			}
			request.setAttribute("list", list);
			request.setAttribute("page", page);
			request.getRequestDispatcher("./listcarnews.jsp").forward(request, response);
		}
		if (action != null) {
			if (action.equals("detail")) {
				int id = Integer.parseInt(request.getParameter("id"));
				System.out.println("id:" + id);
				CarDAO carDAO = new CarDAO();
				Car car = carDAO.getCarBeanById(id);
				request.setAttribute("object", car);
				request.getRequestDispatcher("./carcontent.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
