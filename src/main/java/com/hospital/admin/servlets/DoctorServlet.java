package com.hospital.admin.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.dao.DoctorDao;
import com.hospital.daoImpl.DoctorDaoImpl;
import com.hospital.db.DBConnection;
import com.hospital.entities.Doctor;

@WebServlet("/AddDoctor")
public class DoctorServlet  extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String qualification=request.getParameter("qualification");
		String specialist=request.getParameter("specialist");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		
		Doctor doctor=new Doctor(name, dob, qualification, specialist, email, password, phone);
		
		DoctorDao doctorDao=new DoctorDaoImpl(DBConnection.getConnection());
		HttpSession session=request.getSession();
		if(doctorDao.addDoctor(doctor))
		{
			session.setAttribute("success", "Doctor added successfully !");
			response.sendRedirect("admin/doctor.jsp");
		}
		else 
		{
			session.setAttribute("failure", "Something went wrong on server");
			response.sendRedirect("admin/doctor.jsp");
		}
	}
   
}
