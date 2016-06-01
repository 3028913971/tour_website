package cn.cua.service;


import java.util.List;

import cn.cua.dao.AdminInfoDAO;
import cn.cua.domain.AdminInfo;

public class AdminService {
	private AdminInfoDAO adminDao = new AdminInfoDAO();
	
	/**
	 * 登录功能
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws AdminException
	 */
	public AdminInfo login(String loginName,String adminPassword) throws AdminException{
		/**
		 * 1.通过用户名查找用户
		 */
		List<AdminInfo> adminList = adminDao.findByadminName(loginName);
		
		/**
		 * 2.判断admin是否存在，如果不存在，抛出异常
		 */
		if(adminList.size() == 0){
			throw new AdminException("用户名不存在");
		}
/*		if(admin == null){
			throw new AdminException("用户名不存在");
		}*/
		
		/**
		 * 3.如果admin存在，再使用参数adminPassword，与查询到的admin的我adminPassword比较
		 * 4.如果相同，说明登陆成功，返回admin对象
		 * 5.如果不同，说明密码错误，抛出异常
		 */
		AdminInfo admin = adminList.get(0);
		if(adminPassword.equals(admin.getAdminPassword())){
			return admin;
		}else{
			throw new AdminException("密码错误");
		}
	}
	
	/**
	 * 分页操作，得到管理员总数
	 * @return
	 */
	public int getAdminAmount(){
		return adminDao.getAdminAmount();
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<AdminInfo> findAll(int pageNum,int pageSize){
		return adminDao.findAll(pageNum, pageSize);
	}
	
	/**
	 * 增加管理员信息
	 * @param admin
	 * @throws AdminException 
	 */
	public void add(AdminInfo admin) throws AdminException{
		
		List<AdminInfo> adminList = adminDao.findByadminName(admin.getLoginName());
		List<AdminInfo> adminNumberList = adminDao.findByadminNumber(admin.getAdminNumber());
		String message = null;
		if(adminNumberList.size() != 0){
			message = "1";//"管理员编号已存在，请更换编号！";
		}
		if (adminList.size() != 0) {
			if(message != null){
				message = "3";//"#登录名已存在，请更换登录名！" ;
			}else{
				message = "2";//"登录名已存在，请更换登录名！" ;
			}
		}
		if (message!=null)
			throw new AdminException(message);
		adminDao.add(admin);
	}
	
	/**
	 *  修改功能的加载操作
	 * @param adminId
	 * @return
	 */
	public AdminInfo load(int adminId){
		return adminDao.load(adminId);
	}
	
	/**
	 * 修改操作
	 * @param admin
	 * @throws AdminException 
	 */
	public void edit(AdminInfo admin) throws AdminException{
		
		List<AdminInfo> adminList = adminDao.findByadminName(admin.getLoginName());
		List<AdminInfo> adminNumberList = adminDao.findByadminNumber(admin.getAdminNumber());
		String message = null;
		if(adminNumberList.size() != 0 && adminNumberList.get(0).getAdminId() != admin.getAdminId()){
			message = "1";//"管理员编号已存在，请更换编号！";
			//throw new AdminException("管理员编号已存在，请更换编号！");
		}
		if (adminList.size() != 0 && adminList.get(0).getAdminId() != admin.getAdminId()) {
			if(message != null){
				message = "3";//"#登录名已存在，请更换登录名！" ;
			}else{
				message = "2";//"登录名已存在，请更换登录名！" ;
			}
		}
		if (message!=null)
			throw new AdminException(message);
		adminDao.edit(admin);
		
	}
	/**
	 * 删除操作
	 * @param adminId
	 */
	public void delete(int adminId){
		adminDao.delete(adminId);
	}
	
	/**
	 * 组合查询分页操作，得到管理员总数
	 * @return
	 */
	public int getQueryAmount(AdminInfo adminInfo){
		return adminDao.getQueryAmount(adminInfo);
	}
	
	/**
	 * 组合查询功能
	 * @param adminInfo
	 * @return
	 */
	public List<AdminInfo> query(AdminInfo adminInfo,int pageNum,int pageSize){
		return adminDao.query(adminInfo, pageNum, pageSize);
	}
	

}
