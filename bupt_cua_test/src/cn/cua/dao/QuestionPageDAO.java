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
 * 指路问答数据层
 * @author LI AO
 *
 */
public class QuestionPageDAO {
	
	
	//@Test
	public int getQuestionAmount(String questionName){
		
			try{
				//通过城市名称查找操作
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 

				//String hql="from QuestionInfo where questionName like '%"+questionName+"%'";
				//通过questionName模糊查询
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
				//通过城市名称查找操作
				Session session = HibernateUtils.openSession();
				Transaction transaction = session.beginTransaction(); 
			

				//String hql="from QuestionInfo where questionName like '%"+questionName+"%' order by questionOrder ASC";
				//通过questionName模糊查询
				//Query query = session.createQuery(hql);	//获得query对象
				Criteria criteria = session.createCriteria(QuestionInfo.class);
				criteria.add(Restrictions.like("questionContent", "%"+questionName+"%"));
				
					
//				query.setFirstResult((pageNum-1)*pageSize);//查询结果 第一条数据是(pageNum-1)*pageSize
//				query.setMaxResults(pageSize);//从(pageNum-1)*pageSize 开始 查询 10 条记录 
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
		Query query = session.createQuery(hql);	//获得query对象
		List<QuestionInfo> list = query.list();
		for(QuestionInfo questionInfo : list){
		}

		transaction.commit();
		session.close();
		
		return list;
	}
	
	/**
	 * 最新问题
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
	 * 得到分页查询总记录数
	 */
	public int getQuestionInfoAmount(){
		//通过HQL查找操作
			try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
			
			String hql="from QuestionInfo";
			Query query = session.createQuery(hql);	//获得query对象	

			List<QuestionInfo> questionInfos = query.list();	//执行查询		
			transaction.commit();
			session.close();
			return questionInfos.size();
			}catch(Exception e){
				throw new RuntimeException(e);
			}
	}
	
	/**
	 * 分页操作
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<QuestionInfo> findPage(int pageNum,int pageSize){
		//通过HQL查找操作
		try{
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		
		String hql="from QuestionInfo order by questionOrder ASC";
		Query query = session.createQuery(hql);	//获得query对象
		
		query.setFirstResult((pageNum-1)*pageSize);//查询结果 第一条数据是(pageNum-1)*pageSize
		query.setMaxResults(pageSize);//从(pageNum-1)*pageSize 开始 查询 10 条记录 

		List<QuestionInfo> questionInfos = query.list();	//执行查询		
		

		
		
		transaction.commit();
		session.close();
		return questionInfos;
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
