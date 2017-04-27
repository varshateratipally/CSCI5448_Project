package industree.Model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import industree.Common.Constants.UserRoles;

@Entity
@Table(name="User_tbl")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="middleName")
	private String middleName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="emailAddress")
	private String emailAddress;
	
	@Column(name="userRoleId")
	private int userRoleId;
	
	@Transient
	private UserRoles userRole;
	
	@Column(name="address")
	private String address;
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserRoles getUserRole(){
		return userRole;
	}
	
	
	public int getUserRoleId(){
		return userRoleId;
	}
	
	public void setUserRoleId(int userRoleId)
	{
		this.userRoleId=userRoleId;
		this.userRole = (UserRoles.getUserRole(userRoleId));
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public User(String firstName, String middleName, String lastName, String emailAddress,Date dateOfBirth,
			String userName, String password, int userRoleId, String address)
	{
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.emailAddress=emailAddress;
		this.dateOfBirth = dateOfBirth;
		this.userName=userName;
		this.userRoleId= userRoleId;
		this.userRole=UserRoles.getUserRole(userRoleId);
		this.password=password;
		this.address = address;
	}

	public User() {
		this.setUserRole(UserRoles.FACTORY_EMPLOYEE);
	}

	public void setUserRole(UserRoles userRole) {
		this.userRole = userRole;
		this.userRoleId = userRole.getUserRoleId();
	}
	
	
}
