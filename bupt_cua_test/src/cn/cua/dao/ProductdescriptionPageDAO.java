package cn.cua.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.JourneyInfo;
import cn.cua.domain.ProductInfo;
import cn.cua.utils.HibernateUtils;

public class ProductdescriptionPageDAO {
	
	public static void main(String[] args){
		ProductdescriptionPageDAO p = new ProductdescriptionPageDAO();
		//p.getProduct(42);
		p.getJourney("��������������");
	}
	
	/**
	 * �õ���Ӧ�Ĳ�Ʒ
	 * 
	 * */
	public ProductInfo getProduct(int productId){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		Criteria criteria = session.createCriteria(ProductInfo.class);
		
		criteria.add(Restrictions.eq("productId", productId));
		
		List<ProductInfo> list = criteria.list();
		return list.get(0);
	}
	
	/**
	 * �õ���Ʒ���г���Ϣ
	 * 
	 * */
	public List<JourneyInfo> getJourney(String productName){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		Criteria criteria = session.createCriteria(JourneyInfo.class);
		
		criteria.add(Restrictions.eq("productName", productName));
		criteria.addOrder(Order.asc("journeyDayNumber"));
		
		List<JourneyInfo> list = criteria.list();
	
		return list;
	}
}
