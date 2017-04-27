package industree.Database;

import java.util.List;

import industree.Model.*;


public interface IDBConnection {

	public User validateLoginUser(String userName, String password);
	public Employee getEmployeeProfile(int userId);
	public WorkingLineStatus getWorkingMachineLineStatus(int userId);
	public EmployeeLeaves getEmployeeLeaves(String managerId);
	public EmployeeClaims getEmployeeClaims(String managerId);
	public List<WorkingLineStatus> getWorkingMachineLinesStatuses(String employeeId);
	public void saveEmployeeProfile(Employee employeeProfile);
	public void saveAppliedLeave(EmployeeLeave employeeLeave);
	public void saveAppliedClaim(EmployeeClaim employeeClaim);
	public void saveApprovedLeaves(List<EmployeeLeave> employeeLeaves);
	public void saveApprovedClaims(List<EmployeeClaim> employeeClaims);
	public List<SearchResults> searchForEmployeeByName(String name);
	public List<SearchResults> searchForEmployeeByDepartmentAndName(String firstName, String lastName, String Department);
	public List<Notification> getNotifications(String employeeId);
	public User saveUser(User user);
	public void updateUser(User user);
	public void updateEmployee(Employee employee);
}
