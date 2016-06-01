package cn.cua.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.ThemeInfo;
import cn.cua.service.ThemeException;
import cn.cua.service.ThemeService;
import cn.itcast.utils.CommonUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ThemeAction extends ActionSupport implements ModelDriven<ThemeInfo>{
	private ThemeInfo model=new ThemeInfo();//�ֶ�ʵ����
	private ThemeService themeService = new ThemeService();
	
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public ThemeInfo getModel() {
		return model;
	}

	public void setModel(ThemeInfo model) {
		this.model = model;
	}

	public File getUpload() {
		return upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	public String findAll() throws Exception{
		int themeAmount = themeService.getThemeAmount();
		if(themeAmount == 0){
			return "listFailed";
		}
		ActionContext.getContext().getValueStack().push(themeService.findAll());
		return "list";
	}
	
	public String add() throws Exception{
		//������ϴ����ļ�
		if(upload!=null){
			model.setThemeFileName(uploadFileName);
			model.setThemeRealName(CommonUtils.uuid() +"." + uploadFileName.split("\\.")[1]);
		
			//�ϴ��ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/themeFiles");
			File destFile = new File(savePath,model.getThemeRealName());
			FileUtils.copyFile(upload, destFile);
		}
		try{
			themeService.add(model);
			return "editSucc";
		}catch(ThemeException e){
			this.addActionError(e.getMessage());
			return "addInput";
		}
	}
	
	public String delete() throws Exception{
		if(model.getThemeRealName()!=null){
			//����ļ����ڣ�ɾ���ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/themeFiles");
			new File(savePath,model.getThemeRealName()).delete();
		}
		//�����ݿ���ɾ�������Ϣ
		themeService.delete(model.getThemeId());
		return "editSucc";
	}
	
	/**
	 * �༭ǰ�ļ���
	 * @return
	 * @throws Exception
	 */
	public String loadForEdit() throws Exception{
		ActionContext.getContext().getValueStack().push(themeService.load(model.getThemeId()));
		return "edit";
	}
	
	/**
	 * �༭������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		if(upload!=null){
			//������ļ��ϴ���ɾ��ԭ�����ļ�
			String savePath = ServletActionContext.getServletContext().getRealPath("/themeFiles");
			if(model.getThemeRealName()!=null){
				new File(savePath,model.getThemeRealName()).delete();
			}
			//Ȼ���ϴ����ļ�
			model.setThemeFileName(uploadFileName);
			model.setThemeRealName(CommonUtils.uuid() +"." + uploadFileName.split("\\.")[1]);
			File destFile = new File(savePath,model.getThemeRealName());
			FileUtils.copyFile(upload, destFile);
		}
		
		try{
			themeService.edit(model);
			return "editSucc";
		}catch(ThemeException e){
			this.addActionError(e.getMessage());
			return "editInput";
		}
	}
	
}
