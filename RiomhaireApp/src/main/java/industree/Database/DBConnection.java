package industree.Database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import industree.Model.*;

public class DBConnection implements IDBConnection {

	private Session beginSession()
	{
		SessionFactory sessionFactory = HibernateInitializer.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		return session;
	}

	@Override
	public industree.Model.User validateLoginUser(String userName, String password) {
		Session session = beginSession();
		String queried = "from User where username = :username and password = :password";
		Query query = session.createQuery(queried);
		query.setParameter("username", userName);
		query.setParameter("password", password);
		List<User> ls = (List<User>)query.list();
		
		if(ls==null || ls.isEmpty())
		{
			return null;
		}
		return ls.get(0);
		
	}
	
	@Override
	public Employee getEmployeeProfile(int userId){
		
		Session session = beginSession();
		String queried="from Employee e where e.userId = :userId";
		Query query = session.createQuery(queried);
		query.setParameter("userId", userId);
		List<Employee> ls = query.list();
		
		if(ls == null || ls.isEmpty())
		{
			return null;
		}
		session.close();
		return ls.get(0);
		
	}

	@Override
	public WorkingLineStatus getWorkingMachineLineStatus(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeLeaves getEmployeeLeaves(String managerId) {
		EmployeeLeaves employeeLeaves = new EmployeeLeaves();
		List<EmployeeLeave> employeeLeavesList= new ArrayList<EmployeeLeave>();
		Session session = beginSession();
		String queried = "from Employee where managerId = :managerId";
		
		Query query = session.createQuery(queried);
		query.setParameter("managerId", managerId);
		List<Employee> employeeList = query.list();
		if(employeeList == null || employeeList.isEmpty())
		{
			return null;
		}
		for(Employee employee : employeeList)
		{
			query = session.createQuery("from EmployeeLeave where employeeId = :employeeId and leaveStatusId = 1");
			query.setParameter("employeeId", employee.getEmployeeId());
			employeeLeavesList.addAll((List<EmployeeLeave>)query.list());
		}
		employeeLeaves.setEmployeeLeaves(employeeLeavesList);
		return employeeLeaves;
	}

	@Override
	public EmployeeClaims getEmployeeClaims(String managerId) {
		EmployeeClaims employeeClaims = new EmployeeClaims();
		List<EmployeeClaim> employeeClaimsList= new ArrayList<EmployeeClaim>();
		Session session = beginSession();
		String queried = "from Employee where managerId = :managerId";
		
		Query query = session.createQuery(queried);
		query.setParameter("managerId", managerId);
		List<Employee> employeeList = query.list();
		if(employeeList == null || employeeList.isEmpty())
		{
			return null;
		}
		for(Employee employee : employeeList)
		{
			query = session.createQuery("from EmployeeClaim where employeeId = :employeeId and claimStatusId = 1");
			query.setParameter("employeeId", employee.getEmployeeId());
			employeeClaimsList.addAll((List<EmployeeClaim>)query.list());
		}
		employeeClaims.setEmployeeClaims(employeeClaimsList);
		return employeeClaims;
	}

	@Override
	public List<WorkingLineStatus> getWorkingMachineLinesStatuses(String employeeId) {
		Session session = beginSession();
		String queried = "from WorkingLineStatus where employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<WorkingLineStatus> ls = query.list();
		
		return ls;
	}


	@Override
	public void saveEmployeeProfile(Employee employeeProfile) {
		Session session =  beginSession();
		session.save(employeeProfile);
		session.beginTransaction().commit();
		
	}

	@Override
	public void saveAppliedLeave(EmployeeLeave employeeLeave) {
		Notification notification = new Notification(employeeLeave.getEmployeeId(),
				"Your leave for "+ employeeLeave.getStartDate()+ " to "+ employeeLeave.getEndDate()+
				" has been applied on " + employeeLeave.getAppliedDate());
		Session session =  beginSession();
		session.save(employeeLeave);
		session.beginTransaction().commit();
		this.createNotification(notification);
		
	}

	@Override
	public void saveAppliedClaim(EmployeeClaim employeeClaim) {
		Session session =  beginSession();
		session.save(employeeClaim);
		Notification notification = new Notification(employeeClaim.getEmployeeId(),
				"Your claim for "+ employeeClaim.getClaimItemType()+
				" has been applied");
		this.createNotification(notification);
		session.beginTransaction().commit();
	}

	@Override
	public void saveApprovedLeaves(List<EmployeeLeave> employeeLeaves) {
		
		Session session = beginSession();
		for(EmployeeLeave employeeLeave : employeeLeaves)
		{
			
			session.saveOrUpdate(employeeLeave);
			Notification notification = new Notification(employeeLeave.getEmployeeId(),
					"Your leave for "+ employeeLeave.getStartDate()+ " to "+ employeeLeave.getEndDate()+
					" has been approved");
			this.createNotification(notification);
			
		}
		session.beginTransaction().commit();
	}

	@Override
	public void saveApprovedClaims(List<EmployeeClaim> employeeClaims) {
		Session session = beginSession();
		for(EmployeeClaim employeeClaim : employeeClaims)
		{
			session.saveOrUpdate(employeeClaim);
			Notification notification = new Notification(employeeClaim.getEmployeeId(),
					"Your claim for "+ employeeClaim.getClaimItemType()+
					" has been approved");
			this.createNotification(notification);
			
		}
		session.beginTransaction().commit();
		
	}

	@Override
	public List<SearchResults> searchForEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchResults> searchForEmployeeByDepartmentAndName(String firstName, String lastName, String department) {
		
		Session session = beginSession();
		List<SearchResults> searchResults = new ArrayList<SearchResults>();
		String queried = "from User u where u.firstName like :firstParameter and lastName like :lastParameter";
		Query query = session.createQuery(queried);
		query.setParameter("firstParameter", firstName+"%");
		query.setParameter("lastParameter", lastName+"%");
		
		List<User> users = (List<User>)query.list();
		if(users!=null)
		{
		session.close();
		List<Integer> ids = new ArrayList<Integer>();
		for(User user:users)
		{
			ids.add(user.getUserId());
		}
		Employee employee= new Employee();
		List<Employee> employees= this.getEmployeeFromUserIds(ids, department);
		SearchResults searchResult;
		String name="";
		
		for(User user1:users)
		{
			name = user1.getFirstName().concat(" ");
			name = name.concat(user1.getLastName());
			for(Employee employeeLoop:employees)
			{
				if(employeeLoop.getUserId() == user1.getUserId())
				{
					employee = employeeLoop;
					searchResult = new SearchResults(name, employee.getWorkContact(), employee.getDepartment(), employee.getDesignation()
							, employee.getDateOfJoining(), user1.getEmailAddress());
					searchResults.add(searchResult);
					break;
				}
			}
			
		}
		}
		return searchResults;
	}
	
	private List<Employee> getEmployeeFromUserIds(List<Integer> ids, String department)
	{
		Session session = beginSession();
		String queried ;
		Query query = null;
		List<Employee> employees = new ArrayList<Employee>();
		
		if(ids!=null && department!= null){
		if(ids.size() == 0){
			employees = new ArrayList<Employee>();
		}
		else{
		if(department.isEmpty())
		{
			queried = "from Employee e where e.userId in :ids ";
			query =  session.createQuery(queried);
			query.setParameter("ids", ids);
		}
		else
		{
			queried="from Employee e where department = :department and e.userId in :ids ";
			query =  session.createQuery(queried);
			query.setParameter("department", department);
			query.setParameter("ids", ids);
			
		}
		}
		}
		if(query!=null){
		employees= query.list();
		}
		session.close();
		return employees;
	}
	
	@Override
	public User saveUser(User user)
	{

		Session session = beginSession();
		session.save(user);
		session.beginTransaction().commit();
		
		return this.validateLoginUser(user.getUserName(), user.getPassword());
	}
	
	@Override
	public List<Notification> getNotifications(String employeeId)
	{
		Session session = beginSession();
		String queried="from Notification e where e.employeeId = :employeeId";
		Query query = session.createQuery(queried);
		query.setParameter("employeeId", employeeId);
		List<Notification> ls = query.list();
		
		if(ls == null || ls.isEmpty())
		{
			return null;
		}
		session.close();
		return ls;
		
	}
	
	@Override
	public void updateUser(User user)
	{
		Session session = beginSession();
		session.saveOrUpdate(user);
		session.beginTransaction().commit();
		
	}
	
	public void updateEmployee(Employee employee)
	{
		Session session = beginSession();
		session.saveOrUpdate(employee);
		session.beginTransaction().commit();
		
	}
	
	private void createNotification(Notification notification)
	{
		
		Session session = beginSession();
		session.save(notification);
		session.beginTransaction().commit();
	}
	
	
}
