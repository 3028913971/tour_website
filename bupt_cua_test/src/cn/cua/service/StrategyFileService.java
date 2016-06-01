package cn.cua.service;


import java.util.List;

import cn.cua.dao.StrategyFileInfoDAO;
import cn.cua.domain.StrategyFileInfo;
import cn.cua.domain.TravelDestinationInfo;

public class StrategyFileService {
	private StrategyFileInfoDAO strategyFileDao = new StrategyFileInfoDAO();
		
	/**
	 * 分页操作，得到分页总数
	 * @return
	 */
	public int getStrategyFileAmount(){
		return strategyFileDao.getStrategyFileAmount();
	}
	
	/**
	 * 查询所有攻略
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<StrategyFileInfo> findAll(int pageNum,int pageSize){
		return strategyFileDao.findAll(pageNum, pageSize);
	}
	
	/**
	 * 增加攻略文件
	 * @param strategyFile
	 * @throws StrategyFileException 
	 */
	public void add(StrategyFileInfo strategyFile) throws StrategyFileException{
		List<StrategyFileInfo> strategyFileList = strategyFileDao.findByCityName(strategyFile.getCityName());
		if(strategyFileList.size() != 0){
			throw new StrategyFileException("该旅游地的攻略已经存在！");
		}else{
			strategyFileDao.add(strategyFile);
		}				
	}
	
	/**
	 * 修改功能的加载操作
	 * @param strategyFileId
	 * @return
	 */
	public StrategyFileInfo load(int strategyFileId){
		return strategyFileDao.load(strategyFileId);
	}
	
	/**
	 * 修改操作
	 * @param strategyFile
	 * @throws StrategyFileException 
	 */
	public void edit(StrategyFileInfo strategyFile) throws StrategyFileException{
		
		List<StrategyFileInfo> strategyFileList = strategyFileDao.findByCityName(strategyFile.getCityName());
		if(strategyFileList.size() != 0 && strategyFileList.get(0).getStrategyFileId() != strategyFile.getStrategyFileId()){
			throw new StrategyFileException("该旅游地的攻略已经存在！");
		}else{
			strategyFileDao.edit(strategyFile);
		}				
	}
	/**
	 * 删除操作
	 * @param strategyFileId
	 */
	public void delete(int strategyFileId){
		strategyFileDao.delete(strategyFileId);
	}
	
	/**
	 * 查询操作
	 * @param strategyFileInfo
	 * @return
	 */
	public int getQueryAmount(StrategyFileInfo strategyFileInfo){
		return strategyFileDao.getQueryAmount(strategyFileInfo);
	}
	
	/**
	 * 查询功能
	 * @param strategyFileInfo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<StrategyFileInfo> query(StrategyFileInfo strategyFileInfo,int pageNum,int pageSize){
		return strategyFileDao.query(strategyFileInfo,pageNum, pageSize);
	}
	

}
