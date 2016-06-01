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
	 * �õ����е�������Ϣ
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
	 * �μǶ���ҳ��-��ҳ����
	 * @param cityName
	 * @return
	 */
	public int getAmount(String cityName){
		//��ϲ�ѯ	
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
	 * �μ���������
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(String cityName,int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		criteria.add(Restrictions.eq("cityName", cityName));
		criteria.add(Restrictions.eq("status", "���ͨ��"));
		criteria.addOrder(Order.desc("isTop"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<TravelNoteInfo> list = criteria.list();	

		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * �μǷ���ʱ������
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(String cityName,int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		criteria.add(Restrictions.eq("cityName", cityName));
		criteria.add(Restrictions.eq("status", "���ͨ��"));
		criteria.addOrder(Order.desc("publicTime"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<TravelNoteInfo> list = criteria.list();	


		transaction.commit();
		session.close();
		
		return list;
	}
}
