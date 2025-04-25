package rest;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.GreenwichDAOImpl;
import model.Student;
import model.StudentAccount;

@Path("/bank")
public class GreenwichBankRESTService {

    @EJB
    private GreenwichDAOImpl greenwichDAOImpl;

    // Student-related REST endpoints
    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStudents() {
        try {
            return Response.ok(greenwichDAOImpl.getAllStudents()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error retrieving students: " + e.getMessage())
                .build();
        }
    }

    @POST
    @Path("/students")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Student student) {
        try {
            greenwichDAOImpl.addStudent(
                student.getName(), 
                student.getPostalAddress(), 
                student.getEmail(), 
                student.getTelephone()
            );
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error adding student: " + e.getMessage())
                .build();
        }
    }

    // Account-related REST endpoints
    @GET
    @Path("/accounts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAccounts() {
        try {
            return Response.ok(greenwichDAOImpl.getAllAccounts()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error retrieving accounts: " + e.getMessage())
                .build();
        }
    }

    @POST
    @Path("/accounts")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAccount(StudentAccount account) {
        try {
            greenwichDAOImpl.addAccount(
                account.getAlias(), 
                account.getBalance(), 
                account.getStudent().getId() 
            );
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity("Error adding account: " + e.getMessage())
                .build();
        }
    }
}