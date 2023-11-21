package com.sunbeam;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcart")
public class AddCartServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// get user cart from the session
		 		HttpSession session = req.getSession();
		 		ArrayList<Integer> cart = (ArrayList<Integer>) session.getAttribute("cart");
		
		String[] bookIds = req.getParameterValues("book");
		for (String bookId : bookIds) {

			int id = Integer.parseInt(bookId);
			// to save id in user cart do state manegmentsuper.
			
			if(!cart.contains(id))
				cart.add(id);
		}
		System.out.println("Current User: " + session.getAttribute("uname"));
		System.out.println("Modified Cart: " + cart);
		
		// go to the subject servlet
		RequestDispatcher rd = req.getRequestDispatcher("subjects");
		rd.forward(req, resp);

		}

		
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}


}
