package com.huan.business.action;

import java.util.List;

import com.huan.business.po.TsProductType;
import com.huan.business.service.IProductService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductTypeAction extends ActionSupport implements ModelDriven<TsProductType> {

	private TsProductType productType = new TsProductType();
	private List<TsProductType> productTypes;
	private IProductService productService;
	private PageModel pageModel;
	private PageBean page = new PageBean(1, 7);
	
	
	@SuppressWarnings("unchecked")
	public String  listProductType(){
		pageModel = this.productService.getProductTypeList(productType, page);
		productTypes = (List<TsProductType>) pageModel.getObject();
		if (productTypes != null) {
			return "list";
		} else {
			this.addActionError("查询产品类型失败");
			return INPUT;
		}
		
	}
	
	public String addProductType() {
		if (this.productService.addProductType(productType)) {
			return "success";
		} else {
			this.addActionError("添加产品类型失败");
			return INPUT;
		}
	}
	
	public String delProductType() {
		if (this.productService.delProductType(productType)) {
			return "success";
		} else {
			this.addActionError("删除产品类型失败");
			return INPUT;
		}
	}
	public String delsProductType() {
		if (this.productService.delsProductType(productType.getDelEle())) {
			return "success";
		} else {
			this.addActionError("删除产品类型失败");
			return INPUT;
		}
	}
	
	public TsProductType getProductType() {
		return productType;
	}



	public void setProductType(TsProductType productType) {
		this.productType = productType;
	}



	public List<TsProductType> getProductTypes() {
		return productTypes;
	}



	public void setProductTypes(List<TsProductType> productTypes) {
		this.productTypes = productTypes;
	}



	public IProductService getProductService() {
		return productService;
	}



	public void setProductService(IProductService productService) {
		this.productService = productService;
	}



	public PageModel getPageModel() {
		return pageModel;
	}



	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}



	public PageBean getPage() {
		return page;
	}



	public void setPage(PageBean page) {
		this.page = page;
	}



	@Override
	public TsProductType getModel() {
		// TODO Auto-generated method stub
		return productType;
	}

}
