package cn.cua.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.cua.domain.ProductInfo;
import cn.cua.domain.QuestionInfo;
import cn.cua.utils.HibernateUtils;

/**
 * ָ·�ʴ����ݲ�
 * @author LI AO
 *
 */
public class QuestionPageDAO {
	
	
	//@Test
	public int getQuestionAmount(String questionName){
		
			try{
				//ͨ���������Ʋ��Ҳ���
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 

				//String hql="from QuestionInfo where questionName like '%"+questionName+"%'";
				//ͨ��questionNameģ����ѯ
				Criteria criteria = session.createCriteria(QuestionInfo.class);
				criteria.add(Restrictions.like("questionContent", "%"+questionName+"%"));
				List<QuestionInfo> list = criteria.list();	

				
				
				transaction.commit();
				session.close();
				return list.size();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			
	}

	//@Test
	public List<QuestionInfo> query(String questionName,int pageNum, int pageSize){
		
			try{
				//ͨ���������Ʋ��Ҳ���
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 
			

				//String hql="from QuestionInfo where questionName like '%"+questionName+"%' order by questionOrder ASC";
				//ͨ��questionNameģ����ѯ
				//Query query = session.createQuery(hql);	//���query����
				Criteria criteria = session.createCriteria(QuestionInfo.class);
				criteria.add(Restrictions.like("questionContent", "%"+questionName+"%"));
				
					
//				query.setFirstResult((pageNum-1)*pageSize);//��ѯ��� ��һ��������(pageNum-1)*pageSize
//				query.setMaxResults(pageSize);//��(pageNum-1)*pageSize ��ʼ ��ѯ 10 ����¼ 
//
//				List<QuestionInfo> questionInfos = query.list();
				criteria.setFirstResult((pageNum-1)*pageSize);
				criteria.setMaxResults(pageSize);
				
				List<QuestionInfo> list = criteria.list();	



				transaction.commit();
				session.close();
				return list;
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			
	}
	@Test

	
	
	public List<QuestionInfo> findAll(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		/*Criteria criteria = session.createCriteria(QuestionInfo.class);
		
		
		List<QuestionInfo> list = criteria.list();	

		for(int i=0;i<list.size();i++){
		}*/
		String hql="from QuestionInfo order by questionOrder ASC";
		Query query = session.createQuery(hql);	//���query����
		List<QuestionInfo> list = query.list();
		for(QuestionInfo questionInfo : list){
		}

		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * ��������
	 * @return
	 */
	public List<QuestionInfo> findUpdateTime(){
		
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		Criteria criteria = session.createCriteria(QuestionInfo.class);
		
		criteria.addOrder(Order.desc("questionTime"));
		
		List<QuestionInfo> list = criteria.list();	


		//list = list.subList(0, 5);
		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * �õ���ҳ��ѯ�ܼ�¼��
	 */
	public int getQuestionInfoAmount(){
		//ͨ��HQL���Ҳ���
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from QuestionInfo";
			Query query = session.createQuery(hql);	//���query����	

			List<QuestionInfo> questionInfos = query.list();	//ִ�в�ѯ		
			transaction.commit();
			session.close();
			return questionInfos.size();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	/**
	 * ��ҳ����
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<QuestionInfo> findPage(int pageNum,int pageSize){
		//ͨ��HQL���Ҳ���
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from QuestionInfo order by questionOrder ASC";
		Query query = session.createQuery(hql);	//���query����
		
		query.setFirstResult((pageNum-1)*pageSize);//��ѯ��� ��һ��������(pageNum-1)*pageSize
		query.setMaxResults(pageSize);//��(pageNum-1)*pageSize ��ʼ ��ѯ 10 ����¼ 

		List<QuestionInfo> questionInfos = query.list();	//ִ�в�ѯ		
		

		
		
		transaction.commit();
		session.close();
		return questionInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
