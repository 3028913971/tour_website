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
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.cua.domain.AdminInfo;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TopPhotoInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.utils.HibernateUtils;

/**
 * ��ҳ���ݷ��ʲ�
 * @author LI AO
 *
 */
public class HomePageDAO {
	
	
	/**
	 * ��ҳ���϶˹���ͼƬ
	 * @return
	 */
	public List<String> findPictures(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select topPhotoRealName from TopPhotoInfo where istop = '��'");
		
		List<String> list = query.list();	
	
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��ҳ�����Ƽ�
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("isHomeTopSeason","��"));
		criteria.add(Restrictions.eq("isPublic","��"));
		criteria.addOrder(Order.asc("tdOrder"));
		
		List<TravelDestinationInfo> list = criteria.list();	
		if(list.size()>4){
			list = list.subList(0,4);
		}
		transaction.commit();
		session.close();
		
		return list;
	}
	/**
	 * ��ҳ����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public List<TravelDestinationInfo> findIsThemeType(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
		
		criteria.add(Restrictions.eq("isHomeThemeType","��"));
		criteria.add(Restrictions.eq("isPublic","��"));
		criteria.addOrder(Order.asc("tdOrder"));
		List<TravelDestinationInfo> list = criteria.list();	
		if(list.size()>5){
			list = list.subList(0,5);
		}
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��ҳ��������-�������ܻ�ӭ
	 * @return
	 */
	public List<StrategyFileInfo> findIsTop(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.add(Restrictions.eq("isTop","��"));

		List<StrategyFileInfo> list = criteria.list();	
		if(list.size()>6){
			list = list.subList(0,6);
		}
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��ҳ��������-��������
	 * @return
	 */
	public List<StrategyFileInfo> findAmountOfDownload(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("amountOfDownload"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>6){
			list = list.subList(0,6);
		}
		
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��ҳ��������-����ʱ��
	 * @return
	 */
	public List<StrategyFileInfo> findUpdateTime(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("updateTime"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>6){
			list = list.subList(0,6);
		}
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��ҳ�϶�ѡ�-���������Ƽ������б�
	 * @return
	 */
	public List<String> findTopSeasonTD(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select cityName from TravelDestinationInfo where isTopSeason='��' and isPublic='��'");
			
		List<String> cityList = query.list();	

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return cityList;
	}
	
	/**
	 * ��ҳ�϶�ѡ�-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeTD(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select themeType from TravelDestinationInfo");
				
		List<String> themeTypeList = query.list();
		Set<String> themeTypeListNew = new HashSet<String>();
		for(int i=0;i<themeTypeList.size();i++){
			if(themeTypeList.get(i).contains(",")){
				String[] terms = themeTypeList.get(i).replaceAll("\\s", "").split(",");
				for(int j=0;j<terms.length;j++){
					themeTypeListNew.add(terms[j]);
				}
			}
			else{
				themeTypeListNew.add(themeTypeList.get(i));
			}
		}
		List<String> typeList = new ArrayList<String>();
		Iterator<String> it = themeTypeListNew.iterator();
		while(it.hasNext()){
			typeList.add(it.next());
		}

		LinkedHashMap<String,List<String>> hp = new LinkedHashMap<String,List<String>>();
		
		for(int i=0;i<typeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.like("themeType", "%"+typeList.get(i)+"%"));
			criteria.add(Restrictions.eq("isPublic","��"));
			List<TravelDestinationInfo> tempList = criteria.list();	
			List<String> list = new ArrayList<String>();
			for(int j=0;j<tempList.size();j++){
				list.add(tempList.get(j).getCityName());
			}
			hp.put(typeList.get(i), list);
			
		}

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return hp;
	}
	
	
	/**
	 * ��ҳ�϶�ѡ�-����Ŀ�ĵ��Ƽ�
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

		//list = list.subList(0, 4);
		transaction.commit();
		session.close();
		
		return hp;
	}
	
	/**
	 * ��ҳ���¶˹��ڳ����б�
	 * @return
	 */
	public List<String> findHomeTD(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select cityName from TravelDestinationInfo where homeOrAbroad='����' and isPublic='��'");
			
		
		List<String> list = query.list();	
		for(int i=0;i<list.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	public LinkedHashMap<String,String> findTopPhotoList(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TopPhotoInfo where isTop = '��'";
		Query query = session.createQuery(hql);	//���query����
		
		List<TopPhotoInfo> topPhotoInfos = query.list();	//ִ�в�ѯ
		
		LinkedHashMap<String,String> listTP = new LinkedHashMap<String,String>();
		for(int i=0;i<topPhotoInfos.size();i++){
			
			listTP.put(topPhotoInfos.get(i).getTopPhotoRealName(), topPhotoInfos.get(i).getTopPhotoCity());
		}
		return listTP;
	}
}
