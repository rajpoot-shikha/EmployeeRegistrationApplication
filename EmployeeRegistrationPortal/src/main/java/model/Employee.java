package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	private int eid;
	private String ename;
	private String email;
	private String eaddr;
	@Column(name = "reporting_mgr_id")
	private int reportingManagerId;
	
	public Employee() {}
		
	public Employee(int eid, String ename, String email, String eaddr, int mgrId) {
		this.eid = eid;
		this.ename = ename;
		this.eaddr = eaddr;		
		this.reportingManagerId = mgrId;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

	public int getReportingManagerId() {
		return reportingManagerId;
	}

	public void setReportingManagerId(int reportingManagerId) {
		this.reportingManagerId = reportingManagerId;
	}
	
	

}
