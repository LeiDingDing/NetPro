package yzu.shopping.dao;

import java.util.List;

import yzu.shopping.pojo.Category;
import yzu.shopping.pojo.Goods;

public interface IGoods {
	public List<Goods> queryGiscommendGoods(int cid);
	
	public List<Goods> queryGoods(String gname);
}
