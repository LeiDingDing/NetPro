package yzu.shopping.ser;

import yzu.shopping.pojo.Forder;
import yzu.shopping.pojo.Sorder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForderSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ForderSer() {
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
		//从Session中拿出Forder
		Forder forder=(Forder)request.getSession().getAttribute("forder");
		//获取要买的商品信息
		Sorder sorder=new Sorder();
		sorder.setSname(request.getParameter("gname"));
		sorder.setSnumber(1);
		sorder.setSprice(Double.parseDouble(request.getParameter("gprice")));
		//把购物项添加到Forder 
		forder.getSorders().add(sorder);
		//然后在把Forder重新放入到session中
		request.getSession().setAttribute("forder", forder);
		response.sendRedirect("/shopping/users/showCar.jsp");
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
