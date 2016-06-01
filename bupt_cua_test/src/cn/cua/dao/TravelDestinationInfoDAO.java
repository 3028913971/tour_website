package cn.cua.dao;

import java.util.ArrayList;
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
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.log4j.LogControler;
import cn.cua.utils.HibernateUtils;

/**
 * ���ε���Ϣ��
 * @author LI AO
 *
 */
public class TravelDestinationInfoDAO {
		
	public List<String> getThemeList(){
		//ͨ��HQL���Ҳ���
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from ThemeInfo";
		Query query = session.createQuery(hql);	//���query����
		
		List<ThemeInfo> themeInfos = query.list();	//ִ�в�ѯ		
				
		transaction.commit();
		session.close();
		
		List<String> themeList = new ArrayList<String>();
		for(int i=0;i<themeInfos.size();i++){
			themeList.add(themeInfos.get(i).getThemeName());
		}
		return themeList;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	@Test
	public TravelDestinationInfo load(String cityName){
		//ͨ�����ε����Ʋ��Ҳ���
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		TravelDestinationInfo travelDestinationInfo = (TravelDestinationInfo) session.get(TravelDestinationInfo.class,cityName);
		
		

		transaction.commit();
		session.close();
		return travelDestinationInfo;
	}
	
	public int getTravelDestinationAmount(){
		//ͨ��HQL���Ҳ���
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from TravelDestinationInfo";
			Query query = session.createQuery(hql);	//���query����	

			List<TravelDestinationInfo> travelDestinationInfos = query.list();	//ִ�в�ѯ		
			
			transaction.commit();
			session.close();
			return travelDestinationInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<TravelDestinationInfo> findAll(int pageNum,int pageSize){
		//ͨ��HQL���Ҳ���
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TravelDestinationInfo";
		Query query = session.createQuery(hql);	//���query����
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<TravelDestinationInfo> travelDestinationInfos = query.list();	//ִ�в�ѯ		
		
		for(TravelDestinationInfo travelDestinationInfo : travelDestinationInfos){
		}
		
		
		transaction.commit();
		session.close();
		return travelDestinationInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public List<TravelDestinationInfo> findBycityName(String cityName){
		
		try{
			//ͨ�����ε����Ʋ��Ҳ���
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
		

			String hql="from TravelDestinationInfo where cityName='"+cityName+"'";
			List<TravelDestinationInfo> list = this.travelDestinationInfoFindByHQL(hql);
			Query query = session.createQuery(hql);	//���query����
			List<TravelDestinationInfo> travelDestination = query.list();
			
			transaction.commit();
			session.close();
			return travelDestination;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<TravelDestinationInfo> travelDestinationInfoFindByHQL(String hql){
		//ͨ��HQL���Ҳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
	

		Query query = session.createQuery(hql);	//���query����

		List<TravelDestinationInfo> travelDestinationInfoInfos = query.list();	//ִ�в�ѯ		

		transaction.commit();
		session.close();
		return travelDestinationInfoInfos;
	}
	
	
	
	public void add(TravelDestinationInfo travelDestination){
		//���Ӳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(travelDestination);
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void delete(String cityName){
		//ɾ������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		TravelDestinationInfo travelDestinationInfo = new TravelDestinationInfo();
		travelDestinationInfo.setCityName(cityName);
		session.delete(travelDestinationInfo);		
		transaction.commit();
		session.close();
	}
	@Test
	public void edit(TravelDestinationInfo travelDestinationInfo){
		//�޸Ĳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(travelDestinationInfo);
		transaction.commit();
		session.close();
	}


	public int getQueryAmount(TravelDestinationInfo travelDestinationInfo){
		//��ϲ�ѯ	
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			//criteria.add(Restrictions.eq("adminId", 4));	//ÿ��add�������һ������
			
			String cityName = travelDestinationInfo.getCityName();
			//�ж�cityName��������Ƿ����
			if(cityName != null && !cityName.trim().isEmpty()){
				criteria.add(Restrictions.eq("cityName", cityName));
			}
			
			String province = travelDestinationInfo.getProvince();
			//�ж�province��������Ƿ����
			if(province != null && !province.trim().isEmpty()){
				criteria.add(Restrictions.eq("province", province));
			}
			
			String area = travelDestinationInfo.getArea();
			//�ж�area��������Ƿ����
			if(area != null && !area.trim().isEmpty()){
				criteria.add(Restrictions.eq("area", area));
			}
			
			String topSeason = travelDestinationInfo.getTopSeason();
			//�ж�topSeason��������Ƿ����
			if(topSeason != null && !topSeason.trim().isEmpty()){
				criteria.add(Restrictions.like("topSeason", "%"+topSeason+"%"));
			}
			
			String themeType = travelDestinationInfo.getThemeType();
			//�ж�themeType��������Ƿ����
			if(themeType != null && !themeType.trim().isEmpty()){
				criteria.add(Restrictions.like("themeType", "%"+themeType+"%"));
			}
			
			String homeOrAbroad = travelDestinationInfo.getHomeOrAbroad();
			//�ж�homeOrAbroad��������Ƿ����
			if(homeOrAbroad != null && !homeOrAbroad.trim().isEmpty()){
				criteria.add(Restrictions.eq("homeOrAbroad", homeOrAbroad));
			}
			
			String isHomeTopSeason = travelDestinationInfo.getIsHomeTopSeason();
			if(isHomeTopSeason != null && !isHomeTopSeason.trim().isEmpty()){
				criteria.add(Restrictions.eq("isHomeTopSeason", isHomeTopSeason));
			}
			
			String isHomeThemeType = travelDestinationInfo.getIsHomeThemeType();
			if(isHomeThemeType != null && !isHomeThemeType.trim().isEmpty()){
				criteria.add(Restrictions.eq("isHomeThemeType", isHomeThemeType));
			}
			
			String isTopSeason = travelDestinationInfo.getIsTopSeason();
			//�ж�isTopSeason��������Ƿ����
			if(isTopSeason != null && !isTopSeason.trim().isEmpty()){
				criteria.add(Restrictions.eq("isTopSeason", isTopSeason));
			}
			
			String isThemeType = travelDestinationInfo.getIsThemeType();
			//�ж�isTopSeason��������Ƿ����
			if(isThemeType != null && !isThemeType.trim().isEmpty()){
				criteria.add(Restrictions.eq("isThemeType", isThemeType));
			}
			
			List<TravelDestinationInfo> travelDestinationInfos = criteria.list();
			
			

			
			transaction.commit();
			session.close();
			
			return travelDestinationInfos.size();
	}

	@Test
	public List<TravelDestinationInfo> query(TravelDestinationInfo travelDestinationInfo,int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		//criteria.add(Restrictions.eq("adminId", 4));	//ÿ��add�������һ������
		
		String cityName = travelDestinationInfo.getCityName();
		//�ж�cityName��������Ƿ����
		if(cityName != null && !cityName.trim().isEmpty()){
			criteria.add(Restrictions.eq("cityName", cityName));
		}
		
		String province = travelDestinationInfo.getProvince();
		//�ж�province��������Ƿ����
		if(province != null && !province.trim().isEmpty()){
			criteria.add(Restrictions.eq("province", province));
		}
		
		String area = travelDestinationInfo.getArea();
		//�ж�area��������Ƿ����
		if(area != null && !area.trim().isEmpty()){
			criteria.add(Restrictions.eq("area", area));
		}
		
		String topSeason = travelDestinationInfo.getTopSeason();
		//�ж�topSeason��������Ƿ����
		if(topSeason != null && !topSeason.trim().isEmpty()){
			criteria.add(Restrictions.like("topSeason", "%"+topSeason+"%"));
		}
		
		String themeType = travelDestinationInfo.getThemeType();
		//�ж�themeType��������Ƿ����
		if(themeType != null && !themeType.trim().isEmpty()){
			criteria.add(Restrictions.like("themeType", "%"+themeType+"%"));
		}
		
		String homeOrAbroad = travelDestinationInfo.getHomeOrAbroad();
		//�ж�homeOrAbroad��������Ƿ����
		if(homeOrAbroad != null && !homeOrAbroad.trim().isEmpty()){
			criteria.add(Restrictions.eq("homeOrAbroad", homeOrAbroad));
		}
		
		String isHomeTopSeason = travelDestinationInfo.getIsHomeTopSeason();
		if(isHomeTopSeason != null && !isHomeTopSeason.trim().isEmpty()){
			criteria.add(Restrictions.eq("isHomeTopSeason", isHomeTopSeason));
		}
		
		String isHomeThemeType = travelDestinationInfo.getIsHomeThemeType();
		if(isHomeThemeType != null && !isHomeThemeType.trim().isEmpty()){
			criteria.add(Restrictions.eq("isHomeThemeType", isHomeThemeType));
		}
		
		String isTopSeason = travelDestinationInfo.getIsTopSeason();
		//�ж�isTopSeason��������Ƿ����
		if(isTopSeason != null && !isTopSeason.trim().isEmpty()){
			criteria.add(Restrictions.eq("isTopSeason", isTopSeason));
		}
		
		String isThemeType = travelDestinationInfo.getIsThemeType();
		//�ж�isTopSeason��������Ƿ����
		if(isThemeType != null && !isThemeType.trim().isEmpty()){
			criteria.add(Restrictions.eq("isThemeType", isThemeType));
		}
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<TravelDestinationInfo> travelDestinationInfos = criteria.list();
		
		
		
		transaction.commit();
		session.close();
		
		return travelDestinationInfos;
	}
	public List<TravelDestinationInfo> findAll() {
		//ͨ��HQL���Ҳ���
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
				
			String hql="from TravelDestinationInfo order by tdOrder ASC";
			Query query = session.createQuery(hql);	//���query����
				

			List<TravelDestinationInfo> travelDestinationInfos = query.list();	//ִ�в�ѯ		
				
			for(TravelDestinationInfo travelDestinationInfo : travelDestinationInfos){
			}
				
				
			transaction.commit();
			session.close();
			return travelDestinationInfos;
				
		}catch(Exception e){
				throw new RuntimeException(e);
		}
	}
}
