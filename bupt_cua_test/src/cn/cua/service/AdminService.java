package cn.cua.service;


import java.util.List;

import cn.cua.dao.AdminInfoDAO;
import cn.cua.domain.AdminInfo;

public class AdminService {
	private AdminInfoDAO adminDao = new AdminInfoDAO();
	
	/**
	 * ��¼����
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws AdminException
	 */
	public AdminInfo login(String loginName,String adminPassword) throws AdminException{
		/**
		 * 1.ͨ���û��������û�
		 */
		List<AdminInfo> adminList = adminDao.findByadminName(loginName);
		
		/**
		 * 2.�ж�admin�Ƿ���ڣ���������ڣ��׳��쳣
		 */
		if(adminList.size() == 0){
			throw new AdminException("�û���������");
		}
/*		if(admin == null){
			throw new AdminException("�û���������");
		}*/
		
		/**
		 * 3.���admin���ڣ���ʹ�ò���adminPassword�����ѯ����admin����adminPassword�Ƚ�
		 * 4.�����ͬ��˵����½�ɹ�������admin����
		 * 5.�����ͬ��˵����������׳��쳣
		 */
		AdminInfo admin = adminList.get(0);
		if(adminPassword.equals(admin.getAdminPassword())){
			return admin;
		}else{
			throw new AdminException("�������");
		}
	}
	
	/**
	 * ��ҳ�������õ�����Ա����
	 * @return
	 */
	public int getAdminAmount(){
		return adminDao.getAdminAmount();
	}
	
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<AdminInfo> findAll(int pageNum,int pageSize){
		return adminDao.findAll(pageNum, pageSize);
	}
	
	/**
	 * ���ӹ���Ա��Ϣ
	 * @param admin
	 * @throws AdminException 
	 */
	public void add(AdminInfo admin) throws AdminException{
		
		List<AdminInfo> adminList = adminDao.findByadminName(admin.getLoginName());
		List<AdminInfo> adminNumberList = adminDao.findByadminNumber(admin.getAdminNumber());
		String message = null;
		if(adminNumberList.size() != 0){
			message = "1";//"����Ա����Ѵ��ڣ��������ţ�";
		}
		if (adminList.size() != 0) {
			if(message != null){
				message = "3";//"#��¼���Ѵ��ڣ��������¼����" ;
			}else{
				message = "2";//"��¼���Ѵ��ڣ��������¼����" ;
			}
		}
		if (message!=null)
			throw new AdminException(message);
		adminDao.add(admin);
	}
	
	/**
	 *  �޸Ĺ��ܵļ��ز���
	 * @param adminId
	 * @return
	 */
	public AdminInfo load(int adminId){
		return adminDao.load(adminId);
	}
	
	/**
	 * �޸Ĳ���
	 * @param admin
	 * @throws AdminException 
	 */
	public void edit(AdminInfo admin) throws AdminException{
		
		List<AdminInfo> adminList = adminDao.findByadminName(admin.getLoginName());
		List<AdminInfo> adminNumberList = adminDao.findByadminNumber(admin.getAdminNumber());
		String message = null;
		if(adminNumberList.size() != 0 && adminNumberList.get(0).getAdminId() != admin.getAdminId()){
			message = "1";//"����Ա����Ѵ��ڣ��������ţ�";
			//throw new AdminException("����Ա����Ѵ��ڣ��������ţ�");
		}
		if (adminList.size() != 0 && adminList.get(0).getAdminId() != admin.getAdminId()) {
			if(message != null){
				message = "3";//"#��¼���Ѵ��ڣ��������¼����" ;
			}else{
				message = "2";//"��¼���Ѵ��ڣ��������¼����" ;
			}
		}
		if (message!=null)
			throw new AdminException(message);
		adminDao.edit(admin);
		
	}
	/**
	 * ɾ������
	 * @param adminId
	 */
	public void delete(int adminId){
		adminDao.delete(adminId);
	}
	
	/**
	 * ��ϲ�ѯ��ҳ�������õ�����Ա����
	 * @return
	 */
	public int getQueryAmount(AdminInfo adminInfo){
		return adminDao.getQueryAmount(adminInfo);
	}
	
	/**
	 * ��ϲ�ѯ����
	 * @param adminInfo
	 * @return
	 */
	public List<AdminInfo> query(AdminInfo adminInfo,int pageNum,int pageSize){
		return adminDao.query(adminInfo, pageNum, pageSize);
	}
	

}
