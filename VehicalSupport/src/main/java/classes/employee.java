package classes;

public class employee {

	public String empid;
	public String empname;
	public String phone;
	public String service;
	public String onduty;
	public employee(String empid, String empname, String phone, String service, String onduty) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.phone = phone;
		this.service = service;
		this.onduty = onduty;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getOnduty() {
		return onduty;
	}
	public void setOnduty(String onduty) {
		this.onduty = onduty;
	}
	@Override
	public String toString() {
		return "employee [empid=" + empid + ", empname=" + empname + ", phone=" + phone + ", service=" + service
				+ ", onduty=" + onduty + "]";
	}
	
}
