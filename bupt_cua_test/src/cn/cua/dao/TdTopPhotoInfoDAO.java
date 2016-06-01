package cn.cua.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.cua.domain.TdTopPhotoInfo;
import cn.cua.domain.TravelnoteTopPhotoInfo;
import cn.cua.utils.HibernateUtils;

/**
 * Ŀ�ĵ��Ƽ��Ϸ�ͼƬ  ���ݷ��ʲ�
 * @author LI AO
 *
 */
public class TdTopPhotoInfoDAO {
	@Test
	public TdTopPhotoInfo load(int tdTopPhotoId){
		//ͨ��id���Ҳ���
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
			
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		TdTopPhotoInfo tdTopPhotoInfo = (TdTopPhotoInfo) session.get(TdTopPhotoInfo.class,tdTopPhotoId);
		
		

		transaction.commit();
		session.close();
		return tdTopPhotoInfo;
	}
	
	public int getTdTopPhotoAmount(){
		//ͨ��HQL���Ҳ���
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from TdTopPhotoInfo";
			Query query = session.createQuery(hql);	

			List<TdTopPhotoInfo> tdTopPhotoInfos = query.list();		
			
			transaction.commit();
			session.close();
			return tdTopPhotoInfos.size();
			
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	
	public List<TdTopPhotoInfo> findAll(int pageNum,int pageSize){
		//ͨ��HQL���Ҳ���
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from TdTopPhotoInfo";
		Query query = session.createQuery(hql);	
		
		query.setFirstResult((pageNum-1)*pageSize);
		query.setMaxResults(pageSize);

		List<TdTopPhotoInfo> tdTopPhotoInfos = query.list();			
		
		for(TdTopPhotoInfo tdTopPhotoInfo : tdTopPhotoInfos){
		}
		
		
		transaction.commit();
		session.close();
		return tdTopPhotoInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public void add(TdTopPhotoInfo tdTopPhotoInfo){
		//���Ӳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(tdTopPhotoInfo);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void delete(int tdTopPhotoId){
		//ɾ������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		TdTopPhotoInfo tdTopPhotoInfo = new TdTopPhotoInfo();
		tdTopPhotoInfo.setTdTopPhotoId(tdTopPhotoId);
		session.delete(tdTopPhotoInfo);	
		transaction.commit();
		session.close();
	}

	public void edit(TdTopPhotoInfo tdTopPhotoInfo){
		//�޸Ĳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		session.update(tdTopPhotoInfo);
		transaction.commit();
		session.close();
	}
	
	/**
	 * get one picture object from db;
	 * @author xuxu
	 * @return TdTopPhotoInfo
	 * @
	 * */
	public TdTopPhotoInfo getOnePic() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		TdTopPhotoInfo tdTopPhotoInfo = new TdTopPhotoInfo();
		String hql="from TdTopPhotoInfo";
		Query query = session.createQuery(hql);
		TdTopPhotoInfo tdTopPhotoInfo2 = (TdTopPhotoInfo)query.list().get(0);
		transaction.commit();
		session.close();		
		return tdTopPhotoInfo2;
	}	
}
