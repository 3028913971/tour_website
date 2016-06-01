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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.cua.domain.AdminInfo;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TopPhotoInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.utils.HibernateUtils;

/**
 * 首页数据访问层
 * @author LI AO
 *
 */
public class HomePageDAO {
	
	
	/**
	 * 首页最上端滚动图片
	 * @return
	 */
	public List<String> findPictures(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select topPhotoRealName from TopPhotoInfo where istop = '是'");
		
		List<String> list = query.list();	
	
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 首页本季推荐
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("isHomeTopSeason","是"));
		criteria.add(Restrictions.eq("isPublic","是"));
		criteria.addOrder(Order.asc("tdOrder"));
		
		List<TravelDestinationInfo> list = criteria.list();	
		if(list.size()>4){
			list = list.subList(0,4);
		}
		transaction.commit();
		session.close();
		
		return list;
	}
	/**
	 * 首页主题目的地推荐
	 * @return
	 */
	public List<TravelDestinationInfo> findIsThemeType(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("isHomeThemeType","是"));
		criteria.add(Restrictions.eq("isPublic","是"));
		criteria.addOrder(Order.asc("tdOrder"));
		List<TravelDestinationInfo> list = criteria.list();	
		if(list.size()>5){
			list = list.subList(0,5);
		}
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 首页攻略下载-本季最受欢迎
	 * @return
	 */
	public List<StrategyFileInfo> findIsTop(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.add(Restrictions.eq("isTop","是"));

		List<StrategyFileInfo> list = criteria.list();	
		if(list.size()>6){
			list = list.subList(0,6);
		}
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 首页攻略下载-下载人气
	 * @return
	 */
	public List<StrategyFileInfo> findAmountOfDownload(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("amountOfDownload"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>6){
			list = list.subList(0,6);
		}
		
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 首页攻略下载-更新时间
	 * @return
	 */
	public List<StrategyFileInfo> findUpdateTime(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("updateTime"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>6){
			list = list.subList(0,6);
		}
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 首页上端选项卡-本季热门推荐城市列表
	 * @return
	 */
	public List<String> findTopSeasonTD(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select cityName from TravelDestinationInfo where isTopSeason='是' and isPublic='是'");
			
		List<String> cityList = query.list();	

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return cityList;
	}
	
	/**
	 * 首页上端选项卡-主题目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeTD(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select themeType from TravelDestinationInfo");
				
		List<String> themeTypeList = query.list();
		Set<String> themeTypeListNew = new HashSet<String>();
		for(int i=0;i<themeTypeList.size();i++){
			if(themeTypeList.get(i).contains(",")){
				String[] terms = themeTypeList.get(i).replaceAll("\\s", "").split(",");
				for(int j=0;j<terms.length;j++){
					themeTypeListNew.add(terms[j]);
				}
			}
			else{
				themeTypeListNew.add(themeTypeList.get(i));
			}
		}
		List<String> typeList = new ArrayList<String>();
		Iterator<String> it = themeTypeListNew.iterator();
		while(it.hasNext()){
			typeList.add(it.next());
		}

		LinkedHashMap<String,List<String>> hp = new LinkedHashMap<String,List<String>>();
		
		for(int i=0;i<typeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.like("themeType", "%"+typeList.get(i)+"%"));
			criteria.add(Restrictions.eq("isPublic","是"));
			List<TravelDestinationInfo> tempList = criteria.list();	
			List<String> list = new ArrayList<String>();
			for(int j=0;j<tempList.size();j++){
				list.add(tempList.get(j).getCityName());
			}
			hp.put(typeList.get(i), list);
			
		}

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return hp;
	}
	
	
	/**
	 * 首页上端选项卡-国内目的地推荐
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

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return hp;
	}
	
	/**
	 * 首页最下端国内城市列表
	 * @return
	 */
	public List<String> findHomeTD(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select cityName from TravelDestinationInfo where homeOrAbroad='国内' and isPublic='是'");
			
		
		List<String> list = query.list();	
		for(int i=0;i<list.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	public LinkedHashMap<String,String> findTopPhotoList(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TopPhotoInfo where isTop = '是'";
		Query query = session.createQuery(hql);	//获得query对象
		
		List<TopPhotoInfo> topPhotoInfos = query.list();	//执行查询
		
		LinkedHashMap<String,String> listTP = new LinkedHashMap<String,String>();
		for(int i=0;i<topPhotoInfos.size();i++){
			
			listTP.put(topPhotoInfos.get(i).getTopPhotoRealName(), topPhotoInfos.get(i).getTopPhotoCity());
		}
		return listTP;
	}
}
