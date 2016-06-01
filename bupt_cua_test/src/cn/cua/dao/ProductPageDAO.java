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

import cn.cua.domain.ProductInfo;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class ProductPageDAO {
	

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
	 * 产品下载首页-国内目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findHomeTD(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select area from TravelDestinationInfo where homeOrAbroad='国内'");
			
		List<String> isAreaTypeList = query.list();	
		
		LinkedHashMap<String,List<String>> hp = new LinkedHashMap<String,List<String>>();
		
		for(int i=0;i<isAreaTypeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.eq("area",isAreaTypeList.get(i)));
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
	 * 所有产品的默认排序
	 * @return
	 */
	public int getAmountOfIsTop(){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		criteria.add(Restrictions.eq("isPublic", "是"));
		
		List<ProductInfo> list = criteria.list();	

		
		transaction.commit();
		session.close();
		return list.size();
	}
	
	/**
	 * 产品推荐首页-热门产品
	 * @return
	 */
	public List<ProductInfo> findIsTop(int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.addOrder(Order.desc("isTop"));
		criteria.add(Restrictions.eq("isPublic", "是")); 
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<ProductInfo> list = criteria.list();	

		
		transaction.commit();
		session.close();
		
		return list;
	}
	

	

	
	/**
	 * 
	 * @return
	 */
	public List<ProductInfo> findPrice(int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.addOrder(Order.asc("productPrice"));
		criteria.add(Restrictions.eq("isPublic", "是")); 
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<ProductInfo> list = criteria.list();

		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 搜索返回
	 * @return
	 */
	public int getAmountOfSearch(String productName){
		//组合查询	
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 
				
				Criteria criteria = session.createCriteria(ProductInfo.class);
				
				criteria.add(Restrictions.like("productName", "%"+productName+"%"));
				criteria.add(Restrictions.eq("isPublic", "是"));
							
				List<ProductInfo> list = criteria.list();	

				
				transaction.commit();
				session.close();
				
				return list.size();
	}
	/**
	 * 产品推荐首页-搜索热门产品
	 * @return
	 */
	public List<ProductInfo> findSearchIsTop(String productName,int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		criteria.add(Restrictions.like("productName", "%"+productName+"%"));
		criteria.addOrder(Order.desc("isTop"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<ProductInfo> list = criteria.list();	

		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 产品推荐首页-搜索价格排序
	 * @return
	 */
	public List<ProductInfo> findSearchPrice(String productName,int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		criteria.add(Restrictions.like("productName", "%"+productName+"%"));		
		criteria.addOrder(Order.asc("productPrice"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<ProductInfo> list = criteria.list();	

		for(int i=0;i<list.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	

}
