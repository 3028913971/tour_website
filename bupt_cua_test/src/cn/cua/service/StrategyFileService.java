package cn.cua.service;


import java.util.List;

import cn.cua.dao.StrategyFileInfoDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;

public class StrategyFileService {
	private StrategyFileInfoDAO strategyFileDao = new StrategyFileInfoDAO();
		
	/**
	 * ��ҳ�������õ���ҳ����
	 * @return
	 */
	public int getStrategyFileAmount(){
		return strategyFileDao.getStrategyFileAmount();
	}
	
	/**
	 * ��ѯ���й���
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<StrategyFileInfo> findAll(int pageNum,int pageSize){
		return strategyFileDao.findAll(pageNum, pageSize);
	}
	
	/**
	 * ���ӹ����ļ�
	 * @param strategyFile
	 * @throws StrategyFileException 
	 */
	public void add(StrategyFileInfo strategyFile) throws StrategyFileException{
		List<StrategyFileInfo> strategyFileList = strategyFileDao.findByCityName(strategyFile.getCityName());
		if(strategyFileList.size() != 0){
			throw new StrategyFileException("�����εصĹ����Ѿ����ڣ�");
		}else{
			strategyFileDao.add(strategyFile);
		}				
	}
	
	/**
	 * �޸Ĺ��ܵļ��ز���
	 * @param strategyFileId
	 * @return
	 */
	public StrategyFileInfo load(int strategyFileId){
		return strategyFileDao.load(strategyFileId);
	}
	
	/**
	 * �޸Ĳ���
	 * @param strategyFile
	 * @throws StrategyFileException 
	 */
	public void edit(StrategyFileInfo strategyFile) throws StrategyFileException{
		
		List<StrategyFileInfo> strategyFileList = strategyFileDao.findByCityName(strategyFile.getCityName());
		if(strategyFileList.size() != 0 && strategyFileList.get(0).getStrategyFileId() != strategyFile.getStrategyFileId()){
			throw new StrategyFileException("�����εصĹ����Ѿ����ڣ�");
		}else{
			strategyFileDao.edit(strategyFile);
		}				
	}
	/**
	 * ɾ������
	 * @param strategyFileId
	 */
	public void delete(int strategyFileId){
		strategyFileDao.delete(strategyFileId);
	}
	
	/**
	 * ��ѯ����
	 * @param strategyFileInfo
	 * @return
	 */
	public int getQueryAmount(StrategyFileInfo strategyFileInfo){
		return strategyFileDao.getQueryAmount(strategyFileInfo);
	}
	
	/**
	 * ��ѯ����
	 * @param strategyFileInfo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<StrategyFileInfo> query(StrategyFileInfo strategyFileInfo,int pageNum,int pageSize){
		return strategyFileDao.query(strategyFileInfo,pageNum, pageSize);
	}
	

}
