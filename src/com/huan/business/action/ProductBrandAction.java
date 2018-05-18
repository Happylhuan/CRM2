package com.huan.business.action;

import java.util.List;

import com.huan.business.po.TsProductBrand;
import com.huan.business.service.IProductService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductBrandAction extends ActionSupport implements ModelDriven<TsProductBrand> {
	private TsProductBrand productBrand = new TsProductBrand();
	private List<TsProductBrand> productBrands;
	private IProductService productService;
	private PageModel pageModel;
	private PageBean page = new PageBean(1, 20);
	
	@SuppressWarnings("unchecked")
	public String  listProductBrand(){
		pageModel = this.productService.getProductBrandList(productBrand, page);
		productBrands = (List<TsProductBrand>) pageModel.getObject();
		if (productBrands != null) {
			return "list";
		} else {
			this.addActionError("查询产品品牌失败");
			return INPUT;
		}
		
	}
	
	public String addProductBrand() {
		if (this.productService.addProductBrand(productBrand)) {
			return "success";
		} else {
			this.addActionError("添加产品类型失败");
			return INPUT;
		}
	}
	
	public String delProductBrand() {
		if (this.productService.delProductBrand(productBrand)) {
			return "success";
		} else {
			this.addActionError("删除产品类型失败");
			return INPUT;
		}
	}
	
	public String delsProductBrand() {
		if (this.productService.delsProductBrand(productBrand.getDelEle())) {
			return "success";
		} else {
			this.addActionError("删除产品类型失败");
			return INPUT;
		}
	}
	
	@Override
	public TsProductBrand getModel() {
		// TODO Auto-generated method stub
		return productBrand;
	}


	public TsProductBrand getProductBrand() {
		return productBrand;
	}


	public void setProductBrand(TsProductBrand productBrand) {
		this.productBrand = productBrand;
	}


	public List<TsProductBrand> getProductBrands() {
		return productBrands;
	}


	public void setProductBrands(List<TsProductBrand> productBrands) {
		this.productBrands = productBrands;
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
}
