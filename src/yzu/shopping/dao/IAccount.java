package yzu.shopping.dao;
import yzu.shopping.pojo.*;

public interface IAccount {
	//接口，验证登陆是否成功
	//返回一个对象
	public Account queryAccount(Account account);
}
