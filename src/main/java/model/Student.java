package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the Student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String name;

	private String postalAddress;

	private String telephone;

	//bi-directional many-to-one association to StudentAccount
	@OneToMany(mappedBy="student")
	private List<StudentAccount> studentAccounts;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalAddress() {
		return this.postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<StudentAccount> getStudentAccounts() {
		return this.studentAccounts;
	}

	public void setStudentAccounts(List<StudentAccount> studentAccounts) {
		this.studentAccounts = studentAccounts;
	}

	public StudentAccount addStudentAccount(StudentAccount studentAccount) {
		getStudentAccounts().add(studentAccount);
		studentAccount.setStudent(this);

		return studentAccount;
	}

	public StudentAccount removeStudentAccount(StudentAccount studentAccount) {
		getStudentAccounts().remove(studentAccount);
		studentAccount.setStudent(null);

		return studentAccount;
	}

	public Student( String name, String postalAddress, String email, String telephone) {
		super();
		this.name = name;
		this.postalAddress = postalAddress;
		this.email = email;
		this.telephone = telephone;
		this.studentAccounts = new ArrayList<StudentAccount>();
	}

}