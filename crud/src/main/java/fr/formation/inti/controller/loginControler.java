package fr.formation.inti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.formation.inti.entity.User;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class loginControler
 */
@WebServlet("/login")
public class loginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginControler() {
		this.userService = new UserServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getContextPath());
		} else {
			String message = request.getParameter("This email doesn't exist. Create your session !");
			request.setAttribute("This email doesn't exist. Create your session !", message);
			request.getServletContext().getRequestDispatcher("/user").forward(request, response);
		}

//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		User user = userService.findByEmail(email);
//		
//		List<User> list = userService.findAll();
//		list.forEach(System.out::println);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userService.findByEmail(email);
		System.out.println(user);
		if (user != null && user.getPassword().equals(password) && "admin".equals(user.getRoleName())) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getServletContext().getRequestDispatcher("/employeeAdmin.jsp").forward(request, response);
			
		}else if (user != null && user.getPassword().equals(password) && "user".equals(user.getRoleName())){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getServletContext().getRequestDispatcher("/employee.jsp").forward(request, response);
		}else {
			request.getServletContext().getRequestDispatcher("/loginfail.html").forward(request, response);
			
		}

	}
}
