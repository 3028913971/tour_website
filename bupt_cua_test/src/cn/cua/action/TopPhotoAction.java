package cn.cua.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TopPhotoInfo;
import cn.cua.service.TopPhotoService;
import cn.itcast.utils.CommonUtils;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class TopPhotoAction extends ActionSupport implements ModelDriven<TopPhotoInfo> {
	
	private TopPhotoService topPhotoService = new TopPhotoService();
	private TopPhotoInfo model = new TopPhotoInfo();//手动实例化
	
	private String uploadFileName;
	private String uploadContentType;
	private File upload;

	private int pageNum;
	private int totalpage;
	private int pageSize;
	
	private List<String> cityList = new ArrayList<String>();
	
	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}
	
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
		System.out.println("pagepage=====");
		pageSize = 30;
		int topPhotoAmount = topPhotoService.getTopPhotoAmount();
		if (topPhotoAmount == 0) {
			return "pageFailed";
		}
		this.totalpage = topPhotoAmount%pageSize==0?(topPhotoAmount/pageSize):(topPhotoAmount/pageSize+1);
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
		ActionContext.getContext().getValueStack().push(topPhotoService.findAll(pageNum, pageSize));
		return "list";
	}
	
	public String loadForAdd(){
		cityList = topPhotoService.getCityList();
		return "loadForAddSucc";
	}

	/**
	 * 增加图片
	 * @return
	 * @throws IOException
	 */
	public String add() throws IOException{
		if (upload != null) {
			model.setTopPhotoFileName(this.uploadFileName);
			model.setTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/topPhotoFiles");
			File destFileTopPhoto = new File(savepathTopPhoto,model.getTopPhotoRealName());
			FileUtils.copyFile(upload, destFileTopPhoto);
		}
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());
		topPhotoService.add(model);
		return "pageSucc";
	}
	/**
	 * 修改信息之前的加载操作
	 * 将封装的model的信息添加到新页面的valueStack中去
	 * @return
	 */
	public String loadForEdit(){
		cityList = topPhotoService.getCityList();
		System.out.println(cityList);
		ActionContext.getContext().getValueStack().push(topPhotoService.load(model.getTopPhotoId()));
		return "edit";
	}
	
	/**
	 * 修改操作，需要设置默认的strategyFlieId在页面隐藏域
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws Exception{
		if (upload != null) {
			String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/topPhotoFiles");
			if (model.getTopPhotoRealName() != null) {			
				File filePhoto =new File(savepathTopPhoto,model.getTopPhotoRealName());
				filePhoto.delete();
			}		
			model.setTopPhotoFileName(this.uploadFileName);
			model.setTopPhotoRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			File destFilePhoto = new File(savepathTopPhoto,model.getTopPhotoRealName());
			FileUtils.copyFile(upload, destFilePhoto);
		}
		
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());	
		topPhotoService.edit(model);
		return "pageSucc";			
	}
	
	public String delete() throws UnsupportedEncodingException{
		String topPhotoRealName = new String(model.getTopPhotoRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathTopPhoto = ServletActionContext.getServletContext().getRealPath("/topPhotoFiles");
		new File(savepathTopPhoto,topPhotoRealName).delete();
		
		topPhotoService.delete(model.getTopPhotoId());
		
		return "pageSucc";
	}

	public TopPhotoInfo getModel() {
		return model;
	}
}
