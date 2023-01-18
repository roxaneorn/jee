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

import fr.formation.inti.entity.Employee;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.EmployeeServiceImpl;
import fr.formation.inti.service.UserService;
import fr.formation.inti.service.UserServiceImpl;

/**
 * Servlet implementation class loginControler
 */
@WebServlet("/login")
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	private EmployeeService employeeService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginControler() {
		this.userService = new UserServiceImpl();
		this.employeeService = new EmployeeServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
			request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
			request.getServletContext().getRequestDispatcher("/employee").forward(request, response);
			
		}else if (user != null && user.getPassword().equals(password) && "user".equals(user.getRoleName())){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.getServletContext().getRequestDispatcher("/employee").forward(request, response);
		}else {
			request.getServletContext().getRequestDispatcher("/loginfail.html").forward(request, response);
			
		}

	}
}
