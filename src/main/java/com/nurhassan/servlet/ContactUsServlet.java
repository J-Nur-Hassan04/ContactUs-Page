package com.nurhassan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nurhassan.dao.RequestDao;
import com.nurhassan.obj.Request;


/**
 * Servlet implementation class ContactUsServlet
 */
@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		RequestDao r =new RequestDao();	
		Request contact = new Request();
		contact.setName(request.getParameter("customerName").trim());
		contact.setEmail(request.getParameter("customerEmail").trim());
		contact.setMessage(request.getParameter("customerMessage").trim());
		contact.setStatus(false);
		
		if(r.storeContactData(contact))
		{
			response.getWriter().println("Thanks for conatct with us");
			response.sendRedirect("contactus.jsp");
		}else
		{
			response.getWriter().println("Data not saved");
			response.sendRedirect("sontactus.jsp");
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("contactus.jsp").forward(request, response);
	}

}
