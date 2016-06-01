package cn.cua.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;
import cn.cua.service.TravelNoteFirstPageService;

import com.opensymphony.xwork2.ActionSupport;

public class TravelNoteFirstPageAction extends ActionSupport {
	
	private TravelNoteFirstPageService tnfpService = new TravelNoteFirstPageService();
	
	private List<String> picList = new ArrayList<String>();
	private LinkedHashMap<String,List<String>> themeTypeList = new LinkedHashMap<String,List<String>>();
	private LinkedHashMap<String,List<String>> homeList = new LinkedHashMap<String,List<String>>();
	private List<TravelDestinationInfo> isTopSeasonCityList = new ArrayList<TravelDestinationInfo>();
	
	private List<TravelNoteInfo> isTopList = new ArrayList<TravelNoteInfo>();
	private List<TravelNoteInfo> publicTimeList = new ArrayList<TravelNoteInfo>();
	
	public List<String> getPicList() {
		return picList;
	}
	public void setPicList(List<String> picList) {
		this.picList = picList;
	}
	public LinkedHashMap<String, List<String>> getThemeTypeList() {
		return themeTypeList;
	}
	public void setThemeTypeList(LinkedHashMap<String, List<String>> themeTypeList) {
		this.themeTypeList = themeTypeList;
	}
	public LinkedHashMap<String, List<String>> getHomeList() {
		return homeList;
	}
	public void setHomeList(LinkedHashMap<String, List<String>> homeList) {
		this.homeList = homeList;
	}
	public List<TravelDestinationInfo> getIsTopSeasonCityList() {
		return isTopSeasonCityList;
	}
	public void setIsTopSeasonCityList(
			List<TravelDestinationInfo> isTopSeasonCityList) {
		this.isTopSeasonCityList = isTopSeasonCityList;
	}
	
	
	public List<TravelNoteInfo> getIsTopList() {
		return isTopList;
	}
	public void setIsTopList(List<TravelNoteInfo> isTopList) {
		this.isTopList = isTopList;
	}
	public List<TravelNoteInfo> getPublicTimeList() {
		return publicTimeList;
	}
	public void setPublicTimeList(List<TravelNoteInfo> publicTimeList) {
		this.publicTimeList = publicTimeList;
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
	/**
	 * 游记一级页面热门游记排序分页
	 * @return
	 */
	public String pageIsTop(){
		pageSize = 18;
		int productAmount = tnfpService.getAmount();
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pageIsTop";
	}
	
	/**
	 * 游记一级页面热门游记排序分页
	 * @return
	 */
	public String findAllIsTop(){
		picList = tnfpService.findPictures();
		themeTypeList = tnfpService.findThemeTypeList();
		homeList = tnfpService.findHomeTD();
		isTopSeasonCityList = tnfpService.findIsTopSeason();
		isTopList = tnfpService.findIsTop(pageNum, pageSize);
		return "isTopList";
	}
	
	/**
	 * 游记一级页面-发表时间排序分页
	 * @return
	 */
	public String pagePublicTime(){
		pageSize = 18;
		int productAmount = tnfpService.getAmount();
		this.totalpage = productAmount%pageSize==0?(productAmount/pageSize):(productAmount/pageSize+1);
		if(pageNum<=0){
			this.pageNum=1;
		}
		if(pageNum>totalpage){
			this.pageNum=totalpage;
		}
		return "pagePublicTime";
	}
	
	/**
	 * 游记一级页面-发表时间排序分页
	 * @return
	 */
	public String findAllPublicTime(){
		
		
		publicTimeList = tnfpService.findPublicTime(pageNum, pageSize);
		//if(publicTimeList.size() > 0){
			picList = tnfpService.findPictures();
			themeTypeList = tnfpService.findThemeTypeList();
			homeList = tnfpService.findHomeTD();
			isTopSeasonCityList = tnfpService.findIsTopSeason();
		//}
		return "publicTimeList";
	}
	
	

}
