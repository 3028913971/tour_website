package cn.cua.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.domain.TopPhotoInfo;
import cn.cua.utils.HibernateUtils;

/**
 * 攻略滚动图片信息表
 * @author W T
 *
 */
public class StrategyTopPhotoInfoDAO {
	@Test
	public StrategyTopPhotoInfo load(int strategyTopPhotoId){
		//通过id查找操作
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		StrategyTopPhotoInfo strategyTopPhotoInfo = (StrategyTopPhotoInfo) session.get(StrategyTopPhotoInfo.class,strategyTopPhotoId);
		
		

		transaction.commit();
		session.close();
		return strategyTopPhotoInfo;
	}
	
	public int getStrategyTopPhotoAmount(){
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from StrategyTopPhotoInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<StrategyTopPhotoInfo> strategyTopPhotoInfos = query.list();	//执行查询		
			
			transaction.commit();
			session.close();
			return strategyTopPhotoInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<StrategyTopPhotoInfo> findAll(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from StrategyTopPhotoInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<StrategyTopPhotoInfo> strategyTopPhotoInfos = query.list();	//执行查询		
		
		for(StrategyTopPhotoInfo strategyTopPhotoInfo : strategyTopPhotoInfos){
		}
		
		
		transaction.commit();
		session.close();
		return strategyTopPhotoInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void add(StrategyTopPhotoInfo strategyTopPhotoInfo){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(strategyTopPhotoInfo);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delete(int strategyTopPhotoId){
		//删除操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		StrategyTopPhotoInfo strategyTopPhotoInfo = new StrategyTopPhotoInfo();
		strategyTopPhotoInfo.setStrategyTopPhotoId(strategyTopPhotoId);
		session.delete(strategyTopPhotoInfo);	
		transaction.commit();
		session.close();
	}
	
	public void edit(StrategyTopPhotoInfo strategyTopPhotoInfo){
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(strategyTopPhotoInfo);
		transaction.commit();
		session.close();
	}

}
