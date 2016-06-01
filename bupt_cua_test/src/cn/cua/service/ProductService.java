package cn.cua.service;

import java.util.List;

import cn.cua.dao.ProductInfoDAO;
import cn.cua.domain.ProductInfo;

/**
 * ��Ʒ��Ϣ��ҵ����
 * @author Sandm
 *
 */
public class ProductService {
	private ProductInfoDAO productInfoDao =new ProductInfoDAO();

	public ProductService() {
		super();
	}

	/**
	 * �������в�Ʒ��
	 * @return
	 */
	public int getProductAmount() {
		return productInfoDao.getProductAmount();
	}
	
	/**
	 * ���ط����ض������Ĳ�Ʒ��
	 * @param model
	 * @return
	 */
	public int getProductAmount(ProductInfo model) {
		return productInfoDao.getProductAmount(model);
	}

	/**
	 * �������в�Ʒ
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findAll(int pageNum, int pageSize) {
		return productInfoDao.findAll(pageNum,pageSize);
	}
	
	/**
	 * ���ط����ض����������в�Ʒ
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findAll(ProductInfo model, int pageNum, int pageSize) {
		return productInfoDao.findAll(model,pageNum, pageSize);
	}

	/**
	 * ���Ӳ�Ʒ
	 * @param model
	 */
	public void add(ProductInfo model) {
		productInfoDao.add(model);
	}

	/**
	 * ɾ����Ʒ
	 * @param productId
	 */
	public void delete(int productId) {
		productInfoDao.delete(productId);
	}

	/**
	 * ���ز�Ʒ
	 * @param productId
	 * @return
	 */
	public ProductInfo load(int productId) {
		return productInfoDao.load(productId);
	}

	/**
	 * �༭��Ʒ
	 * @param model
	 */
	public void edit(ProductInfo model) {
		productInfoDao.edit(model);
	}

	public boolean isUnique(String proName) {
		List<ProductInfo> productInfos = productInfoDao.findAll();
		for(ProductInfo productInfo:productInfos){
			if(proName.equals(productInfo.getProductName())){
				return false;
			}
		}
		return true;
	}

	public boolean isUnique(ProductInfo model) {
		List<ProductInfo> productInfos = productInfoDao.findAll();
		for(ProductInfo productInfo:productInfos){
			if(model.getProductName().equals(productInfo.getProductName())){
				if(model.getProductId()!=productInfo.getProductId()){
					return false;
				}
			}
		}
		return true;
	}

	
}
