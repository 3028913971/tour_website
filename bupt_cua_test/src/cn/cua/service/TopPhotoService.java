package cn.cua.service;


import java.util.List;

import cn.cua.dao.TopPhotoInfoDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TopPhotoInfo;

public class TopPhotoService {
	private TopPhotoInfoDAO topPhotoDao = new TopPhotoInfoDAO();
	
	public List<String> getCityList(){
		return topPhotoDao.getCityList();
	}
	
	/**
	 * 分页操作，得到分页总数
	 * @return
	 */
	public int getTopPhotoAmount(){
		return topPhotoDao.getTopPhotoAmount();
	}
	
	/**
	 * 查询所有图片
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TopPhotoInfo> findAll(int pageNum,int pageSize){
		return topPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * 增加图片文件
	 * @param topPhoto
	 */
	public void add(TopPhotoInfo topPhoto){
		topPhotoDao.add(topPhoto);
	}
	
	/**
	 * 修改功能的加载操作
	 * @param topPhotoId
	 * @return
	 */
	public TopPhotoInfo load(int topPhotoId){
		return topPhotoDao.load(topPhotoId);
	}
	
	/**
	 * 修改操作
	 * @param topPhoto
	 */
	public void edit(TopPhotoInfo topPhoto){
		topPhotoDao.edit(topPhoto);			
	}
	/**
	 * 删除文件
	 * @param topPhotoId
	 */
	public void delete(int topPhotoId){
		topPhotoDao.delete(topPhotoId);
	}
}
