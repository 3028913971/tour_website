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

import cn.cua.domain.ProductInfo;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.utils.HibernateUtils;

public class TravelNoteFirstPageDAO {

	
	/**
	 * ��ҳ���϶˹���ͼƬ
	 * @return
	 */
	public List<String> findPictures(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Query query = session.createQuery("select travelnoteTopPhotoRealName from TravelnoteTopPhotoInfo where istop = '��'");
		
		List<String> list = query.list();	
	
		transaction.commit();
		session.close();
		
		return list;
	}
	/**
	 * �μ���ҳ-����Ŀ�ĵ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeList(){
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
	 * �μ���ҳ-����Ŀ�ĵ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findHomeTD(){
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
	 * �μ���ҳ-����Ŀ�ĵ�
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
	 * �����μǵ�����
	 * @return
	 */
	public int getAmount(){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		criteria.add(Restrictions.eq("status", "���ͨ��"));
		
		List<TravelNoteInfo> list = criteria.list();	

		for(int i=0;i<list.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return list.size();
	}
	
	/**
	 * �μ���������
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		
		criteria.addOrder(Order.desc("isTop"));
		criteria.add(Restrictions.eq("status", "���ͨ��"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<TravelNoteInfo> list = criteria.list();	

		for(int i=0;i<list.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * �μǷ���ʱ������
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(int pageNum,int pageSize){
		//��ϲ�ѯ	
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(TravelNoteInfo.class);
		
		criteria.addOrder(Order.desc("publicTime"));
		criteria.add(Restrictions.eq("status", "���ͨ��"));
		
		criteria.setFirstResult((pageNum-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<TravelNoteInfo> list = criteria.list();	

		for(int i=0;i<list.size();i++){
		}
		
		transaction.commit();
		session.close();
		
		return list;
	}


}
