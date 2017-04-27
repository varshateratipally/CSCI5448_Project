package industree.Model;

import java.util.*;

import industree.Common.Constants.ClaimStatus;

public class EmployeeClaims {
	
	private List<EmployeeClaim> employeeClaims;
	
	private List<String> employeeclaimStatus;
	
	public List<EmployeeClaim> getEmployeeClaims()
	{
		return employeeClaims;
	}
	
	public void setEmployeeClaims(List<EmployeeClaim> employeeClaims)
	{
		this.employeeClaims= employeeClaims;
	}
	
	public EmployeeClaims()
	{
		employeeClaims=new ArrayList<EmployeeClaim>();
		employeeclaimStatus  = new ArrayList<String>();
		
		for(ClaimStatus claimStatus:ClaimStatus.values())
		{
			employeeclaimStatus.add(claimStatus.toString());
		}
	}
	
	
	
}
