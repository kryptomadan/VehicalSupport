package classes;

public class requests 
{

	public String reqid ;
	public String cusid;
	public String name;
	public String email;
	public String phone;
	public String service;
	public String location;
	public String assisted;
	public String assiid;
	public String assiname;
	public String accepted;
	public String completed;
	public requests(String reqid, String cusid, String name, String email, String phone, String service,
			String location, String assisted, String assiid, String assiname, String accepted, String completed) {
		super();
		this.reqid = reqid;
		this.cusid = cusid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.service = service;
		this.location = location;
		this.assisted = assisted;
		this.assiid = assiid;
		this.assiname = assiname;
		this.accepted = accepted;
		this.completed = completed;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getCusid() {
		return cusid;
	}
	public void setCusid(String cusid) {
		this.cusid = cusid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAssisted() {
		return assisted;
	}
	public void setAssisted(String assisted) {
		this.assisted = assisted;
	}
	public String getAssiid() {
		return assiid;
	}
	public void setAssiid(String assiid) {
		this.assiid = assiid;
	}
	public String getAssiname() {
		return assiname;
	}
	public void setAssiname(String assiname) {
		this.assiname = assiname;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	@Override
	public String toString() {
		return "requests [reqid=" + reqid + ", cusid=" + cusid + ", name=" + name + ", email=" + email + ", phone="
				+ phone + ", service=" + service + ", location=" + location + ", assisted=" + assisted + ", assiid="
				+ assiid + ", assiname=" + assiname + ", accepted=" + accepted + ", completed=" + completed + "]";
	}
	
	
	
}
