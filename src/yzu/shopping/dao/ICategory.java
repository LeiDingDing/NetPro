package yzu.shopping.dao;

import java.util.List;

import yzu.shopping.pojo.Category;

public interface ICategory {
	public void saveCategory(Category category);
	
	//查询条件
	public List<Category> queryCategory(String ctype);
	
	public List<Category> queryCategory(boolean isChot);
}
