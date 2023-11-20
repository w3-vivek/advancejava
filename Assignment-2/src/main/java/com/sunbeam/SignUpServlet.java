package com.sunbeam;

import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		String date1 = req.getParameter("date");
		Date date = Date.valueOf(date1);
		String enabled1 = req.getParameter("enabled");
		int enabled = enabled1 != null ? Integer.parseInt(enabled1) : 0;
		String role = req.getParameter("role");

		try {
			UserDao userdao = new UserDao();
			User user = new User(0, name, password, mobile, email, address, enabled, role, date);
			userdao.save(user);
			System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
