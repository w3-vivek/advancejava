package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Subjects</title>");
		out.println("</head>");
		out.println("<body>");
		try (BookDao bookDao = new BookDao()) {
			List<String> list = bookDao.getSubjects();
			out.println("<form method='post' action='books'>");
			for (String subject : list) {
				out.printf("<input type='radio' name='subject' value='%s'/> %s<br/>\n", subject, subject);
			}
			out.println("<input type='submit' value='Show Books'/>");
			out.println("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
