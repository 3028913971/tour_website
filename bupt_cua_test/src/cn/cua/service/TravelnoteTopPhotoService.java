package cn.cua.service;


import java.util.List;

import cn.cua.dao.TravelnoteTopPhotoInfoDAO;
import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.domain.TravelnoteTopPhotoInfo;

public class TravelnoteTopPhotoService {
	private TravelnoteTopPhotoInfoDAO travelnoteTopPhotoDao = new TravelnoteTopPhotoInfoDAO();
		
	/**
	 * ��ҳ�������õ���ҳ����
	 * @return
	 */
	public int getTravelnoteTopPhotoAmount(){
		return travelnoteTopPhotoDao.getTravelnoteTopPhotoAmount();
	}
	
	/**
	 * ��ѯ���й���
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<TravelnoteTopPhotoInfo> findAll(int pageNum,int pageSize){
		return travelnoteTopPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * �����μ���ҳͼƬ
	 * @param travelnoteTopPhoto
	 */
	public void add(TravelnoteTopPhotoInfo travelnoteTopPhoto){
		travelnoteTopPhotoDao.add(travelnoteTopPhoto);
	}
	
	/**
	 * �޸Ĺ��ܵļ��ز���
	 * @param travelnoteTopPhotoId
	 * @return
	 */
	public TravelnoteTopPhotoInfo load(int travelnoteTopPhotoId){
		return travelnoteTopPhotoDao.load(travelnoteTopPhotoId);
	}
	
	/**
	 * �޸Ĳ���
	 * @param strategyTopPhoto
	 */
	public void edit(TravelnoteTopPhotoInfo travelnoteTopPhoto){
		travelnoteTopPhotoDao.edit(travelnoteTopPhoto);			
	}
	
	/**
	 * ɾ���μ���ҳͼƬ
	 * @param travelnoteTopPhotoId
	 */
	public void delete(int travelnoteTopPhotoId){
		travelnoteTopPhotoDao.delete(travelnoteTopPhotoId);
	}
}
