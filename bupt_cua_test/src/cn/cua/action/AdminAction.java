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
	private AdminInfo model = new AdminInfo();//手动实例化

	
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
	 * 登录功能
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="login")
	public String login() throws Exception{

		/**
		 * model已经封装了表单数据：adminName，adminPassword
		 * 1.使用adminName和adminPassword来调用service的login（）方法
		 * 2.如果返回admin对象，说明登陆成功，把user保存到session中，返回success
		 * 3.如果抛出了异常，获取异常信息，添加到actionerrors中，返回error
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
	 * 查询所有管理员的分页操作
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
	 * 查询所有管理员
	 * @return
	 */
	public String findAll(){
		ActionContext.getContext().getValueStack().push(adminService.findAll(pageNum, pageSize));
		return "list";
	}
	
	/**
	 * 增加管理员信息
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
				this.addFieldError("adminNumberError", "管理员编号已存在，请更换编号！");
			}else if("2".equals(message)){
				this.addFieldError("loginNameError", "登录名已存在，请更换登录名！");
			}else{
				this.addFieldError("adminNumberError", "管理员编号已存在，请更换编号！");
				this.addFieldError("loginNameError", "登录名已存在，请更换登录名！");
			}
			return "add";
		}
		
	}
	
	/**
	 * 修改信息之前的加载操作
	 * 将封装的model的信息添加到新页面的valueStack中去
	 * @return
	 */
	public String loadForEdit(){
		ActionContext.getContext().getValueStack().push(adminService.load(model.getAdminId()));
		return "edit";
	}
	
	/**
	 * 修改操作，需要设置默认的adminId在页面隐藏域
	 * @return
	 */
	public String edit(){
		
		try {		
			adminService.edit(model);
			return "pageSucc";
		} catch (AdminException e) {
			String message = e.getMessage();
			if("1".equals(message)){
				this.addFieldError("adminNumberError", "管理员编号已存在，请更换编号！");
			}else if("2".equals(message)){
				this.addFieldError("loginNameError", "登录名已存在，请更换登录名！");
			}else{
				this.addFieldError("adminNumberError", "管理员编号已存在，请更换编号！");
				this.addFieldError("loginNameError", "登录名已存在，请更换登录名！");
			}
			return "edit";
		}		
	}
	
	/**
	 * 查看管理员信息
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
	 * 条件查询分页操作
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
	 * 条件查询分页操作
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
