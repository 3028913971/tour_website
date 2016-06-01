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
 * QuestionInfo�����ݷ�����
 * @author Sandm
 *
 */

public class QuestionInfoDAO {

	int questionAmount = 0 ;
	
	public QuestionInfoDAO() {
		super();
	}

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<QuestionInfo> findAll() {
		//ͨ��HQL���Ҳ���
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
				
			String hql="from QuestionInfo order by questionOrder ASC";
			Query query = session.createQuery(hql);	//���query����
			

			List<QuestionInfo> questionInfos = query.list();//ִ�в�ѯ	
			this.questionAmount = questionInfos.size();
				
				
				
			transaction.commit();
			session.close();
			return questionInfos;
				
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��ҳ�����²�ѯ����
	 * @return
	 */
	public List<QuestionInfo> findAll(int pageNum, int pageSize) {
		//ͨ��HQL���Ҳ���
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
						
			String hql="from QuestionInfo";
			Query query = session.createQuery(hql);	//���query����
			query.setFirstResult((pageNum-1)*pageSize);
			query.setMaxResults(pageSize);
					

			List<QuestionInfo> questionInfos = query.list();//ִ�в�ѯ
						
						
						
			transaction.commit();
			session.close();
			return questionInfos;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	
	public List<QuestionInfo> findByquestionName(String questionName){
		
		try{
			//ͨ���������Ʋ��Ҳ���
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
		

			String hql="from QuestionInfo where questionName='"+questionName+"'";
			List<QuestionInfo> list = this.questionInfoFindByHQL(hql);
			Query query = session.createQuery(hql);	//���query����
			List<QuestionInfo> question = query.list();
			
			transaction.commit();
			session.close();
			return question;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<QuestionInfo> questionInfoFindByHQL(String hql){
		//ͨ��HQL���Ҳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
	

		Query query = session.createQuery(hql);	//���query����

		List<QuestionInfo> questionInfos = query.list();	//ִ�в�ѯ		

		transaction.commit();
		session.close();
		return questionInfos;
	}
	
	
	/**
	 * �������
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
	 * ɾ��������Ϣ
	 * @param questionId
	 */
	public void delete(int questionId) {
		//ɾ������
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
		QuestionInfo questionInfo = new QuestionInfo();
		questionInfo.setQuestionId(questionId);
		session.delete(questionInfo);		
		transaction.commit();
		session.close();
	}

	/**
	 * �����ض����������
	 * @param questionId
	 * @return
	 */
	public QuestionInfo load(int questionId) {
		//ͨ��HQL���Ҳ���
		try{
			Session session = HibernateUtils.openSession();
			Transaction transaction = session.beginTransaction(); 
						
			String hql="from QuestionInfo where questionId="+questionId;
			Query query = session.createQuery(hql);	//���query����
					

			QuestionInfo questionInfo = (QuestionInfo)query.list().get(0);	//ִ�в�ѯ		
						
						
						
			transaction.commit();
			session.close();
			return questionInfo;
						
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * �޸Ĳ���
	 * @param question
	 */
	public void edit(QuestionInfo question) {
		//�޸Ĳ���
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction(); 
				
		session.update(question);
		
		transaction.commit();
		session.close();
	}

	/**
	 * ��ѯ����
	 * @param criteria
	 * @return
	 */
	public List<QuestionInfo> query(QuestionInfo criteria) {
		//ͨ��HQL���Ҳ���
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
			
			Query query = session.createQuery(hql.toString());	//���query����
					

			List<QuestionInfo> questionInfos = query.list();	//ִ�в�ѯ	
			this.questionAmount = questionInfos.size();//����������������
						
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
	 * ��ҳ�����²�ѯ����
	 * @param criteria
	 * @return
	 */
	public List<QuestionInfo> query(QuestionInfo criteria, int pageNum, int pageSize) {
		//ͨ��HQL���Ҳ���
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
					
					Query query = session.createQuery(hql.toString());	//���query����
					query.setFirstResult((pageNum-1)*pageSize);
					query.setMaxResults(pageSize);

					List<QuestionInfo> questionInfos = query.list();	//ִ�в�ѯ
					
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
	 * ��ȡ��������
	 * @return
	 */
	public int getQuestionAmount() {
		findAll();
		return this.questionAmount;
	}

	/**
	 * ��ȡ���ϲ�ѯ��������������
	 * @param model
	 * @return
	 */
	public int getQuestionAmount(QuestionInfo model) {
		query(model);
		return this.questionAmount;
	}

	
	
}
