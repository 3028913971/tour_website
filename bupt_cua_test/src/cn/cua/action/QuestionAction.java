package cn.cua.action;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import cn.cua.domain.QuestionInfo;
import cn.cua.service.AdminException;
import cn.cua.service.QuestionException;
import cn.cua.service.QuestionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * QuestionAction��
 * @author Sandm
 *
 */
public class QuestionAction extends ActionSupport implements ModelDriven<QuestionInfo>{

	private QuestionInfo model = new QuestionInfo();//�ֶ�ʵ����
	private QuestionService questionService = new QuestionService();
	
	private int pageNum;//��ǰҳ��
	private int totalPage;//��ҳ��
	private int pageSize;//ÿҳ������
	private int ps = 30;//ÿҳ�������޸�
	private List<QuestionInfo> quesInfos = new ArrayList<QuestionInfo>();

	private String quesName;//��������
	private String quesContent;//�ش�����

	public QuestionInfo getModel() {
		return this.model;
	}
	
	public void setModel(QuestionInfo model) {
		this.model = model;
	}
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

	public List<QuestionInfo> getQuesInfos() {
		return quesInfos;
	}

	public void setQuesInfos(List<QuestionInfo> quesInfos) {
		this.quesInfos = quesInfos;
	}

	public String getQuesName() {
		return quesName;
	}

	public String getQuesContent() {
		return quesContent;
	}

	public void setQuesName(String quesName) {
		this.quesName = quesName;
	}

	public void setQuesContent(String quesContent) {
		this.quesContent = quesContent;
	}

	/**
	 * ����������ķ�ҳ����
	 * @return
	 * @throws Exception
	 */
	public String page() throws Exception {
		int questionAmount = questionService.getQuestionAmount();
		if(questionAmount==0){
			return "pageFailed";
		}
		this.pageSize = this.ps;
		this.totalPage = (questionAmount % pageSize==0)?(questionAmount/pageSize):(questionAmount/pageSize+1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "page";
	}
	
	/**
	 * �Է�����Ӧ��ѯ��������ķ�ҳ����
	 * @return
	 * @throws Exception
	 */
	public String queryPage() throws Exception {
		model.setQuestionName(quesName);
		model.setQuestionContent(quesContent);
		int questionAmount = questionService.getQuestionAmount(model);
		this.pageSize = this.ps;
		this.totalPage = (questionAmount % pageSize==0)?(questionAmount/pageSize):(questionAmount/pageSize+1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "queryPage";
	}
	
	/**
	 * �Է�����Ӧ��ѯ��������ķ�ҳ����1
	 * @return
	 * @throws Exception
	 */
	public String queryPage1() throws Exception {
		quesName= new String(quesName.getBytes("ISO-8859-1"),"UTF-8");
		quesContent= new String(quesContent.getBytes("ISO-8859-1"),"UTF-8");
		model.setQuestionName(quesName);
		model.setQuestionContent(quesContent);
		int questionAmount = questionService.getQuestionAmount(model);
		this.pageSize = this.ps;
		this.totalPage = (questionAmount % pageSize==0)?(questionAmount/pageSize):(questionAmount/pageSize+1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "queryPage1";
	}
	
	/**
	 * ����ҳ�޸�˳��
	 * @return
	 * @throws Exception
	 */
	public String findAllForEditOrder() throws Exception {
		List<QuestionInfo> qInfos = questionService.findAll();
		ActionContext.getContext().getValueStack().push(qInfos);
		Integer size = qInfos.size();
		if(size==0){
			return "listForEditOrderFailed";
		}
		return "listForEditOrder";
	}
	
	/**
	 * ��ʾ��������
	 * 1.ͨ��QuestionService��findAll��������List<Question>
	 * 2.���浽ValueStack��
	 * 3.��question_listҳ������<s:iterator>��ǩ��ʾ
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.findAll(pageNum,pageSize));
		return "list";
	}
	
	/**
	 * ��ʾ���з��ϲ�ѯ����������
	 * 1.ͨ��QuestionService��findAll��������List<Question>
	 * 2.���浽ValueStack��
	 * 3.��question_listҳ������<s:iterator>��ǩ��ʾ
	 * @return
	 * @throws Exception
	 */
	public String queryFindAll() throws Exception {
		quesName= new String(quesName.getBytes("ISO-8859-1"),"UTF-8");
		quesContent= new String(quesContent.getBytes("ISO-8859-1"),"UTF-8");
		model.setQuestionName(quesName);
		model.setQuestionContent(quesContent);
		ActionContext.getContext().getValueStack().push(questionService.queryFindAll(model,pageNum,pageSize));
		return "queryList";
	}
	
	/*public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.findAll());
		return "list";
	}*/
	
	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		model.setQuestionTime(new Date(System.currentTimeMillis()).toLocaleString());
		model.setQuestionOrder(questionService.findAll().size()+1);
		
		try {		
			questionService.add(model);
			return "editSucc";
		} catch (QuestionException e) {
			this.addActionError(e.getMessage());
			return "add";
		}
		
	}
	
	/**
	 * ɾ��������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		List<QuestionInfo> qInfos = questionService.findAll();
		int pos = locateElem(qInfos, model.getQuestionId());
		for(int i=qInfos.size()-1;i>pos;i--){
			QuestionInfo qInfo = qInfos.get(i);
			qInfo.setQuestionOrder(qInfo.getQuestionOrder()-1);
			questionService.edit(qInfo);
		}
		questionService.delete(model.getQuestionId());
		return "editSucc";
	}
	
	/**
	 * �����ض���������Ϣ�Ա�༭
	 * @return
	 * @throws Exception
	 */
	public String loadForEdit() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.load(model.getQuestionId()));
		return "edit";
	}
	
	/**
	 * �޸���Ӧ��������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		model.setQuestionTime(new Date(System.currentTimeMillis()).toLocaleString());
		
		try {		
			questionService.edit(model);
			return "editSucc";
		} catch (QuestionException e) {
			this.addActionError(e.getMessage());
			return "edit";
		}
		
	}
	/**
	 * �޸������˳��
	 * @return
	 * @throws Exception
	 */
	/*public String editOrder() throws Exception {
		return "editOrderComplete";
	}*/
	
	/**
	 * ���ض���������Ϣ˳��ǰ��һλ ����˳������1
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="forwardOrderInput")
	public String forwardOrder() throws Exception{
		List<QuestionInfo> qInfos = questionService.findAll();
		int pos = locateElem(qInfos,model.getQuestionId());
		
		
		//����ǰ����˳���1
		QuestionInfo qInfo = questionService.load(model.getQuestionId());
		qInfo.setQuestionOrder(model.getQuestionOrder()-1);
		questionService.edit(qInfo);
		
		//��ǰһ������˳���Ϊ��ǰ˳��
		int qId = qInfos.get(pos-1).getQuestionId();
		QuestionInfo qInfo2 = questionService.load(qId);
		qInfo2.setQuestionOrder(model.getQuestionOrder());
		questionService.edit(qInfo2);
		
		return "editOrderComplete";
	}
	
	
	public void validateForwardOrder(){
		if(model.getQuestionOrder()<=1){
			this.addActionError("�Ѿ�������һ������");
		}
	}
	
	/**
	 * ���ض���������Ϣ˳�����һλ
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="backwardOrderInput")
	public String backwardOrder() throws Exception {
		List<QuestionInfo> qInfos = questionService.findAll();
		int pos = locateElem(qInfos,model.getQuestionId());
		
		//����ǰ����˳���1
		QuestionInfo qInfo = questionService.load(model.getQuestionId());
		qInfo.setQuestionOrder(model.getQuestionOrder()+1);
		questionService.edit(qInfo);
		
		//��ǰһ������˳���Ϊ��ǰ˳��
		int qId = qInfos.get(pos+1).getQuestionId();
		QuestionInfo qInfo2 = questionService.load(qId);
		qInfo2.setQuestionOrder(model.getQuestionOrder());
		questionService.edit(qInfo2);
		
		return "editOrderComplete";
	}
	
	public void validateBackwardOrder(){
		List<QuestionInfo> qInfos = questionService.findAll();
		Integer size=(Integer)qInfos.size();
		if(model.getQuestionOrder()>=size.intValue()){
			this.addActionError("�Ѿ������һ������");
		}
	}
	
	/**
	 * ����Idȷ�����б��е�λ��
	 * @param qInfos
	 * @param qId
	 * @return
	 */
	public int locateElem(List<QuestionInfo> qInfos, int qId){
		for(int i=0;i<qInfos.size();i++){
			if(qId==qInfos.get(i).getQuestionId()){
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * ���ݶ�Ӧ������ϲ�ѯ������Ϣ
	 * @return
	 * @throws Exception
	 */
	/*public String query() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.query(model));
		return "list";
	}*/
	
	/**
	 * �鿴������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.load(model.getQuestionId()));
		return "view";
	}
}
