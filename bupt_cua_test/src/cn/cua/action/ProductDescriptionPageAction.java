package cn.cua.action;

import java.util.ArrayList;
import java.util.List;

import cn.cua.domain.JourneyInfo;
import cn.cua.domain.ProductInfo;
import cn.cua.service.ProductDescriptionPageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductDescriptionPageAction extends ActionSupport implements ModelDriven<ProductInfo>{
	
	private ProductDescriptionPageService pdpService = new ProductDescriptionPageService();
	
	private ProductInfo model = new ProductInfo();
	private List<JourneyInfo> journeyList = new ArrayList<JourneyInfo>();

	public List<JourneyInfo> getJourneyList() {
		return journeyList;
	}
	public void setJourneyList(List<JourneyInfo> journeyList) {
		this.journeyList = journeyList;
	}
	
	public String loadProduct(){
		model = pdpService.getProduct(model.getProductId());
		ActionContext.getContext().getValueStack().push(model);
		journeyList = pdpService.getJourney(model.getProductName());
		return "productSucc";
	}
	public ProductInfo getModel() {
		return model;
	}
	
}
