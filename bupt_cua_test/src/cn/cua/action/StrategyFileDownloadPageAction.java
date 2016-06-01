package cn.cua.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.FileDir;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.service.StrategyFileDownloadPageService;
import cn.cua.service.StrategyFileFirstPageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StrategyFileDownloadPageAction extends ActionSupport implements ModelDriven<StrategyFileInfo>{
	private StrategyFileDownloadPageService sfdpService = new StrategyFileDownloadPageService();
	private StrategyFileFirstPageService sffpService = new StrategyFileFirstPageService();
	
	private StrategyFileInfo model = new StrategyFileInfo();
	private String descriptionOfCity;
	private List<StrategyFileInfo> relevantCityList = new ArrayList<StrategyFileInfo>();
	private List<TravelDestinationInfo> relevantCityNewList = new ArrayList<TravelDestinationInfo>();
	private List<FileDir> jspList = new ArrayList<FileDir>();
	


	public List<FileDir> getJspList() {
		return jspList;
	}

	public void setJspList(List<FileDir> jspList) {
		this.jspList = jspList;
	}

	public String getDescriptionOfCity() {
		return descriptionOfCity;
	}

	public void setDescriptionOfCity(String descriptionOfCity) {
		this.descriptionOfCity = descriptionOfCity;
	}
	
	public List<StrategyFileInfo> getRelevantCityList() {
		return relevantCityList;
	}

	public void setRelevantCityList(List<StrategyFileInfo> relevantCityList) {
		this.relevantCityList = relevantCityList;
	}

	
	
	public List<TravelDestinationInfo> getRelevantCityNewList() {
		return relevantCityNewList;
	}

	public void setRelevantCityNewList(
			List<TravelDestinationInfo> relevantCityNewList) {
		this.relevantCityNewList = relevantCityNewList;
	}

	public String loadStrategy() throws UnsupportedEncodingException{
		
		String cityName = new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8");
		if(sffpService.getStrategyByCityName(cityName) == null || sffpService.getStrategyByCityName(cityName).getCityName().isEmpty()){
			return "sfFailed";
		}
		else{
			ActionContext.getContext().getValueStack().push(sfdpService.getStrategyByCityName(cityName));
			descriptionOfCity = sfdpService.getCityDescrption(cityName);
			relevantCityList = sfdpService.getRelevantCity(cityName);
			relevantCityNewList = sfdpService.getRelevantCityList(cityName);
			
			String directory = ServletActionContext.getServletContext().getRealPath("\\strategyJpgListFiles")+"/" + sfdpService.getStrategyByCityName(cityName).getStrategyJpgRealName().split("\\.")[0];
			File file = new File(directory);
			File[] files = file.listFiles();
			
			if(files != null){
				for(File f: files){
					FileDir fd = new FileDir();
					fd.setDirName(sfdpService.getStrategyByCityName(cityName).getStrategyJpgRealName().split("\\.")[0]);
					fd.setFileName(f.getName());
					jspList.add(fd);
				}
			}
			
			return SUCCESS;
		}
	}
	
	private String type;
	private String frameName;
	private InputStream inputStream;
	
	public String getType() {
		return type;
	}

	public String getFrameName() {
		return frameName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String download() throws Exception{
		String cityName = new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8");
		String realname = new String(model.getStrategyFileRealName().getBytes("ISO-8859-1"),"utf-8");
		String filename = new String(model.getStrategyFileName().getBytes("ISO-8859-1"),"utf-8");
		
		this.type = ServletActionContext.getServletContext().getMimeType(realname);
		this.frameName = new String(filename.getBytes("GBK"),"ISO-8859-1");
		
		String savepath = ServletActionContext.getServletContext().getRealPath("/strategyFiles");
		this.inputStream = new FileInputStream(new File(savepath,realname));
		System.out.println(savepath+"======"+realname);
		System.out.println("------------"+inputStream);
		sfdpService.downloadAmount(cityName);
		return "download";
	}
	
	public String downloadZip() throws Exception{
		String cityName = new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8");
		String realname = new String(model.getStrategyJpgRealName().getBytes("ISO-8859-1"),"utf-8");
		String filename = new String(model.getStrategyJpgName().getBytes("ISO-8859-1"),"utf-8");
		
		this.type = ServletActionContext.getServletContext().getMimeType(realname);
		this.frameName = new String(filename.getBytes("GBK"),"ISO-8859-1");
		
		String savepath = ServletActionContext.getServletContext().getRealPath("/strategyJpgFiles");
		this.inputStream = new FileInputStream(new File(savepath,realname));
		
		sfdpService.downloadAmount(cityName);
		
		return "download";
	}
	
	

	public StrategyFileInfo getModel() {
		return model;
	}
}
