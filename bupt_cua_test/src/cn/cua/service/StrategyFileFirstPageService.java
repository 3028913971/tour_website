package cn.cua.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.StrategyFileFirstPageDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.ThemeInfo;
import cn.cua.domain.TravelDestinationInfo;

public class StrategyFileFirstPageService {
	
	private StrategyFileFirstPageDAO sffpDao = new StrategyFileFirstPageDAO();

	/**
	 * 攻略下载首页最上端滚动图片
	 * @return
	 */
	public List<String> findPictures(){
		return sffpDao.findPictures();
	}
	
	/**
	 * 攻略下载首页-主题攻略列表
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> findThemeTypeTD(){
		return sffpDao.findThemeTypeTD();
	}
	
	/**
	 * 攻略下载首页-本季最受欢迎
	 * @return
	 */
	public List<StrategyFileInfo> findIsTop(){
		List<StrategyFileInfo> list = sffpDao.findIsTop();
		for(int i=0;i<list.size();i++){
			list.get(i).setUpdateTime(list.get(i).getUpdateTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 攻略下载首页-下载人气
	 * @return
	 */
	public List<StrategyFileInfo> findAmountOfDownload(){
		List<StrategyFileInfo> list = sffpDao.findAmountOfDownload();
		for(int i=0;i<list.size();i++){
			list.get(i).setUpdateTime(list.get(i).getUpdateTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 攻略下载首页-更新时间
	 * @return
	 */
	public List<StrategyFileInfo> findUpdateTime(){
		List<StrategyFileInfo> list = sffpDao.findUpdateTime();
		for(int i=0;i<list.size();i++){
			list.get(i).setUpdateTime(list.get(i).getUpdateTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 攻略下载首页-国内目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		return sffpDao.findTD();
	}
	
	/**
	 * 攻略下载首页-主题目的地推荐
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		return sffpDao.findThemeTypeList();
	}
	
	/**
	 * 通过城市名寻找对应的城市信息,判断城市攻略是否存在
	 * @param cityName
	 * @return
	 */
	public StrategyFileInfo getStrategyByCityName(String cityName){
		return sffpDao.getStrategyByCityName(cityName);
	}
}
