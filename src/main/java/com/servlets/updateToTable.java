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
 * Servlet implementation class updateToTable
 */
@WebServlet("/updateToTable")
public class updateToTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateToTable() {
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
		
		ParkInfo updateToTable = new ParkInfo();
		
		updateToTable.setParkID(Integer.parseInt(request.getParameter("updateid")));
		updateToTable.setParkName(request.getParameter("updatename"));
		updateToTable.setParkCity(request.getParameter("updatecity"));
		updateToTable.setParkState(request.getParameter("updatestate"));
		updateToTable.setParkYearEst(Integer.parseInt(request.getParameter("updateyear")));
		updateToTable.setParkFee(Integer.parseInt(request.getParameter("updatefee")));
		
		DAO.updateTheTable(updateToTable);
		
		request.getRequestDispatcher("index.html").forward(request, response);

	}

}
