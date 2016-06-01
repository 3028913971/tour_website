package cn.cua.domain;
/**
 * 管理员信息表
 * @author LI AO
 *
 */
public class AdminInfo {

	private int adminId;//管理员编号
	private String adminNumber;//管理员工号
	private String loginName;//登陆名
	private String adminName;//管理员姓名
	private String adminPassword;//管理员密码
	private String adminDepartment;//管理员所属部门
	private String adminSex;//管理员性别
	private String adminMail;//管理员邮箱
	private String adminPhoneNumber;//管理员电话
	private String adminRole;//管理员等级
	
	
	
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminInfo(int adminId, String adminNumber, String loginName,
			String adminName, String adminPassword, String adminDepartment,
			String adminSex, String adminMail, String adminPhoneNumber,
			String adminRole) {
		super();
		this.adminId = adminId;
		this.adminNumber = adminNumber;
		this.loginName = loginName;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminDepartment = adminDepartment;
		this.adminSex = adminSex;
		this.adminMail = adminMail;
		this.adminPhoneNumber = adminPhoneNumber;
		this.adminRole = adminRole;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(String adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminDepartment() {
		return adminDepartment;
	}
	public void setAdminDepartment(String adminDepartment) {
		this.adminDepartment = adminDepartment;
	}
	public String getAdminSex() {
		return adminSex;
	}
	public void setAdminSex(String adminSex) {
		this.adminSex = adminSex;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}
	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}
	public String getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminNumber=" + adminNumber
				+ ", loginName=" + loginName + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + ", adminDepartment="
				+ adminDepartment + ", adminSex=" + adminSex + ", adminMail="
				+ adminMail + ", adminPhoneNumber=" + adminPhoneNumber
				+ ", adminRole=" + adminRole + "]";
	}
	
	
	

	
}
