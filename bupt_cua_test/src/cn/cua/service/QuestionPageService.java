package cn.cua.service;

import java.util.List;

import cn.cua.dao.QuestionPageDAO;
import cn.cua.domain.QuestionInfo;

/**
 * ָ·�ʴ�ҵ����
 * @author LI AO
 *
 */
public class QuestionPageService {
	
	private QuestionPageDAO wendaDAO = new QuestionPageDAO();
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<QuestionInfo> findAll(){
		return wendaDAO.findAll();
	}
	
	/**
	 * ��ҳ����֮һ���õ���ҳ����
	 * @return
	 */
	public int getQuestionInfoAmount(){
		return wendaDAO.getQuestionInfoAmount();
	}
	
	/**
	 * ��ҳ����֮�����õ���ҳ����
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
