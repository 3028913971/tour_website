package cn.cua.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cua.domain.JourneyInfo;
import cn.cua.utils.HibernateUtils;

/**
 * �г���Ϣ�����ݷ�����
 * @author Sandm
 *
 */
public class JourneyInfoDAO {
	
	public JourneyInfoDAO() {
		super();
	}

	/**
	 * �����г�
	 * @param journeyInfo
	 */
	public void add(JourneyInfo journeyInfo) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(journeyInfo);
			
			tx.commit();
			session.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * �����ض���Ʒ���г�
	 * @param productName
	 * @return
	 */
	public List<JourneyInfo> findByProductName(String productName) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql ="from JourneyInfo where productName='"+productName+"' order by journeyDayNumber ASC";
			Query query = session.createQuery(hql);
			
			List<JourneyInfo> journeyInfos = query.list();
			
			tx.commit();
			session.close();
			
			return journeyInfos;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * ɾ���г�
	 * @param journeyId
	 */
	public void delete(int journeyId) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			JourneyInfo journeyInfo = new JourneyInfo();
			journeyInfo.setJourneyId(journeyId);
			session.delete(journeyInfo);
			
			tx.commit();
			session.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * �����г�
	 * @param jourId
	 * @return
	 */
	public JourneyInfo load(Integer jourId) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			String hql = "from JourneyInfo where journeyId="+jourId;
			Query query = session.createQuery(hql);
			JourneyInfo journeyInfo = (JourneyInfo)query.list().get(0);
			
			tx.commit();
			session.close();
			
			return journeyInfo;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * �༭�г�
	 * @param journeyInfo
	 */
	public void edit(JourneyInfo journeyInfo) {
		try{
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			
			session.update(journeyInfo);
			
			tx.commit();
			session.close();
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
