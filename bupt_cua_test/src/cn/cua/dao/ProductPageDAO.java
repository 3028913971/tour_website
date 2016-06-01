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
	 * ����������ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		//��ϲ�ѯ	
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction(); 
		
		String hql="from ThemeInfo";
		Query query = session1.createQuery(hql);	//���query����
		
		List<String> typeList = new ArrayList<String>();
		List<ThemeInfo> themeInfos = query.list();	//ִ�в�ѯ	
			
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
	 * ��Ʒ������ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findHomeTD(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select area from TravelDestinationInfo where homeOrAbroad='����'");
			
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
	 * ���в�Ʒ��Ĭ������
	 * @return
	 */
	public int getAmountOfIsTop(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		criteria.add(Restrictions.eq("isPublic", "��"));
		
		List<ProductInfo> list = criteria.list();	

		
		transaction.commit();
		session.close();
		return list.size();
	}
	
	/**
	 * ��Ʒ�Ƽ���ҳ-���Ų�Ʒ
	 * @return
	 */
	public List<ProductInfo> findIsTop(int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.addOrder(Order.desc("isTop"));
		criteria.add(Restrictions.eq("isPublic", "��")); 
		
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
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.addOrder(Order.asc("productPrice"));
		criteria.add(Restrictions.eq("isPublic", "��")); 
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<ProductInfo> list = criteria.list();

		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��������
	 * @return
	 */
	public int getAmountOfSearch(String productName){
		//��ϲ�ѯ	
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 
				
				Criteria criteria = session.createCriteria(ProductInfo.class);
				
				criteria.add(Restrictions.like("productName", "%"+productName+"%"));
				criteria.add(Restrictions.eq("isPublic", "��"));
							
				List<ProductInfo> list = criteria.list();	

				
				transaction.commit();
				session.close();
				
				return list.size();
	}
	/**
	 * ��Ʒ�Ƽ���ҳ-�������Ų�Ʒ
	 * @return
	 */
	public List<ProductInfo> findSearchIsTop(String productName,int pageNum,int pageSize){
		//��ϲ�ѯ	
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
	 * ��Ʒ�Ƽ���ҳ-�����۸�����
	 * @return
	 */
	public List<ProductInfo> findSearchPrice(String productName,int pageNum,int pageSize){
		//��ϲ�ѯ	
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
