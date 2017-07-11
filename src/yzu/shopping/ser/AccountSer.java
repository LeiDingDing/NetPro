package yzu.shopping.ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yzu.shopping.dao.IAccount;
import yzu.shopping.impl.AccountImpl;
import yzu.shopping.pojo.Account;

public class AccountSer extends HttpServlet {

	
	private IAccount accountImpl=new AccountImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 4454887653162832199L;

	/**
	 * Constructor of the object.
	 */
	public AccountSer() {
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
		
		this.doPost(request,response);
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
		if(status.equals("login")){
			Account account=new Account();
			account.setAlogin(request.getParameter("alogin"));
			account.setApass(request.getParameter("apass"));
			account=accountImpl.queryAccount(account);	//查
			if(account==null){	//登录失败
				request.setAttribute("error", "对不起，登录失败！");
				request.getRequestDispatcher("/alogin.jsp").forward(request, response);
			}else{	//登录成功
				request.getSession().setAttribute("account", account);
				response.sendRedirect("/shopping/admin/index.jsp");
			}
		}
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
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
