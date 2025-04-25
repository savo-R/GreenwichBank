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
import model.StudentAccount;

/**
 * Servlet implementation class AccountServlet
 */

@WebServlet("/account-controller")
public class AccountController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private GreenwichDAOImpl greenwichDAOImpl;

    public AccountController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "list":
                getAllAccounts(request, response);
                break;
            case "add":
                addAccount(request, response);
                break;
            case "update":
                updateAccount(request, response);
                break;
            case "delete":
                deleteAccount(request, response);
                break;
            default:
                getAllAccounts(request, response);
                break;
        }
    }

    private void getAllAccounts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<StudentAccount> accounts = greenwichDAOImpl.getAllAccounts();
        List<Student> students = greenwichDAOImpl.getAllStudents();
        
        request.setAttribute("accounts", accounts);
        request.setAttribute("students", students);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/allAccounts.jsp");
        dispatcher.forward(request, response);
    }

    private void addAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String alias = request.getParameter("alias");
            int balance = Integer.parseInt(request.getParameter("balance"));
            int ownerId = Integer.parseInt(request.getParameter("ownerId"));
            
            Student student = null;
            for (Student s : greenwichDAOImpl.getAllStudents()) {
                if (s.getId() == ownerId) {
                    student = s;
                    break;
                }
            }
            
            if (student == null ) {
            	throw new IllegalArgumentException("Student with Id"+ ownerId +"does't exist");
            }
            
            
            greenwichDAOImpl.addAccount(alias, balance, ownerId);
            response.sendRedirect("account-controller?action=list");
        } catch (IllegalArgumentException e) {
            // Set error message and forward to error page
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String newAlias = request.getParameter("alias");
        int newBalance = Integer.parseInt(request.getParameter("balance"));
        greenwichDAOImpl.updateAccount(id, newAlias, newBalance);
        response.sendRedirect("account-controller?action=list");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        greenwichDAOImpl.deleteAccount(id);
        response.sendRedirect("account-controller?action=list");
    }
}
