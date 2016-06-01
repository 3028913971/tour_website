package cn.cua.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.cua.domain.AdminInfo;
import cn.cua.domain.QuestionInfo;
import cn.cua.log4j.LogControler;
import cn.cua.utils.HibernateUtils;

/**
 * QuestionInfo的数据访问类
 * @author Sandm
 *
 */

public class QuestionInfoDAO {

	int questionAmount = 0 ;
	
	public QuestionInfoDAO() {
		super();
	}

	/**
	 * 查询所有
	 * @return
	 */
	public List<QuestionInfo> findAll() {
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
				
			String hql="from QuestionInfo order by questionOrder ASC";
			Query query = session.createQuery(hql);	//获得query对象
			

			List<QuestionInfo> questionInfos = query.list();//执行查询	
			this.questionAmount = questionInfos.size();
				
				
				
			transaction.commit();
			session.close();
			return questionInfos;
				
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 分页操作下查询所有
	 * @return
	 */
	public List<QuestionInfo> findAll(int pageNum, int pageSize) {
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
						
			String hql="from QuestionInfo";
			Query query = session.createQuery(hql);	//获得query对象
			query.setFirstResult((pageNum-1)*pageSize);
			query.setMaxResults(pageSize);
					

			List<QuestionInfo> questionInfos = query.list();//执行查询
						
						
						
			transaction.commit();
			session.close();
			return questionInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	
	public List<QuestionInfo> findByquestionName(String questionName){
		
		try{
			//通过问题名称查找操作
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
		

			String hql="from QuestionInfo where questionName='"+questionName+"'";
			List<QuestionInfo> list = this.questionInfoFindByHQL(hql);
			Query query = session.createQuery(hql);	//获得query对象
			List<QuestionInfo> question = query.list();
			
			transaction.commit();
			session.close();
			return question;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<QuestionInfo> questionInfoFindByHQL(String hql){
		//通过HQL查找操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
	

		Query query = session.createQuery(hql);	//获得query对象

		List<QuestionInfo> questionInfos = query.list();	//执行查询		

		transaction.commit();
		session.close();
		return questionInfos;
	}
	
	
	/**
	 * 添加问题
	 * @param question
	 */
	public void add(QuestionInfo question) {

		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		session.save(question);
		transaction.commit();
		session.close();
	}

	/**
	 * 删除问题信息
	 * @param questionId
	 */
	public void delete(int questionId) {
		//删除操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		QuestionInfo questionInfo = new QuestionInfo();
		questionInfo.setQuestionId(questionId);
		session.delete(questionInfo);		
		transaction.commit();
		session.close();
	}

	/**
	 * 加载特定的问题对象
	 * @param questionId
	 * @return
	 */
	public QuestionInfo load(int questionId) {
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
						
			String hql="from QuestionInfo where questionId="+questionId;
			Query query = session.createQuery(hql);	//获得query对象
					

			QuestionInfo questionInfo = (QuestionInfo)query.list().get(0);	//执行查询		
						
						
						
			transaction.commit();
			session.close();
			return questionInfo;
						
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改操作
	 * @param question
	 */
	public void edit(QuestionInfo question) {
		//修改操作
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
				
		session.update(question);
		
		transaction.commit();
		session.close();
	}

	/**
	 * 查询问题
	 * @param criteria
	 * @return
	 */
	public List<QuestionInfo> query(QuestionInfo criteria) {
		//通过HQL查找操作
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
						
			StringBuilder hql = new StringBuilder("from QuestionInfo where 1=1");
			
			String questionName = criteria.getQuestionName();
			if(questionName != null && !questionName.trim().isEmpty()){
				hql.append(" and questionName like '%" + questionName +"%'");
			}
			
			String questionContent = criteria.getQuestionContent();
			if(questionContent != null && !questionContent.trim().isEmpty()){
				hql.append(" and questionContent like '%" + questionContent +"%'");
			}
			
			Query query = session.createQuery(hql.toString());	//获得query对象
					

			List<QuestionInfo> questionInfos = query.list();	//执行查询	
			this.questionAmount = questionInfos.size();//符合条件的问题数
						
			for(QuestionInfo questionInfo : questionInfos){
			}
						
						
			transaction.commit();
			session.close();
			return questionInfos;
						
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 分页操作下查询问题
	 * @param criteria
	 * @return
	 */
	public List<QuestionInfo> query(QuestionInfo criteria, int pageNum, int pageSize) {
		//通过HQL查找操作
				try{
					Session session = HibernateUtils.openSession();
					Transaction transaction = session.beginTransaction(); 
								
					StringBuilder hql = new StringBuilder("from QuestionInfo where 1=1");
					
					String questionName = criteria.getQuestionName();
					if(questionName != null && !questionName.trim().isEmpty()){
						hql.append(" and questionName like '%" + questionName +"%'");
					}
					
					String questionContent = criteria.getQuestionContent();
					if(questionContent != null && !questionContent.trim().isEmpty()){
						hql.append(" and questionContent like '%" + questionContent +"%'");
					}
					
					Query query = session.createQuery(hql.toString());	//获得query对象
					query.setFirstResult((pageNum-1)*pageSize);
					query.setMaxResults(pageSize);

					List<QuestionInfo> questionInfos = query.list();	//执行查询
					
					for(QuestionInfo questionInfo : questionInfos){
					}
								
								
					transaction.commit();
					session.close();
					return questionInfos;
								
				}catch(Exception e){
					throw new RuntimeException(e);
				}
	}


	/**
	 * 获取问题总数
	 * @return
	 */
	public int getQuestionAmount() {
		findAll();
		return this.questionAmount;
	}

	/**
	 * 获取符合查询条件的问题总数
	 * @param model
	 * @return
	 */
	public int getQuestionAmount(QuestionInfo model) {
		query(model);
		return this.questionAmount;
	}

	
	
}
