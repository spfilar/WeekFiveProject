package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nationalparks.DAO;
import com.nationalparks.ParkInfo;

/**
 * Servlet implementation class addToTable
 */
@WebServlet("/addToTable")
public class addToTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParkInfo addTo = new ParkInfo();
		
		addTo.setParkName(request.getParameter("name"));
		addTo.setParkCity(request.getParameter("city"));
		addTo.setParkState(request.getParameter("state"));
		addTo.setParkYearEst(Integer.parseInt(request.getParameter("year")));
		addTo.setParkFee(Integer.parseInt(request.getParameter("fee")));
		
		DAO.writeToTable(addTo);
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
