package cn.cua.service;

import java.util.List;

import cn.cua.dao.QuestionInfoDAO;
import cn.cua.domain.AdminInfo;
import cn.cua.domain.QuestionInfo;
/**
 * QuestionInfo��ҵ����
 * @author Sandm
 *
 */
public class QuestionService {
	
	private QuestionInfoDAO questionInfoDao = new QuestionInfoDAO();

	
	public QuestionService() {
		super();
	}

	/**
	 * ��ѯ��������
	 * @return
	 */
	public List<QuestionInfo> findAll(){
		return questionInfoDao.findAll();
	}
	
	/**
	 * ��ҳ�����²�ѯ��������
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<QuestionInfo> findAll(int pageNum, int pageSize) {
		return questionInfoDao.findAll(pageNum,pageSize);
	}
	
	
	
	/**
	 * ��ѯ��ҳ�����²�ѯ��������
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<QuestionInfo> queryFindAll(QuestionInfo model, int pageNum, int pageSize) {
		return questionInfoDao.query(model,pageNum,pageSize);
	}

	/**
	 * ���������Ϣ
	 * @param question
	 * @throws QuestionException 
	 */
	public void add(QuestionInfo question) throws QuestionException {
		
		List<QuestionInfo> questionList = questionInfoDao.findByquestionName(question.getQuestionName());
		if(questionList.size() != 0){
			throw new QuestionException("�������Ѵ��ڣ���������⣡");
		}else{
			questionInfoDao.add(question);
		}			
	}


	/**
	 * ɾ��������Ϣ
	 * @param questionId
	 */
	public void delete(int questionId) {
		questionInfoDao.delete(questionId);
	}

	/**
	 * �����ض���������Ϣ
	 * @param questionId
	 * @return
	 */
	public QuestionInfo load(int questionId) {
		return questionInfoDao.load(questionId);
	}


	/**
	 * �޸�������Ϣ
	 * @param question
	 * @throws QuestionException 
	 */
	public void edit(QuestionInfo criteria) throws QuestionException {
		
		List<QuestionInfo> questionList = questionInfoDao.findByquestionName(criteria.getQuestionName());
		if(questionList.size() != 0 && questionList.get(0).getQuestionId() != criteria.getQuestionId()){
			throw new QuestionException("�������Ѵ��ڣ���������⣡");
		}else{
			questionInfoDao.edit(criteria);
		}				
	}


	/**
	 * ��ѯ����
	 * @param question
	 * @return
	 */
	/*public List<QuestionInfo> query(QuestionInfo question) {
		return questionInfoDao.query(question);
	}*/

	/**
	 * ��ȡ��������
	 * @return
	 */
	public int getQuestionAmount() {
		return questionInfoDao.getQuestionAmount();
	}

	/**
	 * ��ȡ���ϲ�ѯ��������������
	 * @param model
	 * @return
	 */
	public int getQuestionAmount(QuestionInfo model) {
		return questionInfoDao.getQuestionAmount(model);
	}

	

	

	
}
