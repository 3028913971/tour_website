package cn.cua.service;

import java.util.List;

import cn.cua.dao.ProductInfoDAO;
import cn.cua.domain.ProductInfo;

/**
 * 产品信息的业务类
 * @author Sandm
 *
 */
public class ProductService {
	private ProductInfoDAO productInfoDao =new ProductInfoDAO();

	public ProductService() {
		super();
	}

	/**
	 * 返回所有产品数
	 * @return
	 */
	public int getProductAmount() {
		return productInfoDao.getProductAmount();
	}
	
	/**
	 * 返回符合特定条件的产品数
	 * @param model
	 * @return
	 */
	public int getProductAmount(ProductInfo model) {
		return productInfoDao.getProductAmount(model);
	}

	/**
	 * 返回所有产品
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findAll(int pageNum, int pageSize) {
		return productInfoDao.findAll(pageNum,pageSize);
	}
	
	/**
	 * 返回符合特定条件的所有产品
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<ProductInfo> findAll(ProductInfo model, int pageNum, int pageSize) {
		return productInfoDao.findAll(model,pageNum, pageSize);
	}

	/**
	 * 增加产品
	 * @param model
	 */
	public void add(ProductInfo model) {
		productInfoDao.add(model);
	}

	/**
	 * 删除产品
	 * @param productId
	 */
	public void delete(int productId) {
		productInfoDao.delete(productId);
	}

	/**
	 * 加载产品
	 * @param productId
	 * @return
	 */
	public ProductInfo load(int productId) {
		return productInfoDao.load(productId);
	}

	/**
	 * 编辑产品
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
