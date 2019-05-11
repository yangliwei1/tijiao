package com.Ylw.login;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LianJie extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载失败");
			e.printStackTrace();
		}
		 /**
		  *第三步
		  * 连接jdbc驱动器
		  */
		 try {
			Connection con= (Connection) DriverManager.getConnection
					 ("jdbc:mysql://127.0.0.1:3306/frientdb","root","admin");
			System.out.println("创建加载成功");
			//第四步
			Statement sta=(Statement) con.createStatement();
			String un = request.getParameter("user");
			String pwd = request.getParameter("password");
			ResultSet rs=sta.executeQuery("select * from studentinfo;");
			while(rs.next()){
				String user= rs.getString("user");
				String passwrod= rs.getString("passwrod");
				System.out.println(user+passwrod);
				
			}
			int n=sta.executeUpdate("insert net_table values('"+un+"+hu','"+pwd+"+589416') ");
			System.out.println("添加"+n+"条");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建加载失败");
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
