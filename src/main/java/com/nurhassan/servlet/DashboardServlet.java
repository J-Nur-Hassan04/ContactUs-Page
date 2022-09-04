package com.nurhassan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nurhassan.dao.RequestDao;
import com.nurhassan.obj.Request;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDao requestDao = new RequestDao();
		List<Request> dataList = new ArrayList<>();
		dataList = requestDao.fetchContactData();
		request.setAttribute("data", dataList);
		
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDao requestData = new RequestDao();
		requestData.updateData(Integer.parseInt(request.getParameter("requestId")));
		response.sendRedirect("dashboard");
		
	}

}
