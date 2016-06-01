package cn.cua.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class ThemeInfoDAO {

	public List<ThemeInfo> findAll(){
		//ͨ��HQL���Ҳ���
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from ThemeInfo";
		Query query = session.createQuery(hql);	//���query����
		
		List<ThemeInfo> themeInfos = query.list();	//ִ�в�ѯ		
				
		transaction.commit();
		session.close();
		return themeInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public ThemeInfo load(int themeId){
		//ͨ��id���Ҳ���
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		//int id=adminId;
		ThemeInfo themeInfo = (ThemeInfo) session.get(ThemeInfo.class,themeId);
		
		transaction.commit();
		session.close();
		return themeInfo;
	}
	
	public void add(ThemeInfo themeInfo){
		//���Ӳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(themeInfo);
		transaction.commit();
		session.close();
	}
	
	public void delete(int themeId){
		//ɾ������
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction(); 
		ThemeInfo themeInfoTmp = (ThemeInfo) session1.get(ThemeInfo.class,themeId);
		transaction1.commit();
		session1.close();
		
		Session session2 = HibernateUtils.openSession();
		Transaction transaction2 = session2.beginTransaction();
		ThemeInfo themeInfo = new ThemeInfo();
		themeInfo.setThemeId(themeId);
		session2.delete(themeInfo);
		transaction2.commit();
		session2.close();
		
		//ɾ�����б��и�����
		Session session3 = HibernateUtils.openSession();
		Transaction transaction3 = session3.beginTransaction();
		String hql="from TravelDestinationInfo";
		Query query = session3.createQuery(hql);	//���query����
		
		List<TravelDestinationInfo> tdInfos = query.list();	//ִ�в�ѯ
		transaction3.commit();
		session3.close();
		
		Session session4 = HibernateUtils.openSession();
		Transaction transaction4 = session4.beginTransaction();
		for(int i=0;i<tdInfos.size();i++){
			String tmp = deleteWords(tdInfos.get(i).getThemeType(),themeInfoTmp.getThemeName());
			tdInfos.get(i).setThemeType(tmp);
			session4.update(tdInfos.get(i));
		}
		
		transaction4.commit();
		session4.close();
	}
	
	public static String deleteWords(String str,String replace){
		
		if(str.contains(replace)){
			String[] arr = str.split(",");
			if(arr.length==1){
				str = "";
			}
			else if(arr[0].equals(replace)){
				str = str.replace(replace+", ", "");
			}
			else if(arr[arr.length-1].equals(replace)){
				str = str.replace(", "+replace, "");
			}
			else{
				str = str.replace(", "+replace, "");
			}
		}
		return str;
	}
	
	public void edit(ThemeInfo themeInfo){
		//�޸Ĳ���
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction(); 
		ThemeInfo themeInfoTmp = (ThemeInfo) session1.get(ThemeInfo.class,themeInfo.getThemeId());
		transaction1.commit();
		session1.close();
		
		Session session2 = HibernateUtils.openSession();
		Transaction transaction2 = session2.beginTransaction();
		session2.update(themeInfo);
		transaction2.commit();
		session2.close();
		
		//�޸ĳ��б��и�����
		Session session3 = HibernateUtils.openSession();
		Transaction transaction3 = session3.beginTransaction();
		String hql="from TravelDestinationInfo";
		Query query = session3.createQuery(hql);	//���query����
		
		List<TravelDestinationInfo> tdInfos = query.list();	//ִ�в�ѯ
		for(TravelDestinationInfo tdInfo:tdInfos){
		}
		transaction3.commit();
		session3.close();
		
		Session session4 = HibernateUtils.openSession();
		Transaction transaction4 = session4.beginTransaction();
		if(!themeInfoTmp.getThemeName().equals(themeInfo.getThemeName())){
			for(int i=0;i<tdInfos.size();i++){
				if(tdInfos.get(i).getThemeType().contains(themeInfoTmp.getThemeName())){
					String tmp = tdInfos.get(i).getThemeType().replace(themeInfoTmp.getThemeName(), themeInfo.getThemeName());
					tdInfos.get(i).setThemeType(tmp);
					session4.update(tdInfos.get(i));
				}
			}
		}
		
		transaction4.commit();
		session4.close();
	}

	public int getThemeAmount() {
		//ͨ��HQL���Ҳ���
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
				
			String hql="from ThemeInfo";
			Query query = session.createQuery(hql);	//���query����
				
			List<ThemeInfo> themeInfos = query.list();	//ִ�в�ѯ		
						
			transaction.commit();
			session.close();
			return themeInfos.size();
				
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public List<ThemeInfo> findByThemeName(String themeName) {
		//ͨ��HQL���Ҳ���
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
				
			String hql="from ThemeInfo where themeName='"+themeName+"'";
			Query query = session.createQuery(hql);	//���query����
				
			List<ThemeInfo> themeInfos = query.list();	//ִ�в�ѯ		
						
			transaction.commit();
			session.close();
			return themeInfos;
				
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
