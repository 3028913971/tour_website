package cn.cua.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.utils.HibernateUtils;

public class TravelNoteSecondPageDAO {
	

	
	/**
	 * 得到城市的描述信息
	 * 
	 * */
	public TravelDestinationInfo getCity(String cityName){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("cityName", cityName));
		
		List<TravelDestinationInfo> list = criteria.list();
		return (list==null||list.size()==0)?null:list.get(0);
	}
	
	/**
	 * 游记二级页面-分页计数
	 * @param cityName
	 * @return
	 */
	public int getAmount(String cityName){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		
		criteria.add(Restrictions.eq("cityName", cityName));
	
		List<TravelNoteInfo> list = criteria.list();

		transaction.commit();
		session.close();
		return list==null?0:list.size();
	}
	
	/**
	 * 游记热门排序
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(String cityName,int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		criteria.add(Restrictions.eq("cityName", cityName));
		criteria.add(Restrictions.eq("status", "审核通过"));
		criteria.addOrder(Order.desc("isTop"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<TravelNoteInfo> list = criteria.list();	

		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 游记发布时间排序
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(String cityName,int pageNum,int pageSize){
		//组合查询	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		criteria.add(Restrictions.eq("cityName", cityName));
		criteria.add(Restrictions.eq("status", "审核通过"));
		criteria.addOrder(Order.desc("publicTime"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<TravelNoteInfo> list = criteria.list();	


		transaction.commit();
		session.close();
		
		return list;
	}
}
