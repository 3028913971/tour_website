package cn.cua.service;

import java.util.List;

import cn.cua.dao.StrategyFileDownloadPageDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;

public class StrategyFileDownloadPageService {

	private StrategyFileDownloadPageDAO sfdpDao= new StrategyFileDownloadPageDAO();
	
	/**
	 * 得到该城市对应攻略的信息；
	 * @param cityName
	 * @return
	 */
	public StrategyFileInfo getStrategyByCityName(String cityName){
		StrategyFileInfo sf = sfdpDao.getStrategyByCityName(cityName);
		sf.setUpdateTime(sf.getUpdateTime().split(" ")[0]);
		return sf;
	}
	
	/**
	 * 得到城市的描述信息
	 * @param cityName
	 * @return
	 */
	public String getCityDescrption(String cityName){
		return sfdpDao.getCityDescrption(cityName);
	}
	
	/**
	 * 得到该城市所属省份的其他城市攻略
	 * @param cityName
	 * @return
	 */
	public List<StrategyFileInfo> getRelevantCity(String cityName){
		return sfdpDao.getRelevantCity(cityName);
	}
	
	/**
	 * 得到该城市所属省份的其他城市
	 * @param cityName
	 * @return
	 */
	public List<TravelDestinationInfo> getRelevantCityList(String cityName){
		return sfdpDao.getRelevantCityList(cityName);
	}
	
	/**
	 * 下载时更新数据库的下载次数
	 * @param cityName
	 */
	public void downloadAmount(String cityName){
		sfdpDao.downloadAmount(cityName);
	}
}
