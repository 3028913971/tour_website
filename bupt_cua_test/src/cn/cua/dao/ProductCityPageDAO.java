package cn.cua.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.ProductInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class ProductCityPageDAO {
	
	public static void main(String[] args){
		ProductCityPageDAO p = new ProductCityPageDAO();
		p.getCity("����");
	}
	/**
	 * �õ����е�������Ϣ
	 * 
	 * */
	public TravelDestinationInfo getCity(String cityName){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("cityName", cityName));
		
		List<TravelDestinationInfo> list = criteria.list();
		return list.get(0);
	}
	
	/**
	 * ��Ʒ�Ƽ�����ҳ��-��ҳ
	 * @param cityName
	 * @return
	 */
	public int getAmountOfIsTopCity(String cityName){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.add(Restrictions.eq("cityName", cityName));
	
		List<ProductInfo> list = criteria.list();
		
		transaction.commit();
		session.close();
		return list.size();
	}
	
	/**
	 * ��Ʒ�Ƽ�����ҳ��-���Ų�Ʒ
	 * @return
	 */
	public List<ProductInfo> findIsTopCity(String cityName,int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.add(Restrictions.eq("cityName", cityName));
		
		criteria.addOrder(Order.desc("isTop"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<ProductInfo> list = criteria.list();	

		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��Ʒ�Ƽ�����ҳ��-�۸�����
	 * @return
	 */
	public List<ProductInfo> findPriceCity(String cityName,int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.add(Restrictions.eq("cityName", cityName));
		criteria.addOrder(Order.asc("productPrice"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<ProductInfo> list = criteria.list();	

		
		transaction.commit();
		session.close();
		
		return list;
	}
}
