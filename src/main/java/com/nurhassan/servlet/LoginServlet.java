package com.nurhassan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nurhassan.dao.UserDao;
import com.nurhassan.obj.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userType;
		if(request.getParameter("userName").equals("u"))
		{
			userType = "SUPERUSER";
		}
		else
		{
			userType = "ADMIN";
		}
		
		User loginInfo = new User();
		loginInfo.setUserName(userName);
		loginInfo.setPassword(password);
		loginInfo.setUserType(userType);
		
		UserDao veryfyCardentials = new UserDao();
		
		if(veryfyCardentials.checkCardentials(loginInfo))
		{
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			
			response.sendRedirect("dashboard");
		}else
		{
			response.sendRedirect("login.jsp");
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
