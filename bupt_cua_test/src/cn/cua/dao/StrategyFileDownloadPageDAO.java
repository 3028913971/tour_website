package cn.cua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class StrategyFileDownloadPageDAO {
	

	/**
	 * ���й�������ҳ���DAO��ͨ��������Ѱ�Ҷ�Ӧ�ĳ�����Ϣ
	 * @param cityName
	 * @return
	 */
	/**
	 * �õ��ó��ж�Ӧ���Ե���Ϣ��
	 * */
	public StrategyFileInfo getStrategyByCityName(String cityName){
		StrategyFileInfo sfi = new StrategyFileInfo();
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		criteria.add(Restrictions.eq("cityName",cityName));
		sfi = (StrategyFileInfo)criteria.uniqueResult();
		return sfi;
	}

	/**
	 * �õ����е�������Ϣ
	 * @author shixu
	 * */
	public String getCityDescrption(String cityName){
		
		String cityDesc = "";
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 	
		String hql = "select description from TravelDestinationInfo where cityName = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, cityName);
		cityDesc = (String)query.uniqueResult();
		return cityDesc;
	}
	
	
	/**
	 * �õ��ó�������ʡ�ݵ��������й���
	 * 
	 * */
	public List<StrategyFileInfo> getRelevantCity(String cityName){
		
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
			
		List<StrategyFileInfo> temp = new ArrayList<StrategyFileInfo>();
		
		for(int i=0;i<cityList.size();i++){
			Criteria criteria = session.createCriteria(StrategyFileInfo.class);
			criteria.add(Restrictions.eq("cityName", cityList.get(i)));
			List<StrategyFileInfo> tempList = criteria.list();
			if(tempList.size()!=0){
				temp.add(tempList.get(0));
			}
			
		}
		
		return temp;	
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
	
	/**
	 * ����ʱ�������ݿ�����ش���
	 * @param cityName
	 */
	public void downloadAmount(String cityName){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String str="select amountOfDownload from StrategyFileInfo where cityName='"+cityName+"'";
		Query query = session.createQuery(str);

		
		int amountOfDownload =  (Integer)query.uniqueResult() +1;
		query = session.createQuery("update StrategyFileInfo set amountOfDownload = "+amountOfDownload+" where cityName='"+cityName+"'");
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

}
