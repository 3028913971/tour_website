package cn.cua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.log4j.LogControler;
import cn.cua.utils.HibernateUtils;

public class TravelNotePublishPageDAO {
	
	/**
	 * 添加游记
	 * @param travelNoteInfo
	 */
	public void add(TravelNoteInfo travelNoteInfo){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(travelNoteInfo);
		transaction.commit();
		session.close();
	}
	
	/**
	 * 得到该城市所属省份的其他城市
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
		
	
		
		String hql2 = "select cityName from TravelDestinationInfo where province = ?";
		query =session.createQuery(hql2);
		query.setParameter(0, province);
		cityList = query.list();
		cityList.remove(cityName);	
			
		List<TravelDestinationInfo> temp = new ArrayList<TravelDestinationInfo>();
		
		for(int i=0;i<cityList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.eq("cityName", cityList.get(i)));
			List<TravelDestinationInfo> tempList = criteria.list();
			temp.add(tempList.get(0));
		}
		
		return temp;	
	}

}
