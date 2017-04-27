package industree.Model;
import java.util.*;

import javax.persistence.*;


@Entity
@Table(name="Employee_tbl")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Employee {

	@Id
	@Column(name="employeeId")
	private String employeeId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="dateOfJoining")
	private Date dateOfJoining;
	
	@Column(name="workContact")
	private String workContact;
	
	@Column(name="department")
	private String department;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name="managerId")
	private String managerId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getWorkContact() {
		return workContact;
	}
	public void setWorkContact(String workContact) {
		this.workContact = workContact;
	}
	
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	public Employee()
	{
		
	}
	
	public Employee(int userId, String employeeId, String managerId, String workContactNumber, 
			 String department)
	{
		this.userId = userId;
		this.employeeId = employeeId;
		this.managerId =managerId;
		this.workContact = workContactNumber;
		this.dateOfJoining = Calendar.getInstance().getTime();
		this.department = department;
		this.setDesignation("FactoryEmployee");
		
	}
	
}
