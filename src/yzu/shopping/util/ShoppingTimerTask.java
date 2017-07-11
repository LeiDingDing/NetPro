package yzu.shopping.util;

import yzu.shopping.dao.ICategory;
import yzu.shopping.dao.IGoods;
import yzu.shopping.impl.CategoryImpl;
import yzu.shopping.impl.GoodsImpl;
import yzu.shopping.pojo.Category;
import yzu.shopping.pojo.Goods;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class ShoppingTimerTask extends TimerTask {
	
	private ICategory categoryImpl = new CategoryImpl();

	private IGoods goodsImpl = new GoodsImpl();
	
	private ServletContext application=null;

	@Override
	public void run() {
		//查询热点类别的推荐商品
		List<List<Goods>> bigList = new ArrayList<List<Goods>>();
		// 查询出最多4个热点类别
		for (Category category : categoryImpl.queryCategory(true)) {
			List<Goods> goodss = goodsImpl.queryGiscommendGoods(category
					.getCid());
			bigList.add(goodss);
		}
		//把大集合存储到app中
		application.setAttribute("bigList", bigList);
		//application.getRequestDispatcher("/indes.jsp");
	}
	
	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

}
