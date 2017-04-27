package industree.Model;

import javax.persistence.*;

import industree.Common.Constants.ClaimStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "EmployeeClaim_tbl")
public class EmployeeClaim {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "employeeClaimId")
		private int employeeClaimId;
		
		@Column(name="claimItemType")
		private String claimItemType;
		
		@Column(name = "employeeId")
		private String employeeId; 
		
		@Column(name = "amount")
		private int amount;

		@Column(name = "purchaseDate")
		private Date purchaseDate;
		
		@Column(name = "appliedDate")
		private Date appliedDate;
		
		@Column(name = "approvedDate")
		private Date approvedDate;
		
		@Column(name="claimStatusId")
		private int claimStatusId;
		
		@Transient
		private String claimStatus;
		
		@Column(name = "claimComment")
		private String claimComment;
		

		public String getClaimStatus() {
			return claimStatus;
		}

		public void setClaimStatus(String claimStatus) {
			this.claimStatus = claimStatus;
			if(ClaimStatus.returnClaimStatusId(claimStatus) != this.claimStatusId)
			{
				this.claimStatusId=ClaimStatus.returnClaimStatusId(claimStatus);
			}
			if(this.claimStatus.compareTo("APPROVED")==0)
			{
				this.approvedDate=Calendar.getInstance().getTime();
			}
			
		}

		public int getEmployeeClaimId() {
			return employeeClaimId;
		}

		public void setEmployeeClaimId(int employeeClaimId) {
			this.employeeClaimId = employeeClaimId;
		}

		public String getClaimItemType() {
			return claimItemType;
		}

		public void setClaimItemType(String claimItemType) {
			this.claimItemType = claimItemType;
		}

		public String getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public Date getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
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

		public int getClaimStatusId() {
			return claimStatusId;
		}

		public void setClaimStatusId(int claimStatusId) {
			this.claimStatusId = claimStatusId;
			this.claimStatus= ClaimStatus.getClaimStatus(claimStatusId).toString();
		}
		public EmployeeClaim() {
			// TODO Auto-generated constructor stub
		}
		
		
		public String getClaimComment() {
			return claimComment;
		}

		public void setClaimComment(String claimComment) {
			this.claimComment = claimComment;
		}

		public EmployeeClaim(String claimItemName, String purchaseDate, int amount, String comment)
		{	
			
			this.claimItemType= claimItemName;
			try {
				this.purchaseDate = (Date)new SimpleDateFormat("mm/dd/yyyy").parse(purchaseDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.amount=amount;
			this.appliedDate = Calendar.getInstance().getTime();
			this.claimComment=comment;
			this.claimStatusId=ClaimStatus.APPLIED.getClaimStatusId();
		}

		
		
}

