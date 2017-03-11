package whattheactualfact;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Employee
{
	Constants _constants = new Constants();
	
	protected String firstName="";
	protected String lastName="";
	
	protected String middleName="";
	protected String address="";
	protected String workEmailId="";
	
	protected LocalDate dateOfBirth=LocalDate.of(1990,Month.JANUARY,1);
	protected String uniqueId="123456789";// all UIDS 9 Characters DepartmentPosition-XXX-XXXX
	protected int age=0;
	protected String contactNumber="";
	
	
	protected EmployeeProfessional _employee;
	
	/*
	 * personid, work contact id
	 * */
	
	public EmployeeProfessional getEmployee()
	{
			return _employee;
	
	}
	
	public void setEmployee(EmployeeProfessional employee)
	{
		if(_employee!=employee)
		{
			_employee=employee;
		}
	}
	
	public Employee()
	{
		
	}
	
	public Employee(String _firstname, String _lastname, LocalDate _dateofbirth, String _uniqueid, String _contactnumber,LocalDate _joiningdate, String _address, String _workemailid, String _middlename)
	{
		this.firstName=_firstname;
		this.lastName=_lastname;
		this.dateOfBirth=_dateofbirth;
		this.uniqueId=_uniqueid;
		this.contactNumber=_contactnumber;
		this._employee=new EmployeeProfessional(_uniqueid,_joiningdate);
		this.address=_address;
		this.workEmailId=_workemailid;
		this.middleName=_middlename;
	} 

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstname)
	{
		this.firstName = firstname;
	}
	
	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middlename)
	{
		this.middleName = middlename;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastname)
	{
		this.lastName = lastname;
	}
	
	public String getaddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getWorkEmailId()
	{
		return workEmailId;
	}

	public void setWorkEmailId(String workemailid)
	{
		this.workEmailId = workemailid;
	}

	public String getUniqueId()
	{
		return uniqueId;
	}
	
	public void setUniqueId(String uniqueid)
	{
		this.uniqueId = uniqueid;
	}

	public LocalDate getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	

	public String getContactNumber()
	{
		return contactNumber;
	}

	public void setContactNumber(String contactnumber)
	{
		this.contactNumber = contactnumber;
	}

	//Defined by instance variables so no setter
	public int getAge()
	{
		return this.age= Period.between(this.dateOfBirth, _constants.currentDate).getYears();
	}
}

