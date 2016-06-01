package cn.cua.service;

import java.util.List;

import cn.cua.dao.QuestionPageDAO;
import cn.cua.domain.QuestionInfo;

/**
 * 指路问答业务类
 * @author LI AO
 *
 */
public class QuestionPageService {
	
	private QuestionPageDAO wendaDAO = new QuestionPageDAO();
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<QuestionInfo> findAll(){
		return wendaDAO.findAll();
	}
	
	/**
	 * 分页操作之一，得到分页总数
	 * @return
	 */
	public int getQuestionInfoAmount(){
		return wendaDAO.getQuestionInfoAmount();
	}
	
	/**
	 * 分页操作之二，得到分页条件
	 */
	public List<QuestionInfo> findPage(int pageNum,int pageSize){
		return wendaDAO.findPage(pageNum, pageSize);
	}
	

	
	public int getQuestionAmount(String questionName){
		return wendaDAO.getQuestionAmount(questionName);
	}
	
	public List<QuestionInfo> query(String questionName,int pageNum, int pageSize){
		return wendaDAO.query(questionName, pageNum, pageSize);
	}
}
