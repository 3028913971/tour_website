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
 * QuestionAction类
 * @author Sandm
 *
 */
public class QuestionAction extends ActionSupport implements ModelDriven<QuestionInfo>{

	private QuestionInfo model = new QuestionInfo();//手动实例化
	private QuestionService questionService = new QuestionService();
	
	private int pageNum;//当前页数
	private int totalPage;//总页数
	private int pageSize;//每页问题数
	private int ps = 30;//每页问题数修改
	private List<QuestionInfo> quesInfos = new ArrayList<QuestionInfo>();

	private String quesName;//问题名称
	private String quesContent;//回答内容

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
	 * 对所有问题的分页操作
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
	 * 对符合相应查询条件问题的分页操作
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
	 * 对符合相应查询条件问题的分页操作1
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
	 * 不分页修改顺序
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
	 * 显示所有问题
	 * 1.通过QuestionService的findAll方法返回List<Question>
	 * 2.保存到ValueStack中
	 * 3.在question_list页面中用<s:iterator>标签显示
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.findAll(pageNum,pageSize));
		return "list";
	}
	
	/**
	 * 显示所有符合查询条件的问题
	 * 1.通过QuestionService的findAll方法返回List<Question>
	 * 2.保存到ValueStack中
	 * 3.在question_list页面中用<s:iterator>标签显示
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
	 * 添加问题
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
	 * 删除问题信息
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
	 * 加载特定的问题信息以便编辑
	 * @return
	 * @throws Exception
	 */
	public String loadForEdit() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.load(model.getQuestionId()));
		return "edit";
	}
	
	/**
	 * 修改相应的问题信息
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
	 * 修改问题的顺序
	 * @return
	 * @throws Exception
	 */
	/*public String editOrder() throws Exception {
		return "editOrderComplete";
	}*/
	
	/**
	 * 将特定的问题信息顺序前移一位 ——顺序数减1
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="forwardOrderInput")
	public String forwardOrder() throws Exception{
		List<QuestionInfo> qInfos = questionService.findAll();
		int pos = locateElem(qInfos,model.getQuestionId());
		
		
		//将当前问题顺序减1
		QuestionInfo qInfo = questionService.load(model.getQuestionId());
		qInfo.setQuestionOrder(model.getQuestionOrder()-1);
		questionService.edit(qInfo);
		
		//将前一个问题顺序改为当前顺序
		int qId = qInfos.get(pos-1).getQuestionId();
		QuestionInfo qInfo2 = questionService.load(qId);
		qInfo2.setQuestionOrder(model.getQuestionOrder());
		questionService.edit(qInfo2);
		
		return "editOrderComplete";
	}
	
	
	public void validateForwardOrder(){
		if(model.getQuestionOrder()<=1){
			this.addActionError("已经是最上一个！！");
		}
	}
	
	/**
	 * 将特定的问题信息顺序后移一位
	 * @return
	 * @throws Exception
	 */
	@InputConfig(resultName="backwardOrderInput")
	public String backwardOrder() throws Exception {
		List<QuestionInfo> qInfos = questionService.findAll();
		int pos = locateElem(qInfos,model.getQuestionId());
		
		//将当前问题顺序加1
		QuestionInfo qInfo = questionService.load(model.getQuestionId());
		qInfo.setQuestionOrder(model.getQuestionOrder()+1);
		questionService.edit(qInfo);
		
		//将前一个问题顺序改为当前顺序
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
			this.addActionError("已经是最后一个！！");
		}
	}
	
	/**
	 * 根据Id确认在列表中的位置
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
	 * 根据对应条件组合查询问题信息
	 * @return
	 * @throws Exception
	 */
	/*public String query() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.query(model));
		return "list";
	}*/
	
	/**
	 * 查看问题信息
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		ActionContext.getContext().getValueStack().push(questionService.load(model.getQuestionId()));
		return "view";
	}
}
