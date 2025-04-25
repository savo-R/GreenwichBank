package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Student;
import model.StudentAccount;

@Stateless
@LocalBean
public class GreenwichDAOImpl implements GreenwichDAO {

	@PersistenceContext(unitName = "GreenwichBank")
	EntityManager entityManager;

	@Override
	public void addAccount(String alias,int balance, int ownerId) {
		System.out.println("Adding an account");
		System.out.println("Alias"+ alias);
		System.out.println("Balance"+ balance);
		System.out.println("Owner ID: " + ownerId);
		
		List<Student> allStudents = getAllStudents();
		System.out.println("Total students in database: " + allStudents.size());
		
		for(Student s: allStudents) {
			System.out.println("Existing student - ID: " + s.getId() + ", Name: " + s.getName());
		}
				
		Student student = entityManager.find(Student.class,ownerId);

		if(student == null) {
			throw new IllegalArgumentException("Student with ID " + ownerId + " not found");
		}
		
		StudentAccount account = new StudentAccount(alias,balance);
		student.addStudentAccount(account);
		entityManager.persist(student);
		entityManager.persist(account);
	}

	@Override
	public void updateAccount(int id, String newAlias, int newBalance) {
		StudentAccount account = entityManager.find(StudentAccount.class, id);
        if (account != null) {
            account.setAlias(newAlias);
            account.setBalance(newBalance);
            entityManager.merge(account);
        }
    }

	@Override
	public void deleteAccount(int id) {
		StudentAccount account = entityManager.find(StudentAccount.class, id);
        if (account != null) {
            entityManager.remove(account);
        }
    }

	@Override
	public List<StudentAccount> getAllAccounts() {
		List result = entityManager.createNamedQuery("StudentAccount.findAll").getResultList();
		List<StudentAccount> accounts = new ArrayList<StudentAccount>();
		accounts.addAll(result);
		return accounts;
	}

	@Override
	public StudentAccount getAccount(int id) {
		StudentAccount account = entityManager.find(StudentAccount.class,id);
		return account;
	}



	@Override
	public List<Student> getAllStudents() {
		 return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
	}
	
	@Override
	public
	void addStudent(String name, String postalAddress, String email, String telephone) {
		Student student = new Student(name,postalAddress,email,telephone);
		entityManager.persist(student);
		
	}
	
	@Override
	public
	void updateStudent(int id, String newName, String newPostalAddress, String newEmail, String newTelephone) {
		 Student student = entityManager.find(Student.class, id);
	        if (student != null) {
	            student.setName(newName);
	            student.setPostalAddress(newPostalAddress);
	            student.setEmail(newEmail);
	            student.setTelephone(newTelephone);
	            entityManager.merge(student);
	        }
	    }
	
	@Override
	public void deleteStudent(int id) {
	     Student student = entityManager.find(Student.class, id);
	        if (student != null) {
	            entityManager.remove(student);
	        }
	    }
}
	
