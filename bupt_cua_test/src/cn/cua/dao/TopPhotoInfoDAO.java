package cn.cua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TopPhotoInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.utils.HibernateUtils;

/**
 * 首页滚动图片信息表
 * @author W T
 *
 */
public class TopPhotoInfoDAO {
	
	public List<String> getCityList(){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TravelDestinationInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		List<TravelDestinationInfo> cityInfos = query.list();	//执行查询		
				
		transaction.commit();
		session.close();
		
		List<String> cityList = new ArrayList<String>();
		for(int i=0;i<cityInfos.size();i++){
			cityList.add(cityInfos.get(i).getCityName());
		}
		return cityList;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public TopPhotoInfo load(int topPhotoId){
		//通过id查找操作
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		TopPhotoInfo topPhotoInfo = (TopPhotoInfo) session.get(TopPhotoInfo.class,topPhotoId);
		System.out.println(topPhotoInfo);
		
		

		transaction.commit();
		session.close();
		return topPhotoInfo;
	}
	
	public int getTopPhotoAmount(){
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from TopPhotoInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<TopPhotoInfo> topPhotoInfos = query.list();	//执行查询		
			
			transaction.commit();
			session.close();
			return topPhotoInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<TopPhotoInfo> findAll(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TopPhotoInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<TopPhotoInfo> topPhotoInfos = query.list();	//执行查询		
		
		for(TopPhotoInfo topPhotoInfo : topPhotoInfos){
			System.out.println(topPhotoInfo);
		}
		
		
		transaction.commit();
		session.close();
		return topPhotoInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void add(TopPhotoInfo topPhotoInfo){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(topPhotoInfo);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delete(int topPhotoId){
		//删除操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		TopPhotoInfo topPhotoInfo = new TopPhotoInfo();
		topPhotoInfo.setTopPhotoId(topPhotoId);
		session.delete(topPhotoInfo);	
		transaction.commit();
		session.close();
	}	
	
	public void edit(TopPhotoInfo topPhotoInfo){
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(topPhotoInfo);
		transaction.commit();
		session.close();
	}

}
