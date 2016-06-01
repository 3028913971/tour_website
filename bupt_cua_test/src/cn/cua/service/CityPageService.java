package cn.cua.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.CityPageDAO;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;

public class CityPageService {
	
	private CityPageDAO cpDao = new CityPageDAO();
	
	/**
	 * 目的地推荐首页-本季热门推荐
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		return cpDao.findIsTopSeason();
	}
	
	/**
	 * 目的地推荐首页-主题目的地推荐
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		return cpDao.findThemeTypeList();
	}
	
	/**
	 * 目的地推荐首页-国内目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		return cpDao.findTD();
	}

	/**
	 * 通过城市名寻找对应的城市信息,判断城市是否存在
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		return cpDao.load(cityName);
	}
}
