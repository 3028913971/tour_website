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

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.utils.HibernateUtils;

public class TravelNoteThirdPageDAO {
	

	/**
	 * �õ���Ӧ���μ�
	 * @param cityName
	 * @return
	 */
	public TravelNoteInfo load(int travelNoteId){
		//ͨ�����ε����Ʋ��Ҳ���
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		TravelNoteInfo travelNoteInfo = (TravelNoteInfo) session.get(TravelNoteInfo.class,travelNoteId);
		
		

		transaction.commit();
		session.close();
		return travelNoteInfo;
	}
	
	/**
	 * �õ��ó�������ʡ�ݵ���������
	 * @param cityName
	 * @return
	 */
	public List<TravelDestinationInfo> getRelevantCityList(String cityName){
		
		List <String> cityList = new ArrayList<String>();
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		String hql = "select province from TravelDestinationInfo where cityName = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, cityName);
		String province =  (String)query.uniqueResult();
		
	
		
		String hql2 = "select cityName from TravelDestinationInfo where province = ? and isPublic='��'";
		query =session.createQuery(hql2);
		query.setParameter(0, province);
		cityList = query.list();
		cityList.remove(cityName);	
			
		List<TravelDestinationInfo> temp = new ArrayList<TravelDestinationInfo>();
		
		for(int i=0;i<cityList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.eq("cityName", cityList.get(i)));
			criteria.add(Restrictions.eq("isPublic","��"));
			List<TravelDestinationInfo> tempList = criteria.list();
			temp.add(tempList.get(0));
		}
		
		return temp;	
	}

}
