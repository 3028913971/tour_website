package cn.cua.service;


import java.util.List;

import cn.cua.dao.AdminInfoDAO;
import cn.cua.dao.TravelDestinationInfoDAO;
import cn.cua.domain.AdminInfo;
import cn.cua.domain.TravelDestinationInfo;

public class TravelDestinationService {
	private TravelDestinationInfoDAO travelDestinationDao= new TravelDestinationInfoDAO();
	
	
	public List<String> getThemeList(){
		return travelDestinationDao.getThemeList();
	}
	
	/**
	 * 分页操作，得到旅游地总数
	 * @return
	 */
	public int getDestinationAmount(){
		return travelDestinationDao.getTravelDestinationAmount();
	}
	
	/**
	 * 查询所有旅游地
	 * @return
	 */
	public List<TravelDestinationInfo> findAll(int pageNum,int pageSize){
		return travelDestinationDao.findAll(pageNum, pageSize);
	}
	
	/**
	 * 增加旅游地信息
	 * @param travelDestinationInfo
	 * @throws TravelDestinationException 
	 */
	public void add(TravelDestinationInfo travelDestinationInfo) throws TravelDestinationException{
		
		List<TravelDestinationInfo> travelDestinationList = travelDestinationDao.findBycityName(travelDestinationInfo.getCityName());
		if(travelDestinationList.size() != 0){
			throw new TravelDestinationException("旅游地名已存在，请更换旅游地名！");
		}else{
			travelDestinationDao.add(travelDestinationInfo);
		}	
		
	}
	
	/**
	 * 修改功能的加载操作
	 * @param cityName
	 * @return
	 */
	public TravelDestinationInfo load(String cityName){
		return travelDestinationDao.load(cityName);
	}
	
	/**
	 * 修改操作
	 * @param travelDestinationInfo
	 * @throws TravelDestinationException 
	 */
	public void edit(TravelDestinationInfo travelDestinationInfo) throws TravelDestinationException{	
		travelDestinationDao.edit(travelDestinationInfo);
	}

	/**
	 * 删除操作
	 * @param cityName
	 */
	public void delete(String cityName){
		travelDestinationDao.delete(cityName);
	}
	
	/**
	 * 组合查询分页操作，得到旅游地总数
	 * @return
	 */
	public int getQueryAmount(TravelDestinationInfo travelDestinationInfo){
		return travelDestinationDao.getQueryAmount(travelDestinationInfo);
	}
	
	/**
	 * 组合查询功能
	 * @param travelDestinationInfo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TravelDestinationInfo> query(TravelDestinationInfo travelDestinationInfo,int pageNum,int pageSize){
		return travelDestinationDao.query(travelDestinationInfo, pageNum, pageSize);
	}
	/**
	 * 返回所有的旅游地信息
	 * @return
	 */
	public List<TravelDestinationInfo> findAll() {
		return travelDestinationDao.findAll();
	}
}
