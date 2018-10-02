package coditas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import coditas.empService.EmpDetailsService;
import coditas.empService.Employee;

public class EmpDetailsController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In EmpController");
		EmpDetailsService detailsService = new EmpDetailsService();
		
		String m_id = request.getParameter("Manager_Id");
		
		List<Employee> list =detailsService.empDetails(Integer.parseInt(m_id));
		request.setAttribute("empList", list);
		request.setAttribute("dummy", "raj");
		System.out.println("list "+list);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	}


}
