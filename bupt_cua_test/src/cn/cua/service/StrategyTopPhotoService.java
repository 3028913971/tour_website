package cn.cua.service;


import java.util.List;

import cn.cua.dao.StrategyTopPhotoInfoDAO;
import cn.cua.domain.StrategyTopPhotoInfo;
import cn.cua.domain.TopPhotoInfo;

public class StrategyTopPhotoService {
	private StrategyTopPhotoInfoDAO strategyTopPhotoDao = new StrategyTopPhotoInfoDAO();
		
	/**
	 * ��ҳ�������õ���ҳ����
	 * @return
	 */
	public int getStrategyTopPhotoAmount(){
		return strategyTopPhotoDao.getStrategyTopPhotoAmount();
	}
	
	/**
	 * ��ѯ���й���
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<StrategyTopPhotoInfo> findAll(int pageNum,int pageSize){
		return strategyTopPhotoDao.findAll(pageNum, pageSize);
	}

	/**
	 * ���ӹ��Թ���ͼƬ
	 * @param strategyTopPhoto
	 */
	public void add(StrategyTopPhotoInfo strategyTopPhoto){
		strategyTopPhotoDao.add(strategyTopPhoto);
	}
	
	/**
	 * �޸Ĺ��ܵļ��ز���
	 * @param strategyTopPhotoId
	 * @return
	 */
	public StrategyTopPhotoInfo load(int strategyTopPhotoId){
		return strategyTopPhotoDao.load(strategyTopPhotoId);
	}
	
	/**
	 * �޸Ĳ���
	 * @param strategyTopPhoto
	 */
	public void edit(StrategyTopPhotoInfo strategyTopPhoto){
		strategyTopPhotoDao.edit(strategyTopPhoto);			
	}
	
	/**
	 * ɾ�����Թ���ͼƬ
	 * @param strategyTopPhotoId
	 */
	public void delete(int strategyTopPhotoId){
		strategyTopPhotoDao.delete(strategyTopPhotoId);
	}
}
