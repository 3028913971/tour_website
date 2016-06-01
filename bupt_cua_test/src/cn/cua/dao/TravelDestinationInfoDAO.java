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
 * 旅游地信息表
 * @author LI AO
 *
 */
public class TravelDestinationInfoDAO {
		
	public List<String> getThemeList(){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from ThemeInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		List<ThemeInfo> themeInfos = query.list();	//执行查询		
				
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
		//通过旅游地名称查找操作
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
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from TravelDestinationInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<TravelDestinationInfo> travelDestinationInfos = query.list();	//执行查询		
			
			transaction.commit();
			session.close();
			return travelDestinationInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<TravelDestinationInfo> findAll(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TravelDestinationInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<TravelDestinationInfo> travelDestinationInfos = query.list();	//执行查询		
		
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
			//通过旅游地名称查找操作
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
		

			String hql="from TravelDestinationInfo where cityName='"+cityName+"'";
			List<TravelDestinationInfo> list = this.travelDestinationInfoFindByHQL(hql);
			Query query = session.createQuery(hql);	//获得query对象
			List<TravelDestinationInfo> travelDestination = query.list();
			
			transaction.commit();
			session.close();
			return travelDestination;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<TravelDestinationInfo> travelDestinationInfoFindByHQL(String hql){
		//通过HQL查找操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
	

		Query query = session.createQuery(hql);	//获得query对象

		List<TravelDestinationInfo> travelDestinationInfoInfos = query.list();	//执行查询		

		transaction.commit();
		session.close();
		return travelDestinationInfoInfos;
	}
	
	
	
	public void add(TravelDestinationInfo travelDestination){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(travelDestination);
		transaction.commit();
		session.close();
	}
	
	
	@Test
	public void delete(String cityName){
		//删除操作
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
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(travelDestinationInfo);
		transaction.commit();
		session.close();
	}


	public int getQueryAmount(TravelDestinationInfo travelDestinationInfo){
		//组合查询	
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			//criteria.add(Restrictions.eq("adminId", 4));	//每次add都会添加一个条件
			
			String cityName = travelDestinationInfo.getCityName();
			//判断cityName这个条件是否存在
			if(cityName != null && !cityName.trim().isEmpty()){
				criteria.add(Restrictions.eq("cityName", cityName));
			}
			
			String province = travelDestinationInfo.getProvince();
			//判断province这个条件是否存在
			if(province != null && !province.trim().isEmpty()){
				criteria.add(Restrictions.eq("province", province));
			}
			
			String area = travelDestinationInfo.getArea();
			//判断area这个条件是否存在
			if(area != null && !area.trim().isEmpty()){
				criteria.add(Restrictions.eq("area", area));
			}
			
			String topSeason = travelDestinationInfo.getTopSeason();
			//判断topSeason这个条件是否存在
			if(topSeason != null && !topSeason.trim().isEmpty()){
				criteria.add(Restrictions.like("topSeason", "%"+topSeason+"%"));
			}
			
			String themeType = travelDestinationInfo.getThemeType();
			//判断themeType这个条件是否存在
			if(themeType != null && !themeType.trim().isEmpty()){
				criteria.add(Restrictions.like("themeType", "%"+themeType+"%"));
			}
			
			String homeOrAbroad = travelDestinationInfo.getHomeOrAbroad();
			//判断homeOrAbroad这个条件是否存在
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
			//判断isTopSeason这个条件是否存在
			if(isTopSeason != null && !isTopSeason.trim().isEmpty()){
				criteria.add(Restrictions.eq("isTopSeason", isTopSeason));
			}
			
			String isThemeType = travelDestinationInfo.getIsThemeType();
			//判断isTopSeason这个条件是否存在
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
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		//criteria.add(Restrictions.eq("adminId", 4));	//每次add都会添加一个条件
		
		String cityName = travelDestinationInfo.getCityName();
		//判断cityName这个条件是否存在
		if(cityName != null && !cityName.trim().isEmpty()){
			criteria.add(Restrictions.eq("cityName", cityName));
		}
		
		String province = travelDestinationInfo.getProvince();
		//判断province这个条件是否存在
		if(province != null && !province.trim().isEmpty()){
			criteria.add(Restrictions.eq("province", province));
		}
		
		String area = travelDestinationInfo.getArea();
		//判断area这个条件是否存在
		if(area != null && !area.trim().isEmpty()){
			criteria.add(Restrictions.eq("area", area));
		}
		
		String topSeason = travelDestinationInfo.getTopSeason();
		//判断topSeason这个条件是否存在
		if(topSeason != null && !topSeason.trim().isEmpty()){
			criteria.add(Restrictions.like("topSeason", "%"+topSeason+"%"));
		}
		
		String themeType = travelDestinationInfo.getThemeType();
		//判断themeType这个条件是否存在
		if(themeType != null && !themeType.trim().isEmpty()){
			criteria.add(Restrictions.like("themeType", "%"+themeType+"%"));
		}
		
		String homeOrAbroad = travelDestinationInfo.getHomeOrAbroad();
		//判断homeOrAbroad这个条件是否存在
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
		//判断isTopSeason这个条件是否存在
		if(isTopSeason != null && !isTopSeason.trim().isEmpty()){
			criteria.add(Restrictions.eq("isTopSeason", isTopSeason));
		}
		
		String isThemeType = travelDestinationInfo.getIsThemeType();
		//判断isTopSeason这个条件是否存在
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
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
				
			String hql="from TravelDestinationInfo order by tdOrder ASC";
			Query query = session.createQuery(hql);	//获得query对象
				

			List<TravelDestinationInfo> travelDestinationInfos = query.list();	//执行查询		
				
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
