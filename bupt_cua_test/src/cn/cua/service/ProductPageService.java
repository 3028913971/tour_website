package cn.cua.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.cua.dao.ProductPageDAO;
import cn.cua.domain.ProductInfo;
import cn.cua.domain.ThemeInfo;

public class ProductPageService {
	
	private ProductPageDAO ppDao = new ProductPageDAO();
	
	/**
	 * ��Ʒ�Ƽ���ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<ThemeInfo,List<String>> findThemeTypeList(){
		return ppDao.findThemeTypeList();
	}
	
	/**
	 * ��Ʒ������ҳ-����Ŀ�ĵ��Ƽ�
	 * @return
	 */
	public LinkedHashMap<String,List<String>> findHomeTD(){
		return ppDao.findHomeTD();
	}
	
	/**
	 * ��Ʒ������ҳ-���в�Ʒ����
	 * @return
	 */
	public int getAmountOfIsTop(){
		return ppDao.getAmountOfIsTop();
	}
	
	/**
	 * ��Ʒ������ҳ-���в�ƷĬ����������
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findIsTop(int pageNum,int pageSize){
		return ppDao.findIsTop(pageNum, pageSize);
	}
	
	/**
	 * ��Ʒ������ҳ-���в�Ʒ�۸�����
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findPrice(int pageNum,int pageSize){
		return ppDao.findPrice(pageNum, pageSize);
	}
	
	/**
	 * ��Ʒ�Ƽ���ҳ-������Ʒ-��ҳ
	 * @param productName
	 * @return
	 */
	public int getAmountOfSearch(String search){
		return ppDao.getAmountOfSearch(search);
	}
	
	/**
	 * ��Ʒ�Ƽ���ҳ-�����۸�����
	 * @param search
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findSearchPrice(String search,int pageNum,int pageSize){
		return ppDao.findSearchPrice(search, pageNum, pageSize);
	}
	
	/**
	 * ��Ʒ�Ƽ���ҳ-�������Ų�Ʒ
	 * @param search
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findSearchIsTop(String search,int pageNum,int pageSize){
		return ppDao.findSearchIsTop(search, pageNum, pageSize);
	}
}
