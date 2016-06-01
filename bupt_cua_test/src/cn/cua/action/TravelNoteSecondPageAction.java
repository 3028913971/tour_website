package cn.cua.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.service.TravelNoteSecondPageService;

import com.opensymphony.xwork2.ActionSupport;

public class TravelNoteSecondPageAction extends ActionSupport {
	private TravelNoteSecondPageService tnspService = new TravelNoteSecondPageService();
	
	private String cityName;
	private TravelDestinationInfo city = new TravelDestinationInfo();
	private List<TravelNoteInfo> isTopList = new ArrayList<TravelNoteInfo>();
	private List<TravelNoteInfo> publishTimeList = new ArrayList<TravelNoteInfo>();
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public TravelDestinationInfo getCity() {
		return city;
	}
	public void setCity(TravelDestinationInfo city) {
		this.city = city;
	}
	public List<TravelNoteInfo> getIsTopList() {
		return isTopList;
	}
	public void setIsTopList(List<TravelNoteInfo> isTopList) {
		this.isTopList = isTopList;
	}
	public List<TravelNoteInfo> getPublishTimeList() {
		return publishTimeList;
	}
	public void setPublishTimeList(List<TravelNoteInfo> publishTimeList) {
		this.publishTimeList = publishTimeList;
	}
	
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
	
	
	
	public String pageIsTop() throws UnsupportedEncodingException{
		pageSize = 18;
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		city.setCityName(cityName);
		int productAmount =tnspService.getAmount(city.getCityName());
		if(productAmount == 0){
			return "pageIsTopFailed";
		}
		
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageIsTop";
	}
	
	public String pageIsTop1() throws UnsupportedEncodingException{
		pageSize = 18;
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		int productAmount =tnspService.getAmount(cityName);
		if(productAmount == 0){
			return "pageIsTopFailed";
		}
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageIsTop";
	}
	

	public String findAllIsTop() throws UnsupportedEncodingException{
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		city = tnspService.getCity(cityName);
		if(city == null){
			city = new TravelDestinationInfo();
			city.setCityName(cityName);
			isTopList = tnspService.findIsTop(cityName, pageNum, pageSize);
			
			return "isTopList";
		}
		isTopList = tnspService.findIsTop(city.getCityName(), pageNum, pageSize);
		return "isTopList";
	}
	
	public String pagePublicTime() throws UnsupportedEncodingException{
		pageSize = 18;
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		int productAmount =tnspService.getAmount(cityName);
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pagePublicTime";
	}
	
	public String findAllPublicTime() throws UnsupportedEncodingException{
		cityName = new String(cityName.getBytes("ISO-8859-1"),"UTF-8");
		city = tnspService.getCity(cityName);
		if(city == null){
			city = new TravelDestinationInfo();
			city.setCityName(cityName);
			publishTimeList = tnspService.findPublicTime(city.getCityName(), pageNum, pageSize);
			
			return "publicTimeList";
		}
		publishTimeList = tnspService.findPublicTime(city.getCityName(), pageNum, pageSize);
		
		return "publicTimeList";
	}
}
