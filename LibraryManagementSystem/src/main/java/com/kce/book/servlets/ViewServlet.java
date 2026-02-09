package com.kce.book.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.kce.book.bean.BookBean;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		BookBean bookbean=(BookBean) session.getAttribute("book");
		out.print("<html><body>");
		out.print("Book title:"+bookbean.getBookName()+"<br><br>");
		out.print("Author name:"+bookbean.getAuthor().getAuthorName()+"<br><br>");
		out.print("Author Contact:"+bookbean.getAuthor().getContactNo()+"<br><br>");
		out.print("Book Price:"+bookbean.getCost()+"<br><br>");
	    out.print("Book ISBN:"+bookbean.getIsbn()+"<br><br>");
	    out.print("</body></html>");
	}

}
