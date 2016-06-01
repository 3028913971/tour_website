package cn.cua.action;


import java.io.UnsupportedEncodingException;
import cn.cua.domain.AdminInfo;
import cn.cua.service.AdminException;
import cn.cua.service.AdminService;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class AdminAction extends ActionSupport implements ModelDriven<AdminInfo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminService adminService = new AdminService();
	private AdminInfo model = new AdminInfo();//�ֶ�ʵ����

	
	private int pageNum;
	private int totalpage;
	private int pageSize;
	
	private String qadminNumber;
	private String qadminName;
	private String qadminSex;
	private String qadminDepartment;
	private String qadminRole;
	
	public String getQadminNumber() {
		return qadminNumber;
	}
	public void setQadminNumber(String qadminNumber) {
		this.qadminNumber = qadminNumber;
	}
	
	public String getQadminName() {
		return qadminName;
	}
	public void setQadminName(String qadminName) {
		this.qadminName = qadminName;
	}
	
	public String getQadminDepartment() {
		return qadminDepartment;
	}
	public void setQadminDepartment(String qadminDepartment) {
		this.qadminDepartment = qadminDepartment;
	}
	
	public String getQadminSex() {
		return qadminSex;
	}
	public void setQadminSex(String qadminSex) {
		this.qadminSex = qadminSex;
	}
	
	public String getQadminRole() {
		return qadminRole;
	}
	public void setQadminRole(String qadminRole) {
		this.qadminRole = qadminRole;
	}
	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��¼����
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="login")
	public String login() throws Exception{

		/**
		 * model�Ѿ���װ�˱����ݣ�adminName��adminPassword
		 * 1.ʹ��adminName��adminPassword������service��login��������
		 * 2.�������admin����˵����½�ɹ�����user���浽session�У�����success
		 * 3.����׳����쳣����ȡ�쳣��Ϣ����ӵ�actionerrors�У�����error
		 */
			//AdminInfo admin = adminService.login(model.getAdminName(), model.getAdminPassword());
			//ActionContext.getContext().getSession().put("admin", admin);
		try{
			AdminInfo admin = adminService.login(model.getLoginName(), model.getAdminPassword());
			ActionContext.getContext().getSession().put("admin", admin);
			return "loginSucc";
		}catch(AdminException e){
			this.addActionError(e.getMessage());
			return LOGIN;
		}
	}
	/**
	 * ��ѯ���й���Ա�ķ�ҳ����
	 * @return
	 */
	public String page(){
		pageSize = 30;
		int userAmount = adminService.getAdminAmount();
		if(userAmount==0){
			return "pageFailed";
		}
		

		this.totalpage = userAmount%pageSize==0?(userAmount/pageSize):(userAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "page";
	}
	
	/**
	 * ��ѯ���й���Ա
	 * @return
	 */
	public String findAll(){
		ActionContext.getContext().getValueStack().push(adminService.findAll(pageNum, pageSize));
		return "list";
	}
	
	/**
	 * ���ӹ���Ա��Ϣ
	 * @return
	 * @throws AdminException 
	 */
	public String add() throws AdminException{
		
		try {		
			adminService.add(model);
			
			
			return "pageSucc";
		} catch (AdminException e) {
			String message = e.getMessage();
			if("1".equals(message)){
				this.addFieldError("adminNumberError", "����Ա����Ѵ��ڣ��������ţ�");
			}else if("2".equals(message)){
				this.addFieldError("loginNameError", "��¼���Ѵ��ڣ��������¼����");
			}else{
				this.addFieldError("adminNumberError", "����Ա����Ѵ��ڣ��������ţ�");
				this.addFieldError("loginNameError", "��¼���Ѵ��ڣ��������¼����");
			}
			return "add";
		}
		
	}
	
	/**
	 * �޸���Ϣ֮ǰ�ļ��ز���
	 * ����װ��model����Ϣ��ӵ���ҳ���valueStack��ȥ
	 * @return
	 */
	public String loadForEdit(){
		ActionContext.getContext().getValueStack().push(adminService.load(model.getAdminId()));
		return "edit";
	}
	
	/**
	 * �޸Ĳ�������Ҫ����Ĭ�ϵ�adminId��ҳ��������
	 * @return
	 */
	public String edit(){
		
		try {		
			adminService.edit(model);
			return "pageSucc";
		} catch (AdminException e) {
			String message = e.getMessage();
			if("1".equals(message)){
				this.addFieldError("adminNumberError", "����Ա����Ѵ��ڣ��������ţ�");
			}else if("2".equals(message)){
				this.addFieldError("loginNameError", "��¼���Ѵ��ڣ��������¼����");
			}else{
				this.addFieldError("adminNumberError", "����Ա����Ѵ��ڣ��������ţ�");
				this.addFieldError("loginNameError", "��¼���Ѵ��ڣ��������¼����");
			}
			return "edit";
		}		
	}
	
	/**
	 * �鿴����Ա��Ϣ
	 * @return
	 */
	public String load(){
		ActionContext.getContext().getValueStack().push(adminService.load(model.getAdminId()));
		return "view";
	}
	
	public String delete(){
		adminService.delete(model.getAdminId());
		return "pageSucc";
	}
	
	/**
	 * ������ѯ��ҳ����
	 * @return
	 */
	public String pageQuery(){
		pageSize = 30;		
		int userAmount = adminService.getQueryAmount(model);
		model.setAdminNumber(qadminNumber);
		model.setAdminName(qadminName);
		model.setAdminSex(qadminSex);
		model.setAdminDepartment(qadminDepartment);
		model.setAdminRole(qadminRole);
		this.totalpage = userAmount%pageSize==0?(userAmount/pageSize):(userAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuery";
	}
	
	/**
	 * ������ѯ��ҳ����
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageQuery1() throws UnsupportedEncodingException{
		pageSize = 30;
		qadminNumber = new String(this.qadminNumber.getBytes("ISO-8859-1"),"UTF-8");
		qadminName = new String(this.qadminName.getBytes("ISO-8859-1"),"UTF-8");
		qadminSex = new String(this.qadminSex.getBytes("ISO-8859-1"),"UTF-8");
		qadminDepartment = new String(this.qadminDepartment.getBytes("ISO-8859-1"),"UTF-8");
		qadminRole = new String(this.qadminRole.getBytes("ISO-8859-1"),"UTF-8");
		model.setAdminNumber(qadminNumber);
		model.setAdminName(qadminName);
		model.setAdminSex(qadminSex);
		model.setAdminDepartment(qadminDepartment);
		model.setAdminRole(qadminRole);
		int userAmount = adminService.getQueryAmount(model);
		this.totalpage = userAmount%pageSize==0?(userAmount/pageSize):(userAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuery";
	}
	
	public String query() throws UnsupportedEncodingException{
		qadminNumber = new String(this.qadminNumber.getBytes("ISO-8859-1"),"UTF-8");
		qadminName = new String(this.qadminName.getBytes("ISO-8859-1"),"UTF-8");
		qadminSex = new String(this.qadminSex.getBytes("ISO-8859-1"),"UTF-8");
		qadminDepartment = new String(this.qadminDepartment.getBytes("ISO-8859-1"),"UTF-8");
		qadminRole = new String(this.qadminRole.getBytes("ISO-8859-1"),"UTF-8");
		model.setAdminNumber(qadminNumber);
		model.setAdminName(qadminName);
		model.setAdminSex(qadminSex);
		model.setAdminDepartment(qadminDepartment);
		model.setAdminRole(qadminRole);
		ActionContext.getContext().getValueStack().push(adminService.query(model, pageNum, pageSize));
		return "listQuery";
	}
	
	public AdminInfo getModel() {
		return model;
	}
}
