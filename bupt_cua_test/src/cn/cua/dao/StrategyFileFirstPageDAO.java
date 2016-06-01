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
import org.hibernate.criterion.Restrictions;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

public class StrategyFileFirstPageDAO {
	
	public static void main(String[] args){
		StrategyFileFirstPageDAO d = new StrategyFileFirstPageDAO();
		d.findThemeTypeTD();
	}
	
	/**
	 * ��ҳ���϶˹���ͼƬ
	 * @return
	 */
	public List<String> findPictures(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select strategyTopPhotoRealName from StrategyTopPhotoInfo where isTop = '��'");
		
		List<String> list = query.list();	
	
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ����������ҳ-���⹥���б�
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> findThemeTypeTD(){
		//��ϲ�ѯ	
		Session session1 = HibernateUtils.openSession();
		Transaction transaction1 = session1.beginTransaction(); 
		
//		Query query = session.createQuery("select themeType from TravelDestinationInfo");
//				
//		List<String> themeTypeList = query.list();
//		Set<String> themeTypeListNew = new HashSet<String>();
//		for(int i=0;i<themeTypeList.size();i++){
//			if(themeTypeList.get(i).contains(",")){
//				String[] terms = themeTypeList.get(i).replaceAll("\\s", "").split(",");
//				for(int j=0;j<terms.length;j++){
//					themeTypeListNew.add(terms[j]);
//				}
//			}
//			else{
//				themeTypeListNew.add(themeTypeList.get(i));
//			}
//		}
//		List<String> typeList = new ArrayList<String>();
//		Iterator<String> it = themeTypeListNew.iterator();
//		while(it.hasNext()){
//			typeList.add(it.next());
//		}
		
		//String hql="from ThemeInfo";
		//Query query = session1.createQuery(hql);	//���query����
		
		List<String> typeList = new ArrayList<String>();
		//List<ThemeInfo> themeInfos = query.list();	//ִ�в�ѯ	
		
		
		Criteria criteria1 = session1.createCriteria(ThemeInfo.class);
		
		criteria1.add(Restrictions.eq("themeIsTop","��"));

		criteria1.addOrder(Order.desc("themeId"));
		
		List<ThemeInfo> themeInfos = criteria1.list();	//ִ�в�ѯ	
		
		
		for(int i = 0; i<themeInfos.size();i++){
			typeList.add(themeInfos.get(i).getThemeName());
		}
		
		transaction1.commit();
		session1.close();
		
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> hp = new LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>>();
		
		for(int i=0;i<typeList.size();i++){
			Criteria criteria = session.createCriteria(TravelDestinationInfo.class);
			criteria.add(Restrictions.like("themeType", "%"+typeList.get(i)+"%"));
			criteria.add(Restrictions.eq("isPublic","��"));
			List<TravelDestinationInfo> tempList = criteria.list();	
			
			hp.put(themeInfos.get(i), tempList);		
		}

		transaction.commit();
		session.close();
		
		return hp;
	}
	
	/**
	 * ����������ҳ-�������ܻ�ӭ
	 * @return
	 */
	public List<StrategyFileInfo> findIsTop(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.add(Restrictions.eq("isTop","��"));
		List<StrategyFileInfo> list = criteria.list();	
		if(list.size()>12){
			list = list.subList(0,12);
		}
		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ����������ҳ-��������
	 * @return
	 */
	public List<StrategyFileInfo> findAmountOfDownload(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("amountOfDownload"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>12){
			list = list.subList(0,12);
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ����������ҳ-����ʱ��
	 * @return
	 */
	public List<StrategyFileInfo> findUpdateTime(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(StrategyFileInfo.class);
		
		criteria.addOrder(Order.desc("updateTime"));
		
		List<StrategyFileInfo> list = criteria.list();	

		if(list.size()>12){
			list = list.subList(0,12);
		}
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ����������ҳ-����Ŀ�ĵ��Ƽ�
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

}
