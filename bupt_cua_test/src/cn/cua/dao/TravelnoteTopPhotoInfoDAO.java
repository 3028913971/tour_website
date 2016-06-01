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
 * �μǹ���ͼƬ��Ϣ��
 * @author W T
 *
 */
public class TravelnoteTopPhotoInfoDAO {
	
	@Test
	public TravelnoteTopPhotoInfo load(int travelnoteTopPhotoId){
		//ͨ��id���Ҳ���
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
		//ͨ��HQL���Ҳ���
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from TravelnoteTopPhotoInfo";
			Query query = session.createQuery(hql);	//���query����	

			List<TravelnoteTopPhotoInfo> travelnoteTopPhotoInfos = query.list();	//ִ�в�ѯ		
			
			transaction.commit();
			session.close();
			return travelnoteTopPhotoInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<TravelnoteTopPhotoInfo> findAll(int pageNum,int pageSize){
		//ͨ��HQL���Ҳ���
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TravelnoteTopPhotoInfo";
		Query query = session.createQuery(hql);	//���query����
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<TravelnoteTopPhotoInfo> travelnoteTopPhotoInfos = query.list();	//ִ�в�ѯ		
		
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
		//���Ӳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(travelnoteTopPhotoInfo);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delete(int travelnoteTopPhotoId){
		//ɾ������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		TravelnoteTopPhotoInfo travelnoteTopPhotoInfo = new TravelnoteTopPhotoInfo();
		travelnoteTopPhotoInfo.setTravelnoteTopPhotoId(travelnoteTopPhotoId);
		session.delete(travelnoteTopPhotoInfo);	
		transaction.commit();
		session.close();
	}
	
	public void edit(TravelnoteTopPhotoInfo travelnoteTopPhotoInfo){
		//�޸Ĳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(travelnoteTopPhotoInfo);
		transaction.commit();
		session.close();
	}
}
