package cn.cua.service;


import java.util.List;

import cn.cua.dao.StrategyTopPhotoInfoDAO;
import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.domain.TopPhotoInfo;

public class StrategyTopPhotoService {
	private StrategyTopPhotoInfoDAO strategyTopPhotoDao = new StrategyTopPhotoInfoDAO();
		
	/**
	 * 分页操作，得到分页总数
	 * @return
	 */
	public int getStrategyTopPhotoAmount(){
		return strategyTopPhotoDao.getStrategyTopPhotoAmount();
	}
	
	/**
	 * 查询所有攻略
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<StrategyTopPhotoInfo> findAll(int pageNum,int pageSize){
		return strategyTopPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * 增加攻略滚动图片
	 * @param strategyTopPhoto
	 */
	public void add(StrategyTopPhotoInfo strategyTopPhoto){
		strategyTopPhotoDao.add(strategyTopPhoto);
	}
	
	/**
	 * 修改功能的加载操作
	 * @param strategyTopPhotoId
	 * @return
	 */
	public StrategyTopPhotoInfo load(int strategyTopPhotoId){
		return strategyTopPhotoDao.load(strategyTopPhotoId);
	}
	
	/**
	 * 修改操作
	 * @param strategyTopPhoto
	 */
	public void edit(StrategyTopPhotoInfo strategyTopPhoto){
		strategyTopPhotoDao.edit(strategyTopPhoto);			
	}
	
	/**
	 * 删除攻略滚动图片
	 * @param strategyTopPhotoId
	 */
	public void delete(int strategyTopPhotoId){
		strategyTopPhotoDao.delete(strategyTopPhotoId);
	}
}
