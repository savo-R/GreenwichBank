package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the StudentAccount database table.
 * 
 */
@Entity
@NamedQuery(name="StudentAccount.findAll", query="SELECT s FROM StudentAccount s")
public class StudentAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String alias;

	private int balance;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student;
	
	public StudentAccount(String alias,int balance) {
		super();
		this.alias = alias;
		this.balance = balance;
	}
	
	public StudentAccount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}