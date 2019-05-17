package com.webproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServletProject
 */
@WebServlet("/FirstServletProject")
public class FirstServletProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer bookid=Integer.parseInt(request.getParameter("id"));
		String bookname=request.getParameter("name");
		String bookauthor=request.getParameter("author");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:bookdb","root","root");
		Statement statement=connection.createStatement();
		int executeUpdate=statement.executeUpdate("insert into bookinfo values("+bookid+",+'"+bookname+"',"+bookauthor+")");
		
		
		PrintWriter out=response.getWriter();
		out.println(bookid);
		out.println(bookname);
		out.println(bookauthor);
		connection.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	}

}
