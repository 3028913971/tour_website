package cn.cua.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.cua.domain.TdTopPhotoInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.service.CityPageService;
import cn.cua.service.TdTopPhotoService;

import com.opensymphony.xwork2.ActionSupport;

public class CityPageAction extends ActionSupport {
	
	private CityPageService cpService= new CityPageService();
	private TdTopPhotoService tdTopPhotoService = new TdTopPhotoService();
	
	private List<TravelDestinationInfo> topSeasonCityList = new ArrayList<TravelDestinationInfo>();
	private LinkedHashMap<ThemeInfo,List<String>> themeTypeCityList = new LinkedHashMap<ThemeInfo,List<String>>();
	private LinkedHashMap<String,List<String>> homeCityList = new LinkedHashMap<String,List<String>>();
	private TdTopPhotoInfo topPhoto = null;
	
	
	
	


	public TdTopPhotoInfo getTopPhoto() {
		return topPhoto;
	}

	public void setTopPhoto(TdTopPhotoInfo topPhoto) {
		this.topPhoto = topPhoto;
	}

	public List<TravelDestinationInfo> getTopSeasonCityList() {
		return topSeasonCityList;
	}

	public void setTopSeasonCityList(List<TravelDestinationInfo> topSeasonCityList) {
		this.topSeasonCityList = topSeasonCityList;
	}

	

	public LinkedHashMap<ThemeInfo, List<String>> getThemeTypeCityList() {
		return themeTypeCityList;
	}

	public void setThemeTypeCityList(LinkedHashMap<ThemeInfo, List<String>> themeTypeCityList) {
		this.themeTypeCityList = themeTypeCityList;
	}

	public LinkedHashMap<String, List<String>> getHomeCityList() {
		return homeCityList;
	}

	public void setHomeCityList(LinkedHashMap<String, List<String>> homeCityList) {
		this.homeCityList = homeCityList;
	}

	public String loadCity(){
		topSeasonCityList = cpService.findIsTopSeason();
		themeTypeCityList = cpService.findThemeTypeList();
		homeCityList = cpService.findTD();
		topPhoto = tdTopPhotoService.getOnePic();
		return SUCCESS;
	}
	
	private String search;
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String searchCity() throws UnsupportedEncodingException{
		if(cpService.load(search) == null || cpService.load(search).getCityName().isEmpty()){
			return "searchCityFailed";
		}
		return "searchCitySucc";	
	}
}
