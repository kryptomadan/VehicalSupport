package classes;

public class completedrequests {

	public String reqid;
	public String custname;
	public String assisttype;
	public String cusphone;
	public String amtpaid;
	public String empname;
	public String empid;
	public String feedback;
	public completedrequests(String reqid, String custname, String assisttype, String cusphone, String amtpaid,
			String empname, String empid, String feedback) {
		super();
		this.reqid = reqid;
		this.custname = custname;
		this.assisttype = assisttype;
		this.cusphone = cusphone;
		this.amtpaid = amtpaid;
		this.empname = empname;
		this.empid = empid;
		this.feedback = feedback;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getAssisttype() {
		return assisttype;
	}
	public void setAssisttype(String assisttype) {
		this.assisttype = assisttype;
	}
	public String getCusphone() {
		return cusphone;
	}
	public void setCusphone(String cusphone) {
		this.cusphone = cusphone;
	}
	public String getAmtpaid() {
		return amtpaid;
	}
	public void setAmtpaid(String amtpaid) {
		this.amtpaid = amtpaid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "completedrequests [reqid=" + reqid + ", custname=" + custname + ", assisttype=" + assisttype
				+ ", cusphone=" + cusphone + ", amtpaid=" + amtpaid + ", empname=" + empname + ", empid=" + empid
				+ ", feedback=" + feedback + "]";
	}
	
	
	
}
