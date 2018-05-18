package com.huan.business.action;

import java.util.List;

import com.huan.business.po.TsProduct;
import com.huan.business.po.TsProductType;
import com.huan.business.service.IProductService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class ProductAction extends ActionSupport implements ModelDriven<TsProduct> {

	private TsProduct product = new TsProduct();
	private List<TsProduct> products;
	private IProductService productService;
	private PageModel pageModel;
	private PageBean page = new PageBean(1, 20);
	private List<String> productTypes;
	private List<String> productBrands;
	
	@SuppressWarnings("unchecked")
	public String listProduct() {
		pageModel = this.productService.getProductList(product, page);
		products = (List<TsProduct>) pageModel.getObject();
		if (products != null) {
			return "list";
		} else {
			this.addActionError("查询产品失败");
			return INPUT;
		}
	}
	
	public String queryProduct() {
		pageModel = this.productService.getProductList(product, page);
		products = (List<TsProduct>) pageModel.getObject();
		if (products != null) {
			return "query";
		} else {
			this.addActionError("查询产品失败");
			return INPUT;
		}
	}
	public String addbefProduct(){
		List<String> list = this.productService.getProductTypes();
		List<String> list2 = this.productService.getProductsBrands();
		if (list!= null&&null!=list2) {
			productTypes = list;
			productBrands = list2;
			return "add";
		} else {
			this.addActionError("获取客户失败");
			return INPUT;
		}
		
	}
	public String addProduct() {
		if (this.productService.addProduct(product)) {
			return "success";
		} else {
			this.addActionError("添加产品失败");
			return INPUT;
		}
	}
	
	public String delProduct() {
		if (this.productService.delProduct(product)) {
			return "success";
		} else {
			this.addActionError("删除产品失败");
			return INPUT;
		}
	}
	
	public String delsProduct() {
		if (this.productService.delsProduct(product.getDelEle())) {
			return "success";
		} else {
			this.addActionError("删除产品失败");
			return INPUT;
		}
	}
	
	public String updateProduct() {
		if (this.productService.updateProduct(product)) {
			return "success";
		} else {
			this.addActionError("更新产品失败");
			return INPUT;
		}
	}
	
	public String getupProduct() {
		if ((product = this.productService.getProductById(product.getProductId().intValue())) != null) {
			return "update";
		} else {
			this.addActionError("更新产品失败");
			return INPUT;
		}
	}
	
	
	public List<String> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<String> productTypes) {
		this.productTypes = productTypes;
	}

	public List<String> getProductBrands() {
		return productBrands;
	}

	public void setProductBrands(List<String> productBrands) {
		this.productBrands = productBrands;
	}

	public List<TsProduct> getProducts() {
		return products;
	}



	public void setProducts(List<TsProduct> products) {
		this.products = products;
	}



	public TsProduct getProduct() {
		return product;
	}



	public void setProduct(TsProduct product) {
		this.product = product;
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
	public TsProduct getModel() {
		// TODO Auto-generated method stub
		return product;
	}
}
