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
	 * ����������ҳ���϶˹���ͼƬ
	 * @return
	 */
	public List<String> findPictures(){
		return sffpDao.findPictures();
	}
	
	/**
	 * ����������ҳ-���⹥���б�
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<TravelDestinationInfo>> findThemeTypeTD(){
		return sffpDao.findThemeTypeTD();
	}
	
	/**
	 * ����������ҳ-�������ܻ�ӭ
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
	 * ����������ҳ-��������
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
	 * ����������ҳ-����ʱ��
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
	 * ����������ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		return sffpDao.findTD();
	}
	
	/**
	 * ����������ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		return sffpDao.findThemeTypeList();
	}
	
	/**
	 * ͨ��������Ѱ�Ҷ�Ӧ�ĳ�����Ϣ,�жϳ��й����Ƿ����
	 * @param cityName
	 * @return
	 */
	public StrategyFileInfo getStrategyByCityName(String cityName){
		return sffpDao.getStrategyByCityName(cityName);
	}
}
