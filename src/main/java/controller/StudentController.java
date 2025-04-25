package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GreenwichDAOImpl;
import model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/student-controller")
public class StudentController extends HttpServlet {

	@EJB
	private GreenwichDAOImpl greenwichDAOImpl;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentController() {
		super();

		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("StudentController, doPost method Started");
//			String action = request.getServletPath();
		String action = request.getParameter("action");
		if (action == null)
			action = "list";

		System.out.println("StudentController action => " + action);

		switch (action) {
		case "list":
			getAllStudents(request, response);
			break;

		case "add":
			addStudent(request, response);
			break;

		case "update":
			updateStudent(request, response);
			break;
		case "delete":
			deleteStudent(request, response);
			break;

		default:
			System.out.println("default action");
			getAllStudents(request, response);
			break;
		}
		
		// The dispatcher
		List<Student> students = greenwichDAOImpl.getAllStudents();
		System.out.println("getallStudents, Students size " + students.size());
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/allStudents.jsp");
		request.setAttribute("students", students);
		dispatcher.forward(request, response);

	}

    private void getAllStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = greenwichDAOImpl.getAllStudents();
        System.out.println("getAllStudents, Students size " + students.size());
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/allStudents.jsp");
        dispatcher.forward(request, response);
    }
	
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Starting deleteStudent");
        String id = request.getParameter("id");
        System.out.println("deleteStudent, Student id ==> " + id);

        if (id != null) {
            greenwichDAOImpl.deleteStudent(Integer.parseInt(id));
        }

        response.sendRedirect("student-controller?action=list");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Starting updateStudent");
        String id = request.getParameter("id");
        String newName = request.getParameter("newName");
        String newPostalAddress = request.getParameter("newPostalAddress");
        String newEmail = request.getParameter("newEmail");
        String newTelephone = request.getParameter("newTelephone");

        System.out.println("updateStudent, Student id,newName,newPostalAddress==> " + id + " " + newName + " " + newPostalAddress);
        
        greenwichDAOImpl.updateStudent(Integer.parseInt(id),newName,newPostalAddress,newEmail, newTelephone);

        
        response.sendRedirect("student-controller?action=list");
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Starting addStudent");
        String name = request.getParameter("name");
        String postalAddress = request.getParameter("postalAddress");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

        System.out.println("addNewStudent, Student name ==> " + name);

        if (name != null && !name.isEmpty()) {
            greenwichDAOImpl.addStudent(name, postalAddress, email, telephone);
        }
        
        response.sendRedirect("student-controller?action=list");
    }
}
