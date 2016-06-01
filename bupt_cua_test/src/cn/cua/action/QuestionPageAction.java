package cn.cua.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.QuestionInfo;
import cn.cua.service.QuestionPageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuestionPageAction extends ActionSupport implements ModelDriven<QuestionInfo> {
	private QuestionPageService wendaService = new QuestionPageService();
	private QuestionInfo model = new QuestionInfo();
	
	private String quesCont;
	
	
	public String getQuesCont() {
		return quesCont;
	}


	public void setQuesCont(String quesCont) {
		this.quesCont = quesCont;
	}

	private int pageNum;
	private int totalpage;
	private int pageSize;
	
	
	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getTotalpage() {
		return totalpage;
	}


	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * 分页操作之一
	 * @return
	 */
	public String page(){
		pageSize = 15;
		int questionInfoAmount = wendaService.getQuestionInfoAmount();
		this.totalpage = questionInfoAmount%pageSize==0?(questionInfoAmount/pageSize):(questionInfoAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "page";
	}
	
	/**
	 * 分页操作之二
	 * @return
	 */
	public String findPage() throws Exception{
		ActionContext.getContext().getValueStack().push(wendaService.findPage(pageNum, pageSize));
		return "list";
	}
	/**
	 * 通过问题名查询
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	
	public String pageQuestion() throws UnsupportedEncodingException{
		pageSize = 15;
		quesCont = new String(this.quesCont.getBytes("ISO-8859-1"),"utf-8");	
		int userAmount = wendaService.getQuestionAmount(quesCont);
		//ServletActionContext.getRequest().getSession().setAttribute("str", str);
		
		this.totalpage = userAmount%pageSize==0?(userAmount/pageSize):(userAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuestion";
	}	
	public String pageQuestion1() throws UnsupportedEncodingException{
		pageSize = 15;
		//String str = (String)ServletActionContext.getRequest().getSession().getAttribute("str");
		quesCont = new String(this.quesCont.getBytes("ISO-8859-1"),"utf-8");
		int userAmount = wendaService.getQuestionAmount(quesCont);
		//ServletActionContext.getRequest().getSession().setAttribute("str", str);

		this.totalpage = userAmount%pageSize==0?(userAmount/pageSize):(userAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuestion";
	}
	
	public String query() throws UnsupportedEncodingException{
		//String str = (String)ServletActionContext.getRequest().getSession().getAttribute("str");
		quesCont = new String(this.quesCont.getBytes("ISO-8859-1"),"utf-8");
		ActionContext.getContext().getValueStack().push(wendaService.query(quesCont, pageNum, pageSize));
		return "listQuery";
	}
	

	public QuestionInfo getModel() {
		return model;
	}
	
	public static void main(String[] args) throws Exception {
		QuestionPageAction wa =new QuestionPageAction();

	}

}
