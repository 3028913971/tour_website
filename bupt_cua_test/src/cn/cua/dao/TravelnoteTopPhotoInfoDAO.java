package cn.cua.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.domain.TravelnoteTopPhotoInfo;
import cn.cua.utils.HibernateUtils;

/**
 * 游记滚动图片信息表
 * @author W T
 *
 */
public class TravelnoteTopPhotoInfoDAO {
	
	@Test
	public TravelnoteTopPhotoInfo load(int travelnoteTopPhotoId){
		//通过id查找操作
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		TravelnoteTopPhotoInfo travelnoteTopPhotoInfo = (TravelnoteTopPhotoInfo) session.get(TravelnoteTopPhotoInfo.class,travelnoteTopPhotoId);
		
		

		transaction.commit();
		session.close();
		return travelnoteTopPhotoInfo;
	}
	
	public int getTravelnoteTopPhotoAmount(){
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from TravelnoteTopPhotoInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<TravelnoteTopPhotoInfo> travelnoteTopPhotoInfos = query.list();	//执行查询		
			
			transaction.commit();
			session.close();
			return travelnoteTopPhotoInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<TravelnoteTopPhotoInfo> findAll(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TravelnoteTopPhotoInfo";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<TravelnoteTopPhotoInfo> travelnoteTopPhotoInfos = query.list();	//执行查询		
		
		for(TravelnoteTopPhotoInfo travelnoteTopPhotoInfo : travelnoteTopPhotoInfos){
		}
		
		
		transaction.commit();
		session.close();
		return travelnoteTopPhotoInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void add(TravelnoteTopPhotoInfo travelnoteTopPhotoInfo){
		//增加操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(travelnoteTopPhotoInfo);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delete(int travelnoteTopPhotoId){
		//删除操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		TravelnoteTopPhotoInfo travelnoteTopPhotoInfo = new TravelnoteTopPhotoInfo();
		travelnoteTopPhotoInfo.setTravelnoteTopPhotoId(travelnoteTopPhotoId);
		session.delete(travelnoteTopPhotoInfo);	
		transaction.commit();
		session.close();
	}
	
	public void edit(TravelnoteTopPhotoInfo travelnoteTopPhotoInfo){
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(travelnoteTopPhotoInfo);
		transaction.commit();
		session.close();
	}
}
