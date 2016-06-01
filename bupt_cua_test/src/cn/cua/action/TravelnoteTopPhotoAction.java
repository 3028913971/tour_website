package cn.cua.action;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TravelnoteTopPhotoInfo;
import cn.cua.service.TravelnoteTopPhotoService;
import cn.itcast.utils.CommonUtils;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class TravelnoteTopPhotoAction extends ActionSupport implements ModelDriven<TravelnoteTopPhotoInfo> {
	
	private TravelnoteTopPhotoService travelnoteTopPhotoService = new TravelnoteTopPhotoService();
	private TravelnoteTopPhotoInfo model = new TravelnoteTopPhotoInfo();//手动实例化
	
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
	 * 查询所有攻略的分页操作
	 * @return
	 */
	public String page(){
		pageSize = 30;
		int travelnoteTopPhotoAmount = travelnoteTopPhotoService.getTravelnoteTopPhotoAmount();
		if (travelnoteTopPhotoAmount == 0) {
			return "pageFailed";
		}
		this.totalpage = travelnoteTopPhotoAmount%pageSize==0?(travelnoteTopPhotoAmount/pageSize):(travelnoteTopPhotoAmount/pageSize+1);
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
	 * 查询所有图片
	 * @return
	 * @throws Exception
	 */
	public String findAll() throws Exception{
		ActionContext.getContext().getValueStack().push(travelnoteTopPhotoService.findAll(pageNum, pageSize));
		return "list";
	}

	/**
	 * 增加图片
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException{
		if (upload != null) {
			model.setTravelnoteTopPhotoFileName(this.uploadFileName);
			model.setTravelnoteTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/travelnoteTopPhotoFiles");
			File destFileTopPhoto = new File(savepathTopPhoto,model.getTravelnoteTopPhotoRealName());
			FileUtils.copyFile(upload, destFileTopPhoto);
		}
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());
		travelnoteTopPhotoService.add(model);
		return "pageSucc";
	}
	
	/**
	 * 修改信息之前的加载操作
	 * 将封装的model的信息添加到新页面的valueStack中去
	 * @return
	 */
	public String loadForEdit(){
		ActionContext.getContext().getValueStack().push(travelnoteTopPhotoService.load(model.getTravelnoteTopPhotoId()));
		return "edit";
	}
	
	/**
	 * 修改操作，需要设置默认的travelnoteTopPhotoId在页面隐藏域
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws Exception{
		if (upload != null) {
			String savepathTravelnoteTopPhoto = ServletActionContext.getServletContext().getRealPath("/travelnoteTopPhotoFiles");
			if (model.getTravelnoteTopPhotoRealName() != null) {			
				File filePhoto =new File(savepathTravelnoteTopPhoto,model.getTravelnoteTopPhotoRealName());
				filePhoto.delete();
			}		
			model.setTravelnoteTopPhotoFileName(this.uploadFileName);
			model.setTravelnoteTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			File destFilePhoto = new File(savepathTravelnoteTopPhoto,model.getTravelnoteTopPhotoRealName());
			FileUtils.copyFile(upload, destFilePhoto);
		}
		
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());	
		travelnoteTopPhotoService.edit(model);
		return "pageSucc";			
	}
	
	public String delete() throws UnsupportedEncodingException{
		String travelnoteTopPhotoRealName = new String(model.getTravelnoteTopPhotoRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/travelnoteTopPhotoFiles");
		new File(savepathTopPhoto,travelnoteTopPhotoRealName).delete();
		
		travelnoteTopPhotoService.delete(model.getTravelnoteTopPhotoId());
		
		return "pageSucc";
	}

	public TravelnoteTopPhotoInfo getModel() {
		return model;
	}
}
