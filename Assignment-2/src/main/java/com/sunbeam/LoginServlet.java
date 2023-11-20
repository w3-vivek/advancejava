package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get form data from request body
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		System.out.println("email: " + email + ", password: " + password);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login Result</title>");
		out.println("</head>");
		out.println("<body>");

		try (UserDao userDao = new UserDao()) {
			// use Dao to fetch user details
			User user = userDao.findByEmail(email);
			// verify entered password
			if (user != null && password.equals(user.getPassword())) {
				// login is successful
				if (user.getRole().equals("ROLE_ADMIN"))
					out.println("<h2>Welcome, Admin!</h2>");
				else
					out.printf("<h2>Welcome, User (%s)!</h2>\n", user.getName());
			} else {
				// login is failed
				out.println("<h2>Invalid email or password.</h2>");
				out.println("<a href='index.html'>Login again</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}
}
