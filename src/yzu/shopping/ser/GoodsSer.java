package yzu.shopping.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yzu.shopping.dao.ICategory;
import yzu.shopping.dao.IGoods;
import yzu.shopping.impl.CategoryImpl;
import yzu.shopping.impl.GoodsImpl;
import yzu.shopping.pojo.Category;
import yzu.shopping.pojo.Goods;

public class GoodsSer extends HttpServlet {

	
	private IGoods goodsImpl=new GoodsImpl();
	/**
	 * Constructor of the object.
	 */
	public GoodsSer() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		if(status.equals("queryGoods")){
			String gname=request.getParameter("gname");
			List<Goods> goodss=goodsImpl.queryGoods(gname);
			request.setAttribute("goodss", goodss);//键值对跳转
			request.getRequestDispatcher("/admin/queryGoods.jsp").forward(
					request, response);		
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
