package cn.cua.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.cua.domain.TravelDestinationInfo;

public class CityDescriptionPageDAO {
	
	/**
	 * ���н���ҳ���DAO��ͨ��������Ѱ�Ҷ�Ӧ�ĳ�����Ϣ
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		//ͨ�����ε����Ʋ��Ҳ���
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
