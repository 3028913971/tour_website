package cn.cua.action;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.service.StrategyTopPhotoService;
import cn.itcast.utils.CommonUtils;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class StrategyTopPhotoAction extends ActionSupport implements ModelDriven<StrategyTopPhotoInfo> {
	
	private StrategyTopPhotoService strategyTopPhotoService = new StrategyTopPhotoService();
	private StrategyTopPhotoInfo model = new StrategyTopPhotoInfo();//手动实例化
	
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
	 * 查询所有攻略图片的分页操作
	 * @return
	 */
	public String page(){
		pageSize = 30;
		int strategyTopPhotoAmount = strategyTopPhotoService.getStrategyTopPhotoAmount();
		if (strategyTopPhotoAmount == 0) {
			return "pageFailed";
		}
		this.totalpage = strategyTopPhotoAmount%pageSize==0?(strategyTopPhotoAmount/pageSize):(strategyTopPhotoAmount/pageSize+1);
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
		ActionContext.getContext().getValueStack().push(strategyTopPhotoService.findAll(pageNum, pageSize));
		return "list";
	}

	/**
	 * 增加图片
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException{
		if (upload != null) {
			model.setStrategyTopPhotoFileName(this.uploadFileName);
			model.setStrategyTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/strategyTopPhotoFiles");
			File destFilesTopPhoto = new File(savepathTopPhoto,model.getStrategyTopPhotoRealName());
			FileUtils.copyFile(upload, destFilesTopPhoto);
		}
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());
		strategyTopPhotoService.add(model);
		return "pageSucc";
	}
	
	/**
	 * 修改信息之前的加载操作
	 * 将封装的model的信息添加到新页面的valueStack中去
	 * @return
	 */
	public String loadForEdit(){
		ActionContext.getContext().getValueStack().push(strategyTopPhotoService.load(model.getStrategyTopPhotoId()));
		return "edit";
	}
	
	/**
	 * 修改操作，需要设置默认的strategyTopPhotoId在页面隐藏域
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws Exception{
		if (upload != null) {
			String savepathStrategyTopPhoto = ServletActionContext.getServletContext().getRealPath("/strategyTopPhotoFiles");
			if (model.getStrategyTopPhotoRealName() != null) {			
				File filePhoto =new File(savepathStrategyTopPhoto,model.getStrategyTopPhotoRealName());
				filePhoto.delete();
			}		
			model.setStrategyTopPhotoFileName(this.uploadFileName);
			model.setStrategyTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			File destFilePhoto = new File(savepathStrategyTopPhoto,model.getStrategyTopPhotoRealName());
			FileUtils.copyFile(upload, destFilePhoto);
		}
		
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());	
		strategyTopPhotoService.edit(model);
		return "pageSucc";			
	}
	
	public String delete() throws UnsupportedEncodingException{
		String strategyTopPhotoRealName = new String(model.getStrategyTopPhotoRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/strategyTopPhotoFiles");
		new File(savepathTopPhoto,strategyTopPhotoRealName).delete();
		
		strategyTopPhotoService.delete(model.getStrategyTopPhotoId());
		
		return "pageSucc";
	}

	public StrategyTopPhotoInfo getModel() {
		return model;
	}
}
