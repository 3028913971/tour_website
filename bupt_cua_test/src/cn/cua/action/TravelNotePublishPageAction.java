package cn.cua.action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.service.TravelNotePublishPageService;
import cn.itcast.utils.CommonUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TravelNotePublishPageAction extends ActionSupport implements ModelDriven<TravelNoteInfo>{

	private TravelNotePublishPageService tnppService = new TravelNotePublishPageService();
	private TravelNoteInfo model = new TravelNoteInfo();
	private String content1;
	private List<TravelDestinationInfo> tdList = new ArrayList<TravelDestinationInfo>();
	

	public List<TravelDestinationInfo> getTdList() {
		return tdList;
	}

	public void setTdList(List<TravelDestinationInfo> tdList) {
		this.tdList = tdList;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	
	private String travelnoteFileName;
	private File travelnote;
	
	

	public String getTravelnoteFileName() {
		return travelnoteFileName;
	}

	public void setTravelnoteFileName(String travelnoteFileName) {
		this.travelnoteFileName = travelnoteFileName;
	}

	public File getTravelnote() {
		return travelnote;
	}

	public void setTravelnote(File travelnote) {
		this.travelnote = travelnote;
	}

	public String publish() throws IOException{
		if(travelnote != null){
			model.setTravelNoteFileName(this.travelnoteFileName);
			model.setTravelNoteRealName(CommonUtils.uuid() + "." + this.travelnoteFileName.split("\\.")[1]);
			String savepath = ServletActionContext.getServletContext().getRealPath("/travelNoteFiles");
			File destFile = new File(savepath,model.getTravelNoteRealName());
			FileUtils.copyFile(travelnote, destFile);
		}
		model.setIsTop("∑Ò");
		model.setStatus("Œ¥…Û∫À");
		model.setPublicTime(new Date(System.currentTimeMillis()).toLocaleString());
		model.setTravelNoteContent(content1);
		tnppService.add(model);
		tdList = tnppService.getRelevantCityList(model.getCityName());
		ActionContext.getContext().getValueStack().push(model);
		return "publishSucc";
	}

	public TravelNoteInfo getModel() {
		return model;
	}
	
}
