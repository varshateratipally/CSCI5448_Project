package industree.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import industree.Common.Constants.ClaimStatus;

@Entity
@Table(name="EmployeeLeave_tbl")
public class EmployeeLeave {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeLeaveId")
	private int employeeLeaveId;
	
	@Column(name = "startDate")
	private Date startDate;
	
	@Column(name = "employeeId")
	private String employeeId;
	
	@Column(name = "endDate")
	private Date endDate;
	
	@Column(name = "appliedDate")
	private Date appliedDate;
	
	@Column(name = "approvedDate")
	private Date approvedDate;
	
	@Column(name = "leaveComment")
	private String leaveComment;
	
	@Column(name = "leaveStatusId")
	private int leaveStatusId;

	@Transient
	private String leaveStatus;

	public int getEmployeeLeaveId() {
		return employeeLeaveId;
	}

	public void setEmployeeLeaveId(int employeeLeaveId) {
		this.employeeLeaveId = employeeLeaveId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getLeaveComment() {
		return leaveComment;
	}

	public void setLeaveComment(String leaveComment) {
		this.leaveComment = leaveComment;
	}

	public int getLeaveStatusId() {
		return leaveStatusId;
	}

	public void setLeaveStatusId(int leaveStatusId) {
		this.leaveStatusId = leaveStatusId;
		this.leaveStatus = ClaimStatus.getClaimStatus(leaveStatusId).toString();
	}
	
	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
		if(ClaimStatus.returnClaimStatusId(leaveStatus) != this.leaveStatusId)
		{
			this.leaveStatusId=ClaimStatus.returnClaimStatusId(leaveStatus);
		}
		if(this.leaveStatus.compareTo("APPROVED")==0)
		{
			this.approvedDate=Calendar.getInstance().getTime();
		}
	}

	public EmployeeLeave(String startDate, String endDate, String leaveComment) throws ParseException
	{
		this.startDate = (Date)new SimpleDateFormat("mm/dd/yyyy").parse(startDate);
		this.endDate = (Date)new SimpleDateFormat("mm/dd/yyyy").parse(endDate);
		this.leaveComment = leaveComment;
		this.appliedDate = Calendar.getInstance().getTime();
		this.leaveStatusId= ClaimStatus.APPLIED.getClaimStatusId();
	
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public EmployeeLeave() {
		// TODO Auto-generated constructor stub
	}
}
