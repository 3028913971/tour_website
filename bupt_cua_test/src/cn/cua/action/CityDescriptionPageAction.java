package cn.cua.action;

import java.io.UnsupportedEncodingException;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.service.CityDescriptionPageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CityDescriptionPageAction extends ActionSupport implements ModelDriven<TravelDestinationInfo>{

	private CityDescriptionPageService cdpService = new CityDescriptionPageService();
	
	private TravelDestinationInfo model = new TravelDestinationInfo();
	
	public String loadCity() throws UnsupportedEncodingException{
		ActionContext.getContext().getValueStack().push(cdpService.load(new String(model.getCityName().getBytes("ISO-8859-1"),"UTF-8")));
		return SUCCESS;
	}

	public TravelDestinationInfo getModel() {
		return model;
	}
}
