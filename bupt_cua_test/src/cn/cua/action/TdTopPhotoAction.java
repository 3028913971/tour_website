package cn.cua.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TdTopPhotoInfo;
import cn.cua.service.TdTopPhotoService;
import cn.itcast.utils.CommonUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Ŀ�ĵ��Ƽ��Ϸ�ͼƬ  Action��
 * @author LI AO
 *
 */
public class TdTopPhotoAction extends ActionSupport implements ModelDriven<TdTopPhotoInfo>{

	private TdTopPhotoService tdTopPhotoService = new TdTopPhotoService();
	private TdTopPhotoInfo model = new TdTopPhotoInfo();//�ֶ�ʵ����
	
	private String uploadFileName;
	private String uploadContentType;
	private File upload;

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
	 * @return
	 */
	public String page(){
		pageSize = 30;
		int tdTopPhotoAmount = tdTopPhotoService.getTdTopPhotoAmount();
		if (tdTopPhotoAmount == 0) {
			return "pageFailed";
		}
		this.totalpage = tdTopPhotoAmount%pageSize==0?(tdTopPhotoAmount/pageSize):(tdTopPhotoAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "page";
	}
	
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
	
	/**
	 * ��ѯ����ͼƬ
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception{
		ActionContext.getContext().getValueStack().push(tdTopPhotoService.findAll(pageNum, pageSize));
		return "list";
	}

	/**
	 * ����ͼƬ
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException{
		if (upload != null) {
			model.setTdTopPhotoFileName(this.uploadFileName);
			model.setTdTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/tdTopPhotoFiles");
			File destFileTopPhoto = new File(savepathTopPhoto,model.getTdTopPhotoRealName());
			FileUtils.copyFile(upload, destFileTopPhoto);
		}
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());
		tdTopPhotoService.add(model);
		return "pageSucc";
	}
	
	/**
	 * �޸���Ϣ֮ǰ�ļ��ز���
	 * ����װ��model����Ϣ��ӵ���ҳ���valueStack��ȥ
	 * @return
	 */
	public String loadForEdit(){
		ActionContext.getContext().getValueStack().push(tdTopPhotoService.load(model.getTdTopPhotoId()));
		return "edit";
	}
	
	/**
	 * �޸Ĳ�������Ҫ����Ĭ�ϵ�tdTopPhotoId��ҳ��������
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws Exception{
		if (upload != null) {
			String savepathTdTopPhoto = ServletActionContext.getServletContext().getRealPath("/tdTopPhotoFiles");
			if (model.getTdTopPhotoRealName() != null) {			
				File filePhoto =new File(savepathTdTopPhoto,model.getTdTopPhotoRealName());
				filePhoto.delete();
			}		
			model.setTdTopPhotoFileName(this.uploadFileName);
			model.setTdTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			File destFilePhoto = new File(savepathTdTopPhoto,model.getTdTopPhotoRealName());
			FileUtils.copyFile(upload, destFilePhoto);
		}
		
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());	
		tdTopPhotoService.edit(model);
		return "pageSucc";			
	}
	
	public String delete() throws UnsupportedEncodingException{
		String tdTopPhotoRealName = new String(model.getTdTopPhotoRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/tdTopPhotoFiles");
		new File(savepathTopPhoto,tdTopPhotoRealName).delete();
		
		tdTopPhotoService.delete(model.getTdTopPhotoId());
		
		return "pageSucc";
	}

	public TdTopPhotoInfo getModel() {
		return model;
	}
}
