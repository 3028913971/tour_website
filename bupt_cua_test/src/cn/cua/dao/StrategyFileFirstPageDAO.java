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
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class StrategyFileFirstPageDAO {
	
	public static void main(String[] args){
		StrategyFileFirstPageDAO d = new StrategyFileFirstPageDAO();
		d.findThemeTypeTD();
	}
	
	/**
	 * 首页最上端滚动图片
	 * @return
	 */
	public List<String> findPictures(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select strategyTopPhotoRealName from StrategyTopPhotoInfo where isTop = '是'");
		
		List<String> list = query.list();	
	
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 攻略下载首页-主题攻略列表
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> findThemeTypeTD(){
		//组合查询	
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction(); 
		
//		Query query = session.createQuery("select themeType from TravelDestinationInfo");
//				
//		List<String> themeTypeList = query.list();
//		Set<String> themeTypeListNew = new HashSet<String>();
//		for(int i=0;i<themeTypeList.size();i++){
//			if(themeTypeList.get(i).contains(",")){
//				String[] terms = themeTypeList.get(i).replaceAll("\\s", "").split(",");
//				for(int j=0;j<terms.length;j++){
//					themeTypeListNew.add(terms[j]);
//				}
//			}
//			else{
//				themeTypeListNew.add(themeTypeList.get(i));
//			}
//		}
//		List<String> typeList = new ArrayList<String>();
//		Iterator<String> it = themeTypeListNew.iterator();
//		while(it.hasNext()){
//			typeList.add(it.next());
//		}
		
		//String hql="from ThemeInfo";
		//Query query = session1.createQuery(hql);	//获得query对象
		
		List<String> typeList = new ArrayList<String>();
		//List<ThemeInfo> themeInfos = query.list();	//执行查询	
		
		
		Criteria criteria1 = session1.createCriteria(ThemeInfo.class);
		
		criteria1.add(Restrictions.eq("themeIsTop","是"));

		criteria1.addOrder(Order.desc("themeId"));
		
		List<ThemeInfo> themeInfos = criteria1.list();	//执行查询	
		
		
		for(int i = 0; i<themeInfos.size();i++){
			typeList.add(themeInfos.get(i).getThemeName());
		}
		
		transaction1.commit();
		session1.close();
		
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> hp = new LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>>();
		
		for(int i=0;i<typeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.like("themeType", "%"+typeList.get(i)+"%"));
			criteria.add(Restrictions.eq("isPublic","是"));
			List<TravelDestinationInfo> tempList = criteria.list();	
			
			hp.put(themeInfos.get(i), tempList);		
		}

		transaction.commit();
		session.close();
		
		return hp;
	}
	
	/**
	 * 攻略下载首页-本季最受欢迎
	 * @return
	 */
	public List<StrategyFileInfo> findIsTop(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.add(Restrictions.eq("isTop","是"));
		List<StrategyFileInfo> list = criteria.list();	
		if(list.size()>12){
			list = list.subList(0,12);
		}
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 攻略下载首页-下载人气
	 * @return
	 */
	public List<StrategyFileInfo> findAmountOfDownload(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("amountOfDownload"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>12){
			list = list.subList(0,12);
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 攻略下载首页-更新时间
	 * @return
	 */
	public List<StrategyFileInfo> findUpdateTime(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("updateTime"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>12){
			list = list.subList(0,12);
		}
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 攻略下载首页-国内目的地推荐
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
	 * 城市攻略下载页面的DAO，通过城市名寻找对应的城市信息
	 * @param cityName
	 * @return
	 */
	/**
	 * 得到该城市对应攻略的信息；
	 * */
	public StrategyFileInfo getStrategyByCityName(String cityName){
		StrategyFileInfo sfi = new StrategyFileInfo();
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		criteria.add(Restrictions.eq("cityName",cityName));
		sfi = (StrategyFileInfo)criteria.uniqueResult();
		return sfi;
	}

}
