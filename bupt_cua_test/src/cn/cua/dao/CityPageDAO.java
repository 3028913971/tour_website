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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class CityPageDAO {
	
	/**
	 * Ŀ�ĵ��Ƽ���ҳ-���������Ƽ�
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("isTopSeason","��"));
		criteria.add(Restrictions.eq("isPublic","��"));
		List<TravelDestinationInfo> list = criteria.list();	

		transaction.commit();
		session.close();
		
		return list;
	}
	
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
			criteria.add(Restrictions.eq("isPublic","��"));
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
	 * Ŀ�ĵ��Ƽ���ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select area from TravelDestinationInfo where homeOrAbroad='����' and isPublic='��'");
			
		List<String> isAreaTypeList = query.list();	
		
		LinkedHashMap<String,List<String>> hp = new LinkedHashMap<String,List<String>>();
		
		for(int i=0;i<isAreaTypeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.eq("area",isAreaTypeList.get(i)));
			criteria.add(Restrictions.eq("isPublic","��"));
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
