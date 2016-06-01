package cn.cua.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.cua.domain.TravelDestinationInfo;

public class CityDescriptionPageDAO {
	
	/**
	 * 城市介绍页面的DAO，通过城市名寻找对应的城市信息
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		//通过旅游地名称查找操作
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		TravelDestinationInfo travelDestinationInfo = (TravelDestinationInfo) session.get(TravelDestinationInfo.class,cityName);
		
		

		transaction.commit();
		session.close();
		return travelDestinationInfo;
	}
}
