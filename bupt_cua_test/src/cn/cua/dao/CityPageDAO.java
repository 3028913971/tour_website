package cn.cua.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class CityPageDAO {
	
	/**
	 * 目的地推荐首页-本季热门推荐
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("isTopSeason","是"));
		criteria.add(Restrictions.eq("isPublic","是"));
		List<TravelDestinationInfo> list = criteria.list();	

		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 攻略下载首页-主题目的地推荐
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		//组合查询	
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction(); 
		
		String hql="from ThemeInfo";
		Query query = session1.createQuery(hql);	//获得query对象
		
		List<String> typeList = new ArrayList<String>();
		List<ThemeInfo> themeInfos = query.list();	//执行查询	
			
		for(int i = 0; i<themeInfos.size();i++){
			typeList.add(themeInfos.get(i).getThemeName());
		}
		
		transaction1.commit();
		session1.close();
		
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
			
		LinkedHashMap<ThemeInfo,List<String>> hp = new LinkedHashMap<ThemeInfo,List<String>>();
		
		for(int i=0;i<typeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.like("themeType", "%"+typeList.get(i)+"%"));
			criteria.add(Restrictions.eq("isPublic","是"));
			List<TravelDestinationInfo> tempList = criteria.list();	
			List<String> list = new ArrayList<String>();
			for(int j=0;j<tempList.size();j++){
				list.add(tempList.get(j).getCityName());
			}
			hp.put(themeInfos.get(i), list);
			
		}

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return hp;
	}
	
	/**
	 * 目的地推荐首页-国内目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select area from TravelDestinationInfo where homeOrAbroad='国内' and isPublic='是'");
			
		List<String> isAreaTypeList = query.list();	
		
		LinkedHashMap<String,List<String>> hp = new LinkedHashMap<String,List<String>>();
		
		for(int i=0;i<isAreaTypeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.eq("area",isAreaTypeList.get(i)));
			criteria.add(Restrictions.eq("isPublic","是"));
			List<TravelDestinationInfo> tempList = criteria.list();	
			List<String> list = new ArrayList<String>();
			for(int j=0;j<tempList.size();j++){
				list.add(tempList.get(j).getCityName());
			}
			hp.put(isAreaTypeList.get(i), list);
			
		}

		transaction.commit();
		session.close();
		
		return hp;
	}
	
	/**
	 * 城市介绍页面的DAO，通过城市名寻找对应的城市信息
	 * @param cityName
	 * @return
	 */
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

}
