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
	 * ��ҳ���϶˹���ͼƬ
	 * @return
	 */
	public List<String> findPictures(){
		return homePageDao.findPictures();
	}
	
	/**
	 * ��ҳ���������Ƽ�
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
	 * ��ҳ����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public List<TravelDestinationInfo> findIsThemeType(){
		return homePageDao.findIsThemeType();
	}
	
	/**
	 * ��ҳ��������-�������ܻ�ӭ
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
	 * ��ҳ��������-��������
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
	 * ��ҳ��������-����ʱ��
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
	 * ��ҳ�϶�ѡ�-���������Ƽ������б�
	 * @return
	 */
	public List<String> findTopSeasonTD(){
		return homePageDao.findTopSeasonTD();
	}
	
	/**
	 * ��ҳ�϶�ѡ�-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeTD(){
		return homePageDao.findThemeTypeTD();
	}
	
	/**
	 *��ҳ�϶�ѡ�-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findTD(){
		return homePageDao.findTD();
	}
	
	/**
	 * ��ҳ���¶˹��ڳ����б�
	 * @return
	 */
	public List<String> findHomeTD(){

		return homePageDao.findHomeTD();
	}
	
	public LinkedHashMap<String,String> findTopPhotoList(){
		return homePageDao.findTopPhotoList();
	}

}
