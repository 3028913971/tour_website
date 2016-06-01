package cn.cua.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.cua.domain.AdminInfo;
import cn.cua.log4j.LogControler;
import cn.cua.utils.HibernateUtils;

/**
 * 管理员信息表
 * @author LI AO
 *
 */
public class AdminInfoDAO {
	
	@Test
	public AdminInfo load(int adminId){
		//通过id查找操作
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		//int id=adminId;
		AdminInfo adminInfo = (AdminInfo) session.get(AdminInfo.class,adminId);
		
		

		transaction.commit();
		session.close();
		return adminInfo;
	}
	
	public int getAdminAmount(){
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from AdminInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<AdminInfo> adminInfos = query.list();	//执行查询		
			
			transaction.commit();
			session.close();
			return adminInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<AdminInfo> findAll(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from AdminInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<AdminInfo> adminInfos = query.list();	//执行查询		
		
		for(AdminInfo adminInfo : adminInfos){
		}
		
		
		transaction.commit();
		session.close();
		return adminInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	//@Test
	public List<AdminInfo> findByadminName(String loginName){
		
			try{
				//通过管理员登录名查找操作
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 
			

				String hql="from AdminInfo where loginName='"+loginName+"'";
				List<AdminInfo> list = this.adminInfoFindByHQL(hql);
				Query query = session.createQuery(hql);	//获得query对象
				List<AdminInfo> admin = query.list();
				
				transaction.commit();
				session.close();
				return admin;
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			
		}
	
	public List<AdminInfo> findByadminNumber(String adminNumber){
		
		try{
			//通过管理员编号查找操作
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
		

			String hql="from AdminInfo where adminNumber='"+adminNumber+"'";
			List<AdminInfo> list = this.adminInfoFindByHQL(hql);
			Query query = session.createQuery(hql);	//获得query对象
			List<AdminInfo> admin = query.list();
			
			transaction.commit();
			session.close();
			return admin;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	@Test
	public List<AdminInfo> adminInfoFindByHQL(String hql){
		//通过HQL查找操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
	

		Query query = session.createQuery(hql);	//获得query对象

		List<AdminInfo> adminInfos = query.list();	//执行查询		

		transaction.commit();
		session.close();
		return adminInfos;
	}
	

	public void add(AdminInfo admin){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(admin);
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void delete(int adminId){
		//删除操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		AdminInfo adminInfo = new AdminInfo();
		adminInfo.setAdminId(adminId);
		session.delete(adminInfo);		
		transaction.commit();
		session.close();
	}
	@Test
	public void edit(AdminInfo admin){
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(admin);
		transaction.commit();
		session.close();
	}


	public int getQueryAmount(AdminInfo adminInfo){
		//组合查询	
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			Criteria criteria = session.createCriteria(AdminInfo.class);
			
			String adminNumber = adminInfo.getAdminNumber();
			//判断adminNumber这个条件是否存在
			if(adminNumber != null && !adminNumber.trim().isEmpty()){
				criteria.add(Restrictions.eq("adminNumber", adminNumber));
			}
			
			String adminName = adminInfo.getAdminName();
			//判断adminName这个条件是否存在
			if(adminName != null && !adminName.trim().isEmpty()){
				criteria.add(Restrictions.eq("adminName", adminName));
			}
			
			String adminSex = adminInfo.getAdminSex();
			//判断adminSex这个条件是否存在
			if(adminSex != null && !adminSex.trim().isEmpty()){
				criteria.add(Restrictions.eq("adminSex", adminSex));
			}
			
			String adminDepartment = adminInfo.getAdminDepartment();
			//判断adminDepartment这个条件是否存在
			if(adminDepartment != null && !adminDepartment.trim().isEmpty()){
				criteria.add(Restrictions.eq("adminDepartment", adminDepartment));
			}
			
			String adminRole = adminInfo.getAdminRole();
			//判断adminRole这个条件是否存在
			if(adminRole != null && !adminRole.trim().isEmpty()){
				criteria.add(Restrictions.eq("adminRole", adminRole));
			}
			
			List<AdminInfo> adminInfos = criteria.list();
			
			
			for(int i=0;i<adminInfos.size();i++){
			}
			
			transaction.commit();
			session.close();
			
			return adminInfos.size();
	}

	@Test
	public List<AdminInfo> query(AdminInfo adminInfo,int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(AdminInfo.class);
		
		String adminNumber = adminInfo.getAdminNumber();
		//判断adminNumber这个条件是否存在
		if(adminNumber != null && !adminNumber.trim().isEmpty()){
			criteria.add(Restrictions.eq("adminNumber", adminNumber));
		}
		
		String adminName = adminInfo.getAdminName();
		//判断adminName这个条件是否存在
		if(adminName != null && !adminName.trim().isEmpty()){
			criteria.add(Restrictions.eq("adminName", adminName));
		}
		
		String adminSex = adminInfo.getAdminSex();
		//判断adminSex这个条件是否存在
		if(adminSex != null && !adminSex.trim().isEmpty()){
			criteria.add(Restrictions.eq("adminSex", adminSex));
		}
		
		String adminDepartment = adminInfo.getAdminDepartment();
		//判断adminDepartment这个条件是否存在
		if(adminDepartment != null && !adminDepartment.trim().isEmpty()){
			criteria.add(Restrictions.eq("adminDepartment", adminDepartment));
		}
		
		String adminRole = adminInfo.getAdminRole();
		//判断adminRole这个条件是否存在
		
		if(adminRole != null && !adminRole.trim().isEmpty()){
			criteria.add(Restrictions.eq("adminRole", adminRole));
		}
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<AdminInfo> adminInfos = criteria.list();
		
		
		for(int i=0;i<adminInfos.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return adminInfos;
	}
}
