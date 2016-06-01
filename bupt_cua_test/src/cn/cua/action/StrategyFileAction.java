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

import cn.cua.domain.AdminInfo;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.service.StrategyFileException;
import cn.cua.service.StrategyFileService;
import cn.cua.service.TravelDestinationException;
import cn.itcast.utils.CommonUtils;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class StrategyFileAction extends ActionSupport implements ModelDriven<StrategyFileInfo> {
	
	private StrategyFileService strategyFileService = new StrategyFileService();
	private StrategyFileInfo model = new StrategyFileInfo();//手动实例化
	
	private String uploadFileName;
	private String uploadContentType;
	private File upload;
	
	private String photoFileName;
	private String photoContentType;
	private File photo;
	
	private String jpgFileName;
	private String jpgContentType;
	private File jpg;

	private int pageNum;
	private int totalpage;
	private int pageSize;
	
	private String qcityName;
	
	public String getQcityName() {
		return qcityName;
	}
	public void setQcityName(String qcityName) {
		this.qcityName = qcityName;
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
		pageSize = 30;
		int strategyFileAmount = strategyFileService.getStrategyFileAmount();
		if (strategyFileAmount == 0) {
			return "pageFailed";
		}
		this.totalpage = strategyFileAmount%pageSize==0?(strategyFileAmount/pageSize):(strategyFileAmount/pageSize+1);
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

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	public void setJpgFileName(String jpgFileName) {
		this.jpgFileName = jpgFileName;
	}

	public void setJpgContentType(String jpgContentType) {
		this.jpgContentType = jpgContentType;
	}

	public void setJpg(File jpg) {
		this.jpg = jpg;
	}
	
	/**
	 * 查询所有攻略
	 * @return
	 */
	public String findAll() throws Exception{
		ActionContext.getContext().getValueStack().push(strategyFileService.findAll(pageNum, pageSize));
		return "list";
	}

	/**
	 * 删除文件夹
	 * @param dir
	 * @return
	 */
	public static boolean deleteDir(File dir){
		if(dir.isDirectory()){
			String[] children = dir.list();
			for(int i=0;i<children.length;i++){
				boolean success = deleteDir(new File(dir,children[i]));
				if(!success){
					return false;
				}
			}
		}
		return dir.delete();
	}
	/**
	 * 增加攻略文件
	 * @return
	 * @throws IOException 
	 */
	public String add() throws Exception{
		if (upload != null) {
			model.setStrategyFileName(this.uploadFileName);
			model.setStrategyFileRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			String savepathStrategy = ServletActionContext.getServletContext().getRealPath("/strategyFiles");
			File destFileStrategy = new File(savepathStrategy,model.getStrategyFileRealName());
			FileUtils.copyFile(upload, destFileStrategy);
		}

		if (photo != null) {
			model.setStrategyPhotoFileName(this.photoFileName);
			model.setStrategyPhotoRealName(CommonUtils.uuid()+"."+this.photoFileName.split("\\.")[1]);
			String savepathPhoto = ServletActionContext.getServletContext().getRealPath("/strategyFilePhotos");
			File destFilePhoto = new File(savepathPhoto,model.getStrategyPhotoRealName());
			FileUtils.copyFile(photo, destFilePhoto);
		}
		
		if (jpg != null) {
			model.setStrategyJpgName(this.jpgFileName);
			model.setStrategyJpgRealName(CommonUtils.uuid()+"."+this.jpgFileName.split("\\.")[1]);
			String savepathJpg = ServletActionContext.getServletContext().getRealPath("/strategyJpgFiles");
			File destFileJpg = new File(savepathJpg,model.getStrategyJpgRealName());
			FileUtils.copyFile(jpg, destFileJpg);
			
		//解压
			ZipInputStream zin = new ZipInputStream(new FileInputStream(savepathJpg+"/"+model.getStrategyJpgRealName()));
			String directory = ServletActionContext.getServletContext().getRealPath("/strategyJpgListFiles") + "/"+ model.getStrategyJpgRealName().split("\\.")[0];
			
			ZipEntry entry = zin.getNextEntry();
			File parent = new File(directory);
			
			if(!parent.exists() && !parent.mkdirs()){
				throw new Exception("创建解压目录/"+parent.getAbsolutePath()+"/失败");
			}
			
			while(entry != null){
				String name = entry.getName();
				File child = new File(parent,name);
				FileOutputStream output = new FileOutputStream(child);
				byte[] buffer = new byte[1024000];
				int bytesRead = 0;
				while((bytesRead = zin.read(buffer)) > 0){
					output.write(buffer,0,bytesRead);
				}
				output.flush();
				output.close();
				entry = zin.getNextEntry();
			}
			zin.close();		
		}
		
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());
		model.setAmountOfDownload(0);
		
		try {		
			strategyFileService.add(model);
			return "pageSucc";
		} catch (StrategyFileException e) {
			this.addActionError(e.getMessage());
			return "add";
		}		
	}
	
	/**
	 * 修改信息之前的加载操作
	 * 将封装的model的信息添加到新页面的valueStack中去
	 * @return
	 */
	public String loadForEdit(){
		ActionContext.getContext().getValueStack().push(strategyFileService.load(model.getStrategyFileId()));
		return "edit";
	}
	
	/**
	 * 修改操作，需要设置默认的strategyFlieId在页面隐藏域
	 * @return
	 * @throws IOException 
	 */
	public String edit() throws Exception{
		if (upload != null) {
			String savepathStrategy = ServletActionContext.getServletContext().getRealPath("/strategyFiles");
			if (model.getStrategyFileRealName() != null) {			
				File fileStrategy =new File(savepathStrategy,model.getStrategyFileRealName());
				fileStrategy.delete();
			}		
			model.setStrategyFileName(this.uploadFileName);
			model.setStrategyFileRealName(CommonUtils.uuid()+"."+this.uploadFileName.split("\\.")[1]);
			File destFileStrategy = new File(savepathStrategy,model.getStrategyFileRealName());
			FileUtils.copyFile(upload, destFileStrategy);
		}
		
		if (photo != null) {
			String savepathPhoto = ServletActionContext.getServletContext().getRealPath("/strategyFilePhotos");
			if (model.getStrategyPhotoRealName() != null) {
				File filePhoto =new File(savepathPhoto,model.getStrategyPhotoRealName());
				filePhoto.delete();
			}			
			model.setStrategyPhotoFileName(this.photoFileName);
			model.setStrategyPhotoRealName(CommonUtils.uuid()+"."+this.photoFileName.split("\\.")[1]);
			File destFilePhoto = new File(savepathPhoto,model.getStrategyPhotoRealName());
			FileUtils.copyFile(photo, destFilePhoto);
		}
		
		if (jpg != null) {
			String savepathJpg = ServletActionContext.getServletContext().getRealPath("/strategyJpgFiles");
			if (model.getStrategyJpgRealName() != null) {
				File fileJpg =new File(savepathJpg,model.getStrategyJpgRealName());
				//删除解压的文件夹
				String directory = ServletActionContext.getServletContext().getRealPath("/strategyJpgListFiles") + "/"+ model.getStrategyJpgRealName().split("\\.")[0];
				File parent = new File(directory);
				boolean success = deleteDir(parent);
				
				fileJpg.delete();
			}			
			model.setStrategyJpgName(this.jpgFileName);
			model.setStrategyJpgRealName(CommonUtils.uuid()+"."+this.jpgFileName.split("\\.")[1]);
			File destFileJpg = new File(savepathJpg,model.getStrategyJpgRealName());
			FileUtils.copyFile(jpg, destFileJpg);
			
			//解压
			ZipInputStream zin = new ZipInputStream(new FileInputStream(savepathJpg+"/"+model.getStrategyJpgRealName()));
			String directory = ServletActionContext.getServletContext().getRealPath("/strategyJpgListFiles") + "/"+ model.getStrategyJpgRealName().split("\\.")[0];
			
			ZipEntry entry = zin.getNextEntry();
			File parent = new File(directory);
			
			if(!parent.exists() && !parent.mkdirs()){
				throw new Exception("创建解压目录/"+parent.getAbsolutePath()+"/失败");
			}
			
			while(entry != null){
				String name = entry.getName();
				File child = new File(parent,name);
				FileOutputStream output = new FileOutputStream(child);
				byte[] buffer = new byte[10240];
				int bytesRead = 0;
				while((bytesRead = zin.read(buffer)) > 0){
					output.write(buffer,0,bytesRead);
				}
				output.flush();
				output.close();
				entry = zin.getNextEntry();
			}
			zin.close();
		}
		
		model.setUpdateTime(new Date(System.currentTimeMillis()).toLocaleString());
		
		try {		
			strategyFileService.edit(model);
			return "pageSucc";
		} catch (StrategyFileException e) {
			this.addActionError(e.getMessage());
			return "edit";
		}			
	}
	
	/**
	 * 查看攻略信息
	 * @return
	 */
	public String load(){
		ActionContext.getContext().getValueStack().push(strategyFileService.load(model.getStrategyFileId()));
		return "view";
	}
	
	public String delete() throws UnsupportedEncodingException{
		String strategyFileRealName = new String(model.getStrategyFileRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathStrategy = ServletActionContext.getServletContext().getRealPath("/strategyFiles");
		new File(savepathStrategy,strategyFileRealName).delete();
		
		String strategyPhotoRealName = new String(model.getStrategyPhotoRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathPhoto = ServletActionContext.getServletContext().getRealPath("/strategyFilePhotos");
		new File(savepathPhoto,strategyPhotoRealName).delete();
		
		String strategyJpgRealName = new String(model.getStrategyJpgRealName().getBytes("ISO-8859-1"),"utf-8");
		String savepathJpg = ServletActionContext.getServletContext().getRealPath("/strategyJpgFiles");
		new File(savepathJpg,strategyJpgRealName).delete();
		//删除解压的文件夹
		String directory = ServletActionContext.getServletContext().getRealPath("/strategyJpgListFiles") + "/"+ model.getStrategyJpgRealName().split("\\.")[0];
		File parent = new File(directory);
		boolean success = deleteDir(parent);
		
		strategyFileService.delete(model.getStrategyFileId());
		
		return "pageSucc";
	}
	
	/**
	 * 条件查询分页操作
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageQuery(){
		pageSize = 30;
		int strategyFileAmount = strategyFileService.getQueryAmount(model);		
		model.setCityName(qcityName);
		this.totalpage = strategyFileAmount%pageSize==0?(strategyFileAmount/pageSize):(strategyFileAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuery";
	}
	
	/**
	 * 条件查询分页操作
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String pageQuery1() throws UnsupportedEncodingException{
		pageSize = 30;
		int strategyFileAmount = strategyFileService.getQueryAmount(model);
		qcityName = new String(this.qcityName.getBytes("ISO-8859-1"),"UTF-8");
		model.setCityName(qcityName);
		this.totalpage = strategyFileAmount%pageSize==0?(strategyFileAmount/pageSize):(strategyFileAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageQuery1";
	}

	public String query() throws UnsupportedEncodingException{	
		qcityName = new String(this.qcityName.getBytes("ISO-8859-1"),"UTF-8");
		model.setCityName(qcityName);
		ActionContext.getContext().getValueStack().push(strategyFileService.query(model,pageNum, pageSize));
		return "listQuery";
	}

	public StrategyFileInfo getModel() {
		return model;
	}
}
