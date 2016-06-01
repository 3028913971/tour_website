package cn.cua.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.log4j.LogControler;
import cn.cua.service.HomePageService;

import com.opensymphony.xwork2.ActionSupport;

public class HomePageAction extends ActionSupport {
	private HomePageService homepageService = new HomePageService();
	
	private List<TravelDestinationInfo> tdThemeTypeList = new ArrayList<TravelDestinationInfo>();//主题目的地推荐
	private List<TravelDestinationInfo> tdTopSeasonList = new ArrayList<TravelDestinationInfo>();//本季热门推荐
	private List<StrategyFileInfo> sfIsTopSeasonList = new ArrayList<StrategyFileInfo>();//攻略下载-本季最受欢迎
	private List<StrategyFileInfo> sfAmountOfDownloadList = new ArrayList<StrategyFileInfo>();//首页攻略下载-下载人气
	private List<StrategyFileInfo> sfUpdateTimeList = new ArrayList<StrategyFileInfo>();//首页攻略下载-更新时间
	private List<String> topSeasonCityList = new ArrayList<String>();//首页上端选项卡-本季热门推荐城市列表
	private LinkedHashMap<String,List<String>> themeTypeCityList = new LinkedHashMap<String,List<String>>();//首页上端选项卡-主题目的地推荐
	private LinkedHashMap<String,List<String>> areaCityList = new LinkedHashMap<String,List<String>>();//首页上端选项卡-国内目的地推荐
	private List<String> homeCityList = new ArrayList<String>();//首页最下端国内城市列表
	private LinkedHashMap<String,String> topPhotoList = new LinkedHashMap<String,String>();
	
	private String firstTopPhotoRealName = null;
	private String firstTopPhotoCityName = null;
	private String lastTopPhotoRealName = null;
	private String lastTopPhotoCityName = null;
	
	
		
	public String getFirstTopPhotoRealName() {
		return firstTopPhotoRealName;
	}

	public void setFirstTopPhotoRealName(String firstTopPhotoRealName) {
		this.firstTopPhotoRealName = firstTopPhotoRealName;
	}

	public String getFirstTopPhotoCityName() {
		return firstTopPhotoCityName;
	}

	public void setFirstTopPhotoCityName(String firstTopPhotoCityName) {
		this.firstTopPhotoCityName = firstTopPhotoCityName;
	}

	public String getLastTopPhotoRealName() {
		return lastTopPhotoRealName;
	}

	public void setLastTopPhotoRealName(String lastTopPhotoRealName) {
		this.lastTopPhotoRealName = lastTopPhotoRealName;
	}

	public String getLastTopPhotoCityName() {
		return lastTopPhotoCityName;
	}

	public void setLastTopPhotoCityName(String lastTopPhotoCityName) {
		this.lastTopPhotoCityName = lastTopPhotoCityName;
	}

	public LinkedHashMap<String, String> getTopPhotoList() {
		return topPhotoList;
	}

	public void setTopPhotoList(LinkedHashMap<String, String> topPhotoList) {
		this.topPhotoList = topPhotoList;
	}


	public List<TravelDestinationInfo> getTdThemeTypeList() {
		return tdThemeTypeList;
	}

	public void setTdThemeTypeList(List<TravelDestinationInfo> tdThemeTypeList) {
		this.tdThemeTypeList = tdThemeTypeList;
	}

	public List<TravelDestinationInfo> getTdTopSeasonList() {
		return tdTopSeasonList;
	}

	public void setTdTopSeasonList(List<TravelDestinationInfo> tdTopSeasonList) {
		this.tdTopSeasonList = tdTopSeasonList;
	}

	public List<String> getTopSeasonCityList() {
		return topSeasonCityList;
	}

	public void setTopSeasonCityList(List<String> topSeasonCityList) {
		this.topSeasonCityList = topSeasonCityList;
	}

	
	public LinkedHashMap<String, List<String>> getThemeTypeCityList() {
		return themeTypeCityList;
	}

	public void setThemeTypeCityList(LinkedHashMap<String, List<String>> themeTypeCityList) {
		this.themeTypeCityList = themeTypeCityList;
	}
	
	public LinkedHashMap<String, List<String>> getAreaCityList() {
		return areaCityList;
	}

	public void setAreaCityList(LinkedHashMap<String, List<String>> areaCityList) {
		this.areaCityList = areaCityList;
	}

	public List<String> getHomeCityList() {
		return homeCityList;
	}

	public void setHomeCityList(List<String> homeCityList) {
		this.homeCityList = homeCityList;
	}
	
	public List<StrategyFileInfo> getSfIsTopSeasonList() {
		return sfIsTopSeasonList;
	}

	public void setSfIsTopSeasonList(List<StrategyFileInfo> sfIsTopSeasonList) {
		this.sfIsTopSeasonList = sfIsTopSeasonList;
	}
	
	
	public List<StrategyFileInfo> getSfAmountOfDownloadList() {
		return sfAmountOfDownloadList;
	}

	public void setSfAmountOfDownloadList(
			List<StrategyFileInfo> sfAmountOfDownloadList) {
		this.sfAmountOfDownloadList = sfAmountOfDownloadList;
	}
	
	public List<StrategyFileInfo> getSfUpdateTimeList() {
		return sfUpdateTimeList;
	}

	public void setSfUpdateTimeList(List<StrategyFileInfo> sfUpdateTimeList) {
		this.sfUpdateTimeList = sfUpdateTimeList;
	}

	public String load(){
		topPhotoList = homepageService.findTopPhotoList();
		int i = 0;
		for(Entry<String,String> entry : topPhotoList.entrySet()){
			if(i==0){
				firstTopPhotoRealName = entry.getKey();
				firstTopPhotoCityName = entry.getValue();
				i++;
			}
			else{
				lastTopPhotoRealName = entry.getKey();
				lastTopPhotoCityName = entry.getValue();
			}
		}

		topSeasonCityList = homepageService.findTopSeasonTD();
		tdTopSeasonList = homepageService.findIsTopSeason();
		tdThemeTypeList = homepageService.findIsThemeType();
		themeTypeCityList = homepageService.findThemeTypeTD();
		areaCityList = homepageService.findTD();		
		homeCityList = homepageService.findHomeTD();
		sfIsTopSeasonList = homepageService.findIsTop();
		sfAmountOfDownloadList = homepageService.findAmountOfDownload();
		sfUpdateTimeList = homepageService.findUpdateTime();
		return SUCCESS;
	}
	
}
