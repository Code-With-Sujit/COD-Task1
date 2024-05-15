package com.hospital.user.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.UserDao;
import com.hospital.daoImpl.UserDaoImpl;
import com.hospital.db.DBConnection;
import com.hospital.entities.User;

@WebServlet("/userloginservlet")
public class UserLoginServlet  extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String userEmail=request.getParameter("email");
		 String userPassword=request.getParameter("password");
		 
		 HttpSession session=request.getSession();
		 UserDao userDao=new UserDaoImpl(DBConnection.getConnection());
         User user = userDao.validUserOrNot(userEmail, userPassword)	;	
 		 
         if(user!= null)
         {
        	 session.setAttribute("userObject", user);
        	 response.sendRedirect("index.jsp");
         }
         else {
        	 session.setAttribute("loginmsg", "Invalid Credentials !");
        	 response.sendRedirect("user_login.jsp");
         }
		 
	}

}
