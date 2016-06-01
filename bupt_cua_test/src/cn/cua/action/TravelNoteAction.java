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
 * TravelNoteAction��
 * @author Sandm
 *
 */
public class TravelNoteAction extends ActionSupport implements ModelDriven<TravelNoteInfo>{

	private TravelNoteInfo model = new TravelNoteInfo();
	private TravelNoteService tNoteService = new TravelNoteService();
	
	private int pageNum;//��ǰҳ��
	private int totalPage;//��ҳ��
	private int pageSize;//ÿҳ������
	private int ps = 30;//ÿҳ�������޸�
	
	private String tnName;//�μ�����
	private String tnStatus;//�μ����״̬
	private String tnIsTop;//�Ƿ�����ҳ
	private String tnCityName;//�������
	
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
	 * ����������ķ�ҳ����
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
	 * �Է�����Ӧ��ѯ��������ķ�ҳ����
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
	 * �Է�����Ӧ��ѯ��������ķ�ҳ����1
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
	 * ��ʾ��������
	 * 1.ͨ��QuestionService��findAll��������List<Question>
	 * 2.���浽ValueStack��
	 * 3.��question_listҳ������<s:iterator>��ǩ��ʾ
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.findAll(pageNum,pageSize));
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
	 * ��ʾ�����μ���Ϣ
	 * @return
	 * @throws Exception
	 */
	/*public String findAll() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.findAll());
		return "list";
	}*/

	/**
	 * �鿴�ض����μ���Ϣ
	 * @return
	 * @throws Exception
	 */
	public String view() throws Exception {
		//���μ���Ϣѹ��ֵջ
		ActionContext.getContext().getValueStack().push(tNoteService.load(model.getTravelNoteId()));
		//���μ����ͼƬ·��ѹ��ֵջ
		//ActionContext.getContext().getValueStack().push(tNoteService.loadPhoto(model.getTravelNoteId()));
		return "view";
	}
	
	/**
	 * ɾ���ض����μ���Ϣ
	 * 1.�����Ӧ���μ���ͼƬ����ȡ��ͼƬ�Ĵ洢����ɾ��
	 * 2.ɾ����Ӧ���μǼ��μ�ͼƬ��Ϣ
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
	 * �����μ���Ϣ�Ա��޸�
	 * @return
	 * @throws Exception
	 */
	public String loadForEdit() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.load(model.getTravelNoteId()));
		return "edit";
	}
	
	/**
	 * �޸��ض����μ���Ϣ
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
	 * ���ҷ����������μ���Ϣ
	 * @return
	 * @throws Exception
	 */
	/*public String query() throws Exception {
		ActionContext.getContext().getValueStack().push(tNoteService.query(model));
		return "list";
	}*/
	
	
}
