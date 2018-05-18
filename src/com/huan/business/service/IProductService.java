package com.huan.business.service;

import java.util.List;

import com.huan.business.po.TsProduct;
import com.huan.business.po.TsProductBrand;
import com.huan.business.po.TsProductType;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IProductService {

	public PageModel getProductList(TsProduct product,PageBean page);

	public boolean addProduct(TsProduct product);

	public boolean delProduct(TsProduct product);
	public boolean delsProduct(String delEle);
	public boolean updateProduct(TsProduct product);
	
	public TsProduct getProductById(Integer productId);
	
	public List<String> getProductsName();
	
	public PageModel getProductTypeList(TsProductType type, final PageBean page);
	public boolean addProductType(TsProductType productType);
	public boolean delProductType(TsProductType productType);
	public boolean delsProductType(String delEle);
	public List<String> getProductTypes();
	
	public PageModel getProductBrandList(TsProductBrand brand, final PageBean page);
	public boolean addProductBrand(TsProductBrand brand);
	public boolean delProductBrand(TsProductBrand brand);
	public boolean delsProductBrand(String delEle);
	public List<String> getProductsBrands();
	
}
