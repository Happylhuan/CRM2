package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsProduct;
import com.huan.business.po.TsProductBrand;
import com.huan.business.po.TsProductType;
import com.huan.business.po.TsProductBrand;
import com.huan.business.po.TsRole;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public class ProductDao extends HibernateDaoSupport implements IProductDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PageModel getProductList(TsProduct product, final PageBean page, String hql) {
		if(null==product&&null==page&&null==hql){
			String hql1 ="from TsProduct product"; 
			HibernateTemplate Template =  this.getHibernateTemplate();
			List<TsRole> list = (List<TsRole>) Template.find(hql1);
			PageModel pageModel = new PageModel(null, list);
			return pageModel;
			}
		
		if (product != null && (product.getProductName() != null && !"".equals(product.getProductName()))) {
			hql += "and product.productName like '%" + product.getProductName() + "%' ";
		}
	
		if (product != null && (product.getProductType() != null && !"".equals(product.getProductType()))) {
			hql += "and product.productType like '%" + product.getProductType() + "%'";
		}
		if (product != null && (product.getAddTime() != null && !"".equals(product.getAddTime()))) {
			hql += "and product.addTime='" + product.getAddTime() + "'";
		}
	
		final String hqla = hql;
		HibernateTemplate Template =  this.getHibernateTemplate();
		int allcows = Template.find(hqla).size();
		List<TsProduct> list = Template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hqla);
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
				List  list = query.list();
				return list;
			}
		});
		int totalpage = page.getTotalPages(page.getPageSize(), allcows);
		if(list.size()==0){
			page.setPageNo(page.getPageNo()-1);
			allcows = Template.find(hqla).size();
			list = Template.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {
					Query query = session.createQuery(hqla);
					query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
					List  list = query.list();
					return list;
				}
			});
			totalpage = page.getTotalPages(page.getPageSize(), allcows);
		}
		page.setAllRows(allcows);
		page.setTotalPage(totalpage);
		PageModel pageModel = new PageModel(page, list);
		return pageModel;
		
	}

	@Override
	public boolean addProduct(TsProduct product) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean delProduct(TsProduct product) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(TsProduct product) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public TsProduct getProductById(Integer productId) {
		// TODO Auto-generated method stub
		String hql = " from TsProduct product where product.productId="+productId+"";
		HibernateTemplate Template =  this.getHibernateTemplate();
		List<TsProduct> list = (List<TsProduct>) Template.find(hql);
		return (TsProduct)list.get(0);
	}

	@Override
	public List<String> getProductsName() {
		PageModel pageModel = this.getProductList(null,null,null);
		List<TsProduct> list = (List<TsProduct>) pageModel.getObject();
		 List<String> name = new ArrayList<String>();
		 for (Object obj : list) {
				TsProduct ts = (TsProduct) obj;
				String str = ts.getProductName()+"-"+ts.getProductType();
				name.add(str);
			}
		 return name;
	}

	@SuppressWarnings("unchecked")
	public PageModel getProductTypeList(TsProductType type, final PageBean page){
		if(null==type){
			String hql1 ="from TsProductType productType"; 
			HibernateTemplate Template =  this.getHibernateTemplate();
			List<TsProductType> list = (List<TsProductType>) Template.find(hql1);
			PageModel pageModel = new PageModel(null, list);
			return pageModel;
			}
		String hql = "from TsProductType type where manageId= "+type.getManageId()+" ";
		if(type.getState()== null){
			if (type.getProductTypeName() != null && !"".equals(type.getProductTypeName())) {
				hql += "and type.productTypeName like '%" + type.getProductTypeName() + "%'";
			}}
		final String hqla = hql;
		HibernateTemplate Template =  this.getHibernateTemplate();
		int allcows = Template.find(hqla).size();
		List<TsProductType> list = Template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hqla);
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
				List  list = query.list();
				return list;
			}
		});
		int totalpage = page.getTotalPages(page.getPageSize(), allcows);
		if(list.size()==0){
			page.setPageNo(page.getPageNo()-1);
			allcows = Template.find(hqla).size();
			list = Template.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {
					Query query = session.createQuery(hqla);
					query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
					List  list = query.list();
					return list;
				}
			});
			totalpage = page.getTotalPages(page.getPageSize(), allcows);
		}
		page.setAllRows(allcows);
		page.setTotalPage(totalpage);
		PageModel pageModel = new PageModel(page, list);
		return pageModel;
	}
	
	@Override
	public boolean addProductType(TsProductType productType) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(productType);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean delProductType(TsProductType productType) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(productType);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public List<String> getProductTypes() {
		// TODO Auto-generated method stub
		PageModel pageModel = this.getProductTypeList(null,null);
		List<TsProductType> list = (List<TsProductType>) pageModel.getObject();
		 List<String> name = new ArrayList<String>();
		 for (Object obj : list) {
			 TsProductType ts = (TsProductType) obj;
				String str = ts.getProductTypeName();
				name.add(str);
			}
		 return name;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PageModel getProductBrandList(TsProductBrand brand, final PageBean page){
		if(null==brand&&null==page){
			String hql1 ="from TsProductBrand brand"; 
			HibernateTemplate Template =  this.getHibernateTemplate();
			List<TsProductBrand> list = (List<TsProductBrand>) Template.find(hql1);
			PageModel pageModel = new PageModel(null, list);
			return pageModel;
			}
		String hql = "from TsProductBrand brand where manageId= "+brand.getManageId()+"";
		if(brand.getState() == null){
			if (brand.getProductBrandName() != null && !"".equals(brand.getProductBrandName())) {
				hql += "and brand.productBrandName like '%" + brand.getProductBrandName() + "%'";
			}
		}
		final String hqla = hql;
		HibernateTemplate Template =  this.getHibernateTemplate();
		int allcows = Template.find(hqla).size();
		List<TsProductBrand> list = Template.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hqla);
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
				List  list = query.list();
				return list;
			}
		});
		int totalpage = page.getTotalPages(page.getPageSize(), allcows);
		if(list.size()==0){
			page.setPageNo(page.getPageNo()-1);
			allcows = Template.find(hqla).size();
			list = Template.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException {
					Query query = session.createQuery(hqla);
					query.setFirstResult((page.getPageNo() - 1) * page.getPageSize()).setMaxResults(page.getPageSize());
					List  list = query.list();
					return list;
				}
			});
			totalpage = page.getTotalPages(page.getPageSize(), allcows);
		}
		page.setAllRows(allcows);
		page.setTotalPage(totalpage);
		PageModel pageModel = new PageModel(page, list);
		return pageModel;
	}

	@Override
	public boolean addProductBrand(TsProductBrand brand) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(brand);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delProductBrand(TsProductBrand brand) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(brand);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<String> getProductBrands() {
		// TODO Auto-generated method stub
		PageModel pageModel = this.getProductBrandList(null,null);
		List<TsProductBrand> list = (List<TsProductBrand>) pageModel.getObject();
		 List<String> name = new ArrayList<String>();
		 for (Object obj : list) {
			 TsProductBrand ts = (TsProductBrand) obj;
				String str = ts.getProductBrandName();
				name.add(str);
			}
		 return name;
	}

	@Override
	public boolean delsProduct(String[] delEle) {
		// TODO Auto-generated method stub
		try {
			for (int i=0;i<delEle.length;i++) {
				Integer id =Integer.valueOf(delEle[i]);
				String sql = "delete ts_product where product_id = ?";   
			    SQLQuery query = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);  
			    query.setInteger(0, id);  
			    query.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delsProductType(String[] list) {
		// TODO Auto-generated method stub
		try {
			for (int i=0;i<list.length;i++) {
				Integer id =Integer.valueOf(list[i]);
				String sql = "delete ts_product_type where product_type_id = ?";   
			    SQLQuery query = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);  
			    query.setInteger(0, id);  
			    query.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delsProductBrand(String[] list) {
		// TODO Auto-generated method stub
		try {
			for (int i=0;i<list.length;i++) {
				Integer id =Integer.valueOf(list[i]);
				String sql = "delete ts_product_brand where product_brand_id = ?";   
			    SQLQuery query = this.getHibernateTemplate().getSessionFactory().openSession().createSQLQuery(sql);  
			    query.setInteger(0, id);  
			    query.executeUpdate();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Integer getProductNumByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsProduct product where product.manageId='"+manageId+"'";
			@SuppressWarnings("unchecked")
			List<TsProduct> list = (List<TsProduct>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.size();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getProductTypeNumByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsProductType type where type.manageId='"+manageId+"'";
			@SuppressWarnings("unchecked")
			List<TsProductType> list = (List<TsProductType>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.size();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getProductBraNumByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsProductBrand brand where brand.manageId='"+manageId+"'";
			@SuppressWarnings("unchecked")
			List<TsProductBrand> list = (List<TsProductBrand>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.size();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getProductNumByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		try {
			String hql=" from TsProduct product where product.manageId= (select manageId from TsUser where userId = "+userId+")";
			@SuppressWarnings("unchecked")
			List<TsProduct> list = (List<TsProduct>) this.getHibernateTemplate().find(hql);
			if(list.size()!=0){
				return list.size();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
