/**?
 * 
 */
/**
 * 
 */
package dao;

import java.util.List;

import model.Student;
import model.StudentAccount;



public interface GreenwichDAO {

	public void addAccount(String alias,int balance, int ownerId);

	public void updateAccount(int id, String alias, int newBalance) ;

	public void deleteAccount(int id);
	
	public List<StudentAccount> getAllAccounts();
	
	public StudentAccount getAccount(int id);

	public List<Student> getAllStudents();

	void addStudent(String name, String postalAddress, String email, String telephone);

	void updateStudent(int id, String name, String newPostalAddress, String newEmail, String newTelephone);

	void deleteStudent(int id);
	

}
