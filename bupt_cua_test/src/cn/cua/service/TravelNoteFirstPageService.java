package cn.cua.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.TravelNoteFirstPageDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;

public class TravelNoteFirstPageService {
	private TravelNoteFirstPageDAO tnfpDao = new TravelNoteFirstPageDAO();
	/**
	 * 首页最上端滚动图片
	 * @return
	 */
	public List<String> findPictures(){
		return tnfpDao.findPictures();
	}
	
	/**
	 * 游记首页-主题目的地
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findThemeTypeList(){
		return tnfpDao.findThemeTypeList();
	}
	
	/**
	 * 游记首页-国内目的地
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findHomeTD(){
		return tnfpDao.findHomeTD();
	}
	
	/**
	 * 游记首页-热门目的地
	 * @return
	 */
	public List<TravelDestinationInfo> findIsTopSeason(){
		return tnfpDao.findIsTopSeason();
	}
	
	/**
	 * 所有游记的数量
	 * @return
	 */
	public int getAmount(){
		return tnfpDao.getAmount();
	}
	
	/**
	 * 游记热门排序
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnfpDao.findIsTop(pageNum, pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 游记发布时间排序
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnfpDao.findPublicTime(pageNum, pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
}
