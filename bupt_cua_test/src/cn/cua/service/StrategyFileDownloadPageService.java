package cn.cua.service;

import java.util.List;

import cn.cua.dao.StrategyFileDownloadPageDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;

public class StrategyFileDownloadPageService {

	private StrategyFileDownloadPageDAO sfdpDao= new StrategyFileDownloadPageDAO();
	
	/**
	 * �õ��ó��ж�Ӧ���Ե���Ϣ��
	 * @param cityName
	 * @return
	 */
	public StrategyFileInfo getStrategyByCityName(String cityName){
		StrategyFileInfo sf = sfdpDao.getStrategyByCityName(cityName);
		sf.setUpdateTime(sf.getUpdateTime().split(" ")[0]);
		return sf;
	}
	
	/**
	 * �õ����е�������Ϣ
	 * @param cityName
	 * @return
	 */
	public String getCityDescrption(String cityName){
		return sfdpDao.getCityDescrption(cityName);
	}
	
	/**
	 * �õ��ó�������ʡ�ݵ��������й���
	 * @param cityName
	 * @return
	 */
	public List<StrategyFileInfo> getRelevantCity(String cityName){
		return sfdpDao.getRelevantCity(cityName);
	}
	
	/**
	 * �õ��ó�������ʡ�ݵ���������
	 * @param cityName
	 * @return
	 */
	public List<TravelDestinationInfo> getRelevantCityList(String cityName){
		return sfdpDao.getRelevantCityList(cityName);
	}
	
	/**
	 * ����ʱ�������ݿ�����ش���
	 * @param cityName
	 */
	public void downloadAmount(String cityName){
		sfdpDao.downloadAmount(cityName);
	}
}
