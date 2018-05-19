package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsProduct;
import com.huan.business.po.TsProductBrand;
import com.huan.business.po.TsProductType;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IProductDao {
	public PageModel getProductList(TsProduct product,PageBean page,String hql);

	public boolean addProduct(TsProduct product);

	public boolean delProduct(TsProduct product);
	public boolean delsProduct(String[] list);
	public boolean updateProduct(TsProduct product);

	public TsProduct getProductById(Integer productId);
	
	public  List<String> getProductsName();
	
	public PageModel getProductTypeList(TsProductType type, final PageBean page);
	public boolean addProductType(TsProductType productType);
	public boolean delProductType(TsProductType productType);
	public boolean delsProductType(String[] list);
	public List<String> getProductTypes();

	public PageModel getProductBrandList(TsProductBrand brand, PageBean page);
	public boolean addProductBrand(TsProductBrand brand);
	public boolean delProductBrand(TsProductBrand brand);
	public boolean delsProductBrand(String[] list);
	public List<String> getProductBrands();
	
	public Integer getProductNumByManageId(BigDecimal manageId);
	public Integer getProductTypeNumByManageId(BigDecimal manageId);
	public Integer getProductBraNumByManageId(BigDecimal manageId);
	
	public Integer getProductNumByUserId(BigDecimal userId);
}
