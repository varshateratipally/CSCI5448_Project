package industree.Model;


public class HRManager extends Employee{

	public HRManager(int userId, String employeeId, String managerId, String workContactNumber, 
			 String department)
	{
		super(userId, employeeId, null, workContactNumber, department);
		this.setDesignation("HRManager");
		
	}
	
}
