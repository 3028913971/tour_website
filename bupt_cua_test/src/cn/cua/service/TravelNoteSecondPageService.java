package cn.cua.service;

import java.util.List;

import cn.cua.dao.TravelNoteSecondPageDAO;
import cn.cua.domain.TravelDestinationInfo;
import cn.cua.domain.TravelNoteInfo;

public class TravelNoteSecondPageService {
	private TravelNoteSecondPageDAO tnspDao = new TravelNoteSecondPageDAO();
	/**
	 * 得到城市的描述信息
	 * 
	 * */
	public TravelDestinationInfo getCity(String cityName){
		return tnspDao.getCity(cityName);
	}
	
	/**
	 * 游记二级页面-分页计数
	 * @param cityName
	 * @return
	 */
	public int getAmount(String cityName){
		return tnspDao.getAmount(cityName);
	}
	
	/**
	 * 游记热门排序
	 * @return
	 */
	public List<TravelNoteInfo> findIsTop(String cityName,int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnspDao.findIsTop(cityName, pageNum, pageSize);
		if(list == null){
			return null;
		}
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
	
	/**
	 * 游记发布时间排序
	 * @return
	 */
	public List<TravelNoteInfo> findPublicTime(String cityName,int pageNum,int pageSize){
		List<TravelNoteInfo> list = tnspDao.findPublicTime(cityName, pageNum, pageSize);
		for(int i=0;i<list.size();i++){
			list.get(i).setPublicTime(list.get(i).getPublicTime().split(" ")[0]);
		}
		return list;
	}
}
