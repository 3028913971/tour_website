package cn.cua.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.service.StrategyFileFirstPageService;

import com.opensymphony.xwork2.ActionSupport;

public class StrategyFileFirstPageAction extends ActionSupport {
	private StrategyFileFirstPageService sffpService = new StrategyFileFirstPageService();
	
	private List<String> topPicList = new ArrayList<String>();//����������ҳ����ͼƬ
	private LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> themeTypeCityList = new LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>>();//����������ҳ-���⹥���б�
	private List<StrategyFileInfo> isTopList = new ArrayList<StrategyFileInfo>();//����������ҳ-�������ܻ�ӭ�����б�
	private List<StrategyFileInfo> amountOfDownloadList = new ArrayList<StrategyFileInfo>();//����������ҳ-���������б�
	private List<StrategyFileInfo> updatetimeList = new ArrayList<StrategyFileInfo>();//����������ҳ-����ʱ���б�
	private LinkedHashMap<String,List<String>> areaCityList = new LinkedHashMap<String,List<String>>();//����������ҳ-����Ŀ�ĵ��Ƽ�
	private LinkedHashMap<ThemeInfo,List<String>> themeCityList = new LinkedHashMap<ThemeInfo,List<String>>();//����������ҳ-����Ŀ�ĵ��Ƽ�
	
		
	public List<String> getTopPicList() {
		return topPicList;
	}
	public void setTopPicList(List<String> topPicList) {
		this.topPicList = topPicList;
	}
	
	public LinkedHashMap<ThemeInfo, List<TravelDestinationInfo>> getThemeTypeCityList() {
		return themeTypeCityList;
	}
	public void setThemeTypeCityList(
			LinkedHashMap<ThemeInfo, List<TravelDestinationInfo>> themeTypeCityList) {
		this.themeTypeCityList = themeTypeCityList;
	}
	public List<StrategyFileInfo> getIsTopList() {
		return isTopList;
	}
	public void setIsTopList(List<StrategyFileInfo> isTopList) {
		this.isTopList = isTopList;
	}
	public List<StrategyFileInfo> getAmountOfDownloadList() {
		return amountOfDownloadList;
	}
	public void setAmountOfDownloadList(List<StrategyFileInfo> amountOfDownloadList) {
		this.amountOfDownloadList = amountOfDownloadList;
	}
	public List<StrategyFileInfo> getUpdatetimeList() {
		return updatetimeList;
	}
	public void setUpdatetimeList(List<StrategyFileInfo> updatetimeList) {
		this.updatetimeList = updatetimeList;
	}
	public LinkedHashMap<String, List<String>> getAreaCityList() {
		return areaCityList;
	}
	public void setAreaCityList(LinkedHashMap<String, List<String>> areaCityList) {
		this.areaCityList = areaCityList;
	}
	
	
	public LinkedHashMap<ThemeInfo, List<String>> getThemeCityList() {
		return themeCityList;
	}
	public void setThemeCityList(LinkedHashMap<ThemeInfo, List<String>> themeCityList) {
		this.themeCityList = themeCityList;
	}
	public String loadStrategy(){
		topPicList = sffpService.findPictures();
		themeTypeCityList = sffpService.findThemeTypeTD();
		isTopList = sffpService.findIsTop();
		amountOfDownloadList = sffpService.findAmountOfDownload();
		updatetimeList = sffpService.findUpdateTime();
		areaCityList = sffpService.findTD();
		themeCityList = sffpService.findThemeTypeList();
		
		return SUCCESS;
	}
	
	private String search;

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public String searchStrategy(){
		
		if(sffpService.getStrategyByCityName(search) == null || sffpService.getStrategyByCityName(search).getCityName().isEmpty()){
			return "searchStrategyFailed";
		}
		
		return "searchStrategySucc";
	}
}
