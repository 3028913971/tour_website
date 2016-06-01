package cn.cua.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TravelNoteInfo;
import cn.cua.service.TravelNoteService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * TravelNoteAction类
 * @author Sandm
 *
 */
public class TravelNoteAction extends ActionSupport implements ModelDriven<TravelNoteInfo>{

	private TravelNoteInfo model = new TravelNoteInfo();
	private TravelNoteService tNoteService = new TravelNoteService();
	
	private int pageNum;//当前页数
	private int totalPage;//总页数
	private int pageSize;//每页问题数
	private int ps = 30;//每页问题数修改
	
	private String tnName;//游记名称
	private String tnStatus;//游记审核状态
	private String tnIsTop;//是否上首页
	private String tnCityName;//游玩城市
	
	public TravelNoteInfo getModel() {
		return model;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}



	public int getPageSize() {
		return pageSize;
	}



	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}



	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}



	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getTnName() {
		return tnName;
	}

	public String getTnStatus() {
		return tnStatus;
	}

	public String getTnIsTop() {
		return tnIsTop;
	}

	public String getTnCityName() {
		return tnCityName;
	}

	public void setTnName(String tnName) {
		this.tnName = tnName;
	}

	public void setTnStatus(String tnStatus) {
		this.tnStatus = tnStatus;
	}

	public void setTnIsTop(String tnIsTop) {
		this.tnIsTop = tnIsTop;
	}

	public void setTnCityName(String tnCityName) {
		this.tnCityName = tnCityName;
	}

	/**
	 * 对所有问题的分页操作
	 * @return
	 * @throws Exception
	 */
	public String page() throws Exception {
		int tNoteAmount = tNoteService.getTNoteAmount();
		if(tNoteAmount==0){
			return "pageFailed";
		}
		this.pageSize = this.ps;
		this.totalPage = (tNoteAmount % pageSize==0)?(tNoteAmount/pageSize):(tNoteAmount/pageSize+1);
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
		model.setCityName(tnCityName);
		model.setIsTop(tnIsTop);
		model.setStatus(tnStatus);
		model.setTravelNoteName(tnName);
		int tNoteAmount = tNoteService.getTNoteAmount(model);
		this.pageSize = this.ps;
		this.totalPage = (tNoteAmount % pageSize==0)?(tNoteAmount/pageSize):(tNoteAmount/pageSize+1);
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
		tnCityName = new String(tnCityName.getBytes("ISO-8859-1"),"UTF-8");
		tnIsTop = new String(tnIsTop.getBytes("ISO-8859-1"),"UTF-8");
		tnStatus = new String(tnStatus.getBytes("ISO-8859-1"),"UTF-8");
		tnName = new String(tnName.getBytes("ISO-8859-1"),"UTF-8");
		model.setCityName(tnCityName);
		model.setIsTop(tnIsTop);
		model.setStatus(tnStatus);
		model.setTravelNoteName(tnName);
		int tNoteAmount = tNoteService.getTNoteAmount(model);
		this.pageSize = this.ps;
		this.totalPage = (tNoteAmount % pageSize==0)?(tNoteAmount/pageSize):(tNoteAmount/pageSize+1);
		if(this.pageNum <= 0){
			this.pageNum = 1;
		}
		if(this.pageNum > totalPage ){
			this.pageNum = totalPage;
		}
		return "queryPage1";
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
		ActionContext.getContext().getValueStack().push(tNoteService.findAll(pageNum,pageSize));
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
	public String queryFindAll() throws Exception{
		tnCityName = new String(tnCityName.getBytes("ISO-8859-1"),"UTF-8");
		tnIsTop = new String(tnIsTop.getBytes("ISO-8859-1"),"UTF-8");
		tnStatus = new String(tnStatus.getBytes("ISO-8859-1"),"UTF-8");
		tnName = new String(tnName.getBytes("ISO-8859-1"),"UTF-8");
		model.setCityName(tnCityName);
		model.setIsTop(tnIsTop);
		model.setStatus(tnStatus);
		model.setTravelNoteName(tnName);
		ActionContext.getContext().getValueStack().push(tNoteService.queryFindAll(model,pageNum,pageSize));
		return "queryList";
	}


	/**
	 * 显示所有游记信息
	 * @return
	 * @throws Exception
	 */
	/*public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.findAll());
		return "list";
	}*/

	/**
	 * 查看特定的游记信息
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		//将游记信息压入值栈
		ActionContext.getContext().getValueStack().push(tNoteService.load(model.getTravelNoteId()));
		//将游记相关图片路径压入值栈
		//ActionContext.getContext().getValueStack().push(tNoteService.loadPhoto(model.getTravelNoteId()));
		return "view";
	}
	
	/**
	 * 删除特定的游记信息
	 * 1.如果对应的游记有图片，则取到图片的存储名并删除
	 * 2.删除相应的游记及游记图片信息
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String imgpath = ServletActionContext.getServletContext().getRealPath("/images/travelNotes");
		List<String> tNotePhotoRealNames = tNoteService.loadPhoto(model.getTravelNoteId());
		if(!tNotePhotoRealNames.isEmpty()){
			for(String s:tNotePhotoRealNames){
				File file = new File(imgpath,s);
				file.delete();
			}
		}
		tNoteService.delete(model.getTravelNoteId());
		return "editSucc";
	}
	
	/**
	 * 加载游记信息以便修改
	 * @return
	 * @throws Exception
	 */
	public String loadForEdit() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.load(model.getTravelNoteId()));
		return "edit";
	}
	
	/**
	 * 修改特定的游记信息
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		TravelNoteInfo info = tNoteService.load(model.getTravelNoteId());
		info.setStatus(model.getStatus());
		info.setIsTop(model.getIsTop());
		tNoteService.edit(info);
		return "editSucc";
	}
	
	/**
	 * 查找符合条件的游记信息
	 * @return
	 * @throws Exception
	 */
	/*public String query() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.query(model));
		return "list";
	}*/
	
	
}
