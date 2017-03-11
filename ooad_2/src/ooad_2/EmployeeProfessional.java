package whattheactualfact;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


public class EmployeeProfessional {
	
	
	private LocalDate joiningDate=LocalDate.of(2000,Month.JANUARY,1);
	private int yearsInCompany=0;
	private CompanyPositions position=null;
	private CompanyDepartments department=null;
	
	Constants _constants= new Constants();
	
	protected enum CompanyPositions
	{
		INTERN,ENTRY_LEVEL,MANAGER
	}
	
	protected enum CompanyDepartments
	{
		HR,RND,MANUFACTURING,SALES
	}
	
	public EmployeeProfessional(String uniqueId, LocalDate _joiningdate)
	{
		this.joiningDate =_joiningdate;
		
		if ((this.joiningDate != null) && (_constants.currentDate != null)) 
		{
			this.yearsInCompany= Period.between(this.joiningDate, _constants.currentDate).getYears();
        }
		if(uniqueId != "")
		{
			switch(uniqueId.charAt(0))
			{
				case '1':
					this.department=CompanyDepartments.HR;
				case '2':
					this.department=CompanyDepartments.MANUFACTURING;
				case '3':
					this.department=CompanyDepartments.SALES;
				case '4':
					this.department=CompanyDepartments.RND;
				default:
					;
			}
			switch(uniqueId.charAt(1))
			{
				case '1':
					this.position=CompanyPositions.INTERN;
				case '2':
					this.position=CompanyPositions.ENTRY_LEVEL;
				case '3':
					this.position=CompanyPositions.MANAGER;
				default:
					;
			}
		}

	}
	public LocalDate getJoiningDate()
	{
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningdate)
	{
		this.joiningDate = joiningdate;
	}
	
	public int getYearsInCompany()
	{
		return yearsInCompany;
	}

	public CompanyPositions getPosition()
	{
		return position;
	}

	public CompanyDepartments getDepartment()
	{
		return department;
	}
}
