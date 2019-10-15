package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In post");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String un;
		String ps;
		String utype = null;
		int flag = 0;
		PrintWriter out=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ts", "root", "root");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from login where user_username='" + username+"'");
			rs.next();
			un = rs.getString(1);
			ps = rs.getString(2);
			utype = rs.getString(4);
			rs.getString(3);

			if (username.equals(un) && password.equals(ps)) {
				System.out.println("Record Found");
				flag = 1;
			} else {
				System.out.println("Wrong username");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Record not found");
			response.sendRedirect("index.jsp");
			//e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if (flag == 1) {
			if (utype.equals("1")) {
				response.setContentType("text/html");
				 out = response.getWriter();
					out.println("<html><h1>Admin</h1></html>");
				out.println("<html><h1>Welcome " + username + "</h1></html>");
			}
			else if (utype.equals("2")) {
				response.setContentType("text/html");
				 out = response.getWriter();
					out.println("<html><h1>User</h1></html>");
				out.println("<html><h1>Welcome " + username + "</h1></html>");
			}
			else {
				response.sendRedirect("index.jsp");
			}

		}
	}
}
