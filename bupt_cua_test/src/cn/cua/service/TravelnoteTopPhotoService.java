package cn.cua.service;


import java.util.List;

import cn.cua.dao.TravelnoteTopPhotoInfoDAO;
import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.domain.TravelnoteTopPhotoInfo;

public class TravelnoteTopPhotoService {
	private TravelnoteTopPhotoInfoDAO travelnoteTopPhotoDao = new TravelnoteTopPhotoInfoDAO();
		
	/**
	 * 分页操作，得到分页总数
	 * @return
	 */
	public int getTravelnoteTopPhotoAmount(){
		return travelnoteTopPhotoDao.getTravelnoteTopPhotoAmount();
	}
	
	/**
	 * 查询所有攻略
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TravelnoteTopPhotoInfo> findAll(int pageNum,int pageSize){
		return travelnoteTopPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * 增加游记首页图片
	 * @param travelnoteTopPhoto
	 */
	public void add(TravelnoteTopPhotoInfo travelnoteTopPhoto){
		travelnoteTopPhotoDao.add(travelnoteTopPhoto);
	}
	
	/**
	 * 修改功能的加载操作
	 * @param travelnoteTopPhotoId
	 * @return
	 */
	public TravelnoteTopPhotoInfo load(int travelnoteTopPhotoId){
		return travelnoteTopPhotoDao.load(travelnoteTopPhotoId);
	}
	
	/**
	 * 修改操作
	 * @param strategyTopPhoto
	 */
	public void edit(TravelnoteTopPhotoInfo travelnoteTopPhoto){
		travelnoteTopPhotoDao.edit(travelnoteTopPhoto);			
	}
	
	/**
	 * 删除游记首页图片
	 * @param travelnoteTopPhotoId
	 */
	public void delete(int travelnoteTopPhotoId){
		travelnoteTopPhotoDao.delete(travelnoteTopPhotoId);
	}
}
