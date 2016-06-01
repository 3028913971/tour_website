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
	 * ��ҳ�������õ���ҳ����
	 * @return
	 */
	public int getTopPhotoAmount(){
		return topPhotoDao.getTopPhotoAmount();
	}
	
	/**
	 * ��ѯ����ͼƬ
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TopPhotoInfo> findAll(int pageNum,int pageSize){
		return topPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * ����ͼƬ�ļ�
	 * @param topPhoto
	 */
	public void add(TopPhotoInfo topPhoto){
		topPhotoDao.add(topPhoto);
	}
	
	/**
	 * �޸Ĺ��ܵļ��ز���
	 * @param topPhotoId
	 * @return
	 */
	public TopPhotoInfo load(int topPhotoId){
		return topPhotoDao.load(topPhotoId);
	}
	
	/**
	 * �޸Ĳ���
	 * @param topPhoto
	 */
	public void edit(TopPhotoInfo topPhoto){
		topPhotoDao.edit(topPhoto);			
	}
	/**
	 * ɾ���ļ�
	 * @param topPhotoId
	 */
	public void delete(int topPhotoId){
		topPhotoDao.delete(topPhotoId);
	}
}
