package yzu.shopping.ser;

import yzu.shopping.dao.IUsers;
import yzu.shopping.impl.UsersImpl;
import yzu.shopping.pojo.Forder;
import yzu.shopping.pojo.Users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersSer extends HttpServlet {

	private IUsers usresImpl = new UsersImpl();

	public UsersSer() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		if (status.equals("login")) {
			Users users = new Users();
			users.setUlogin(request.getParameter("ulogin"));
			users.setUpass(request.getParameter("upass"));
			users = usresImpl.queryUsers(users);
			if (users == null) { // 登录失败
				request.setAttribute("error", "用户名和密码错误");
				request.getRequestDispatcher("/ulogin.jsp").forward(request,
						response);
			} else {
				Forder forder=new Forder();	//创建了一个购物车,方便以后购物
				request.getSession().setAttribute("forder", forder);
				request.getSession().setAttribute("users", users);
				if (request.getSession().getAttribute("goUrl") != null) {
					// 说明用户登录成功后要跳转到想去页面
					response.sendRedirect(request.getSession().getAttribute(
							"goUrl").toString());
				} else {
					response.sendRedirect("/shopping/index.jsp");
				}
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
