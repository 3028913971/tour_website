package cn.cua.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.HomePageDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;

public class HomePageService {
	private HomePageDAO homePageDao = new HomePageDAO();
	
	/**
	 * 首页最上端滚动图片
	 * @return
	 */
	public List<String> findPictures(){
		return homePageDao.findPictures();
	}
	
	/**
	 * 首页本季热门推荐
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		List<TravelDestinationInfo> temp = new ArrayList<TravelDestinationInfo>();
		temp = homePageDao.findIsTopSeason();
		for(int i=0;i<temp.size();i++){
			String para = temp.get(i).getDescription();
			if(para.length()>10){
				para.substring(0, 9);
				para = para+"...";
			}
			
			temp.get(i).setDescription(para);
		}
		return temp;
	}
	
	
	/**
	 * 首页主题目的地推荐
	 * @return
	 */
	public List<TravelDestinationInfo> findIsThemeType(){
		return homePageDao.findIsThemeType();
	}
	
	/**
	 * 首页攻略下载-本季最受欢迎
	 * @return
	 */
	public List<StrategyFileInfo> findIsTop(){
		List<StrategyFileInfo> list = homePageDao.findIsTop();
		for(int i=0;i<list.size();i++){
			list.get(i).setUpdateTime(list.get(i).getUpdateTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 首页攻略下载-下载人气
	 * @return
	 */
	public List<StrategyFileInfo> findAmountOfDownload(){
		List<StrategyFileInfo> list = homePageDao.findAmountOfDownload();
		for(int i=0;i<list.size();i++){
			list.get(i).setUpdateTime(list.get(i).getUpdateTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 首页攻略下载-更新时间
	 * @return
	 */
	public List<StrategyFileInfo> findUpdateTime(){
		List<StrategyFileInfo> list = homePageDao.findUpdateTime();
		for(int i=0;i<list.size();i++){
			list.get(i).setUpdateTime(list.get(i).getUpdateTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 首页上端选项卡-本季热门推荐城市列表
	 * @return
	 */
	public List<String> findTopSeasonTD(){
		return homePageDao.findTopSeasonTD();
	}
	
	/**
	 * 首页上端选项卡-主题目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeTD(){
		return homePageDao.findThemeTypeTD();
	}
	
	/**
	 *首页上端选项卡-国内目的地推荐
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		return homePageDao.findTD();
	}
	
	/**
	 * 首页最下端国内城市列表
	 * @return
	 */
	public List<String> findHomeTD(){

		return homePageDao.findHomeTD();
	}
	
	public LinkedHashMap<String,String> findTopPhotoList(){
		return homePageDao.findTopPhotoList();
	}

}
