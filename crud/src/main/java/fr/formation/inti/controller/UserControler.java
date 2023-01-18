package fr.formation.inti.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;

/**
 * Servlet implementation class UserControler
 */
@WebServlet("/user")
public class UserControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeService employeeService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: test").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get all user
		//set user
		List<Employee> employees = employeeService.findAll();
		request.getServletContext().getRequestDispatcher("/employee.jsp").forward(request, response);
	}

}
