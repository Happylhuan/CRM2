package com.huan.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.IProductDao;
import com.huan.business.po.TsProduct;
import com.huan.business.po.TsProductBrand;
import com.huan.business.po.TsProductType;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false) 
public class ProductService implements IProductService {
	private IProductDao productDao;

	public IProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageModel getProductList(TsProduct product, PageBean page) {
		String hql = " from TsProduct product where 1=1 ";
		
		if(null!=product.getManageId()){
			//Integer userId = productDao.getUserIdByName(product.getUserName());
			hql += " and product.manageId ='"+product.getManageId()+"'";
		}
		/*if("del".equals(product.getState())){
			hql += " and product.productId ='"+product.getProductId()+"'";
		}*/
		if("add".equals(product.getState())||"upd".equals(product.getState())){
			product.setAddTime(null);
			product.setProductName("");
			product.setProductType("");
			product.setVenderAddress("");
		}
		PageModel pageModel = ( PageModel) this.productDao.getProductList(product, page,hql);
		
		return pageModel;
	}

	@Override
	public boolean addProduct(TsProduct product) {
		// TODO Auto-generated method stub
		product.setAddTime(new Date());
		product.setProductName(product.getProductName().trim());
		product.setVenderAddress(product.getVenderAddress().trim());
		return this.productDao.addProduct(product);
	}

	@Override
	public boolean delProduct(TsProduct product) {
		// TODO Auto-generated method stub
		return productDao.delProduct(product);
	}

	@Override
	public boolean updateProduct(TsProduct product) {
		// TODO Auto-generated method stub
		product.setAddTime(new Date());
		product.setProductName(product.getProductName().trim());
		product.setVenderAddress(product.getVenderAddress().trim());
		return productDao.updateProduct(product);
	}

	@Override
	public TsProduct getProductById(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.getProductById(productId);
	}

	@Override
	public List<String> getProductsName() {
		// TODO Auto-generated method stub
		return productDao.getProductsName();
	}

	@Override
	public PageModel getProductTypeList(TsProductType type, PageBean page) {
		// TODO Auto-generated method stub
		return productDao.getProductTypeList(type, page);
	}
	@Override
	public boolean addProductType(TsProductType productType) {
		// TODO Auto-generated method stub
		productType.setProductTypeName(productType.getProductTypeName().trim());
		return this.productDao.addProductType(productType);
	}
	@Override
	public boolean delProductType(TsProductType productType) {
		// TODO Auto-generated method stub
		return this.productDao.delProductType(productType);
	}
	@Override
	public List<String> getProductTypes() {
		// TODO Auto-generated method stub
		return this.productDao.getProductTypes();
	}

	@Override
	public List<String> getProductsBrands() {
		// TODO Auto-generated method stub
		return productDao.getProductBrands();
	}

	@Override
	public PageModel getProductBrandList(TsProductBrand brand, PageBean page) {
		// TODO Auto-generated method stub
		return productDao.getProductBrandList(brand, page);
	}

	@Override
	public boolean addProductBrand(TsProductBrand brand) {
		// TODO Auto-generated method stub
		return productDao.addProductBrand(brand);
	}

	@Override
	public boolean delProductBrand(TsProductBrand brand) {
		// TODO Auto-generated method stub
		return productDao.delProductBrand(brand);
	}

	@Override
	public boolean delsProduct(String delEle) {
		// TODO Auto-generated method stub
		if(""==delEle){
			return false;
		}
		String[] list = delEle.split(";");
		if(productDao.delsProduct(list)){
			
			return true;
		}
		
		return false;	
		}

	@Override
	public boolean delsProductBrand(String delEle) {
		// TODO Auto-generated method stub
		String[] list = delEle.split(";");
		if(productDao.delsProductBrand(list)){
			
			return true;
		}
		
		return false;	
	}

	@Override
	public boolean delsProductType(String delEle) {
		// TODO Auto-generated method stub
		String[] list = delEle.split(";");
		if(productDao.delsProductType(list)){
			
			return true;
		}
		
		return false;	
	}
}
