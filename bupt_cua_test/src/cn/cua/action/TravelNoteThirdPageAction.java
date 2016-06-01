package cn.cua.action;

import java.util.ArrayList;
import java.util.List;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.service.TravelNoteThirdPageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TravelNoteThirdPageAction extends ActionSupport implements ModelDriven<TravelNoteInfo>{
	private TravelNoteThirdPageService tntpService = new TravelNoteThirdPageService();
	
	private TravelNoteInfo model = new TravelNoteInfo();
	private List<TravelDestinationInfo> tdList = new ArrayList<TravelDestinationInfo>();
	
	public List<TravelDestinationInfo> getTdList() {
		return tdList;
	}

	public void setTdList(List<TravelDestinationInfo> tdList) {
		this.tdList = tdList;
	}

	public String loadTravelNote(){
		model = tntpService.load(model.getTravelNoteId());
		ActionContext.getContext().getValueStack().push(model);
		tdList = tntpService.getRelevantCityList(model.getCityName());
		return "loadTravelNoteSucc";
	}
	
	public TravelNoteInfo getModel() {
		return model;
	}
}
