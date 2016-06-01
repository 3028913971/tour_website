package cn.cua.service;

import java.util.List;

import cn.cua.dao.QuestionInfoDAO;
import cn.cua.domain.AdminInfo;
import cn.cua.domain.QuestionInfo;
/**
 * QuestionInfo的业务类
 * @author Sandm
 *
 */
public class QuestionService {
	
	private QuestionInfoDAO questionInfoDao = new QuestionInfoDAO();

	
	public QuestionService() {
		super();
	}

	/**
	 * 查询所有问题
	 * @return
	 */
	public List<QuestionInfo> findAll(){
		return questionInfoDao.findAll();
	}
	
	/**
	 * 分页操作下查询所有问题
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<QuestionInfo> findAll(int pageNum, int pageSize) {
		return questionInfoDao.findAll(pageNum,pageSize);
	}
	
	
	
	/**
	 * 查询分页操作下查询所有问题
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<QuestionInfo> queryFindAll(QuestionInfo model, int pageNum, int pageSize) {
		return questionInfoDao.query(model,pageNum,pageSize);
	}

	/**
	 * 添加问题信息
	 * @param question
	 * @throws QuestionException 
	 */
	public void add(QuestionInfo question) throws QuestionException {
		
		List<QuestionInfo> questionList = questionInfoDao.findByquestionName(question.getQuestionName());
		if(questionList.size() != 0){
			throw new QuestionException("该问题已存在，请更换问题！");
		}else{
			questionInfoDao.add(question);
		}			
	}


	/**
	 * 删除问题信息
	 * @param questionId
	 */
	public void delete(int questionId) {
		questionInfoDao.delete(questionId);
	}

	/**
	 * 加载特定的问题信息
	 * @param questionId
	 * @return
	 */
	public QuestionInfo load(int questionId) {
		return questionInfoDao.load(questionId);
	}


	/**
	 * 修改问题信息
	 * @param question
	 * @throws QuestionException 
	 */
	public void edit(QuestionInfo criteria) throws QuestionException {
		
		List<QuestionInfo> questionList = questionInfoDao.findByquestionName(criteria.getQuestionName());
		if(questionList.size() != 0 && questionList.get(0).getQuestionId() != criteria.getQuestionId()){
			throw new QuestionException("该问题已存在，请更换问题！");
		}else{
			questionInfoDao.edit(criteria);
		}				
	}


	/**
	 * 查询问题
	 * @param question
	 * @return
	 */
	/*public List<QuestionInfo> query(QuestionInfo question) {
		return questionInfoDao.query(question);
	}*/

	/**
	 * 获取问题总数
	 * @return
	 */
	public int getQuestionAmount() {
		return questionInfoDao.getQuestionAmount();
	}

	/**
	 * 获取符合查询条件的问题总数
	 * @param model
	 * @return
	 */
	public int getQuestionAmount(QuestionInfo model) {
		return questionInfoDao.getQuestionAmount(model);
	}

	

	

	
}
