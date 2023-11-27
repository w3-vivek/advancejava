package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Book List</title>");
		out.println("</head>");
		out.println("<body>");

		// retrieve name cookie from client and display Hello message
		String userName = "";
		/*
		Cookie[] arr = req.getCookies();
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname")) {
					userName = c.getValue();
					break;
				}
			}
		}
		*/
		// retrieve name from session and display Hello message
		HttpSession session = req.getSession();
		userName = (String) session.getAttribute("uname");
		out.printf("Hello, %s <hr/>\n", userName);

		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Author</th>");
		out.println("<th>Subject</th>");
		out.println("<th>Price</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		try(BookDao bookDao = new BookDao()) {
			List<Book> list = bookDao.findAll();
			for (Book b: list) {
				out.println("<tr>");
				out.printf("<td>%d</td>\n", b.getId());
				out.printf("<td>%s</td>\n", b.getName());
				out.printf("<td>%s</td>\n", b.getAuthor());
				out.printf("<td>%s</td>\n", b.getSubject());
				out.printf("<td>%.2f</td>\n", b.getPrice());
				out.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
