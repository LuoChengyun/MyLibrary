package ml.db;

import java.util.List;
import ml.web.PaginationSupport;

import ml.domain.User;

/**
 * 用户资源库接口
 * 
 * @author nwx
 * @version v1.0
 */
public interface UserRepository {
	 //获取用户数量
    int getUserCount();
    //新建一个用户
    User addUser(User user);
    //通过ID查询用户
    User findByUserId(int userId);
    //通过名字查询用户
    User findByUserName(String userName);
    //通过 账号+密码 查询用户
    User findByAccount(String userAccount,String userPassword);
    //通过用户ID删除用户
    int removeUser(int id);
    //禁用用户
    int checkUserById(int id);
    //恢复用户
    int backUserById(int id);
    //通过ID修改用户
    User alterUserByUserId(User user);
	//依据页码和指定页面大小，返回用户列表
	PaginationSupport<User> findPage(int pageNo,int pageSize);
	//依据页码和指定页面大小，返回指定用户名的用户列表
	PaginationSupport<User> findPageByUserName(int pageNo,int pageSize,String userAccount);
	//修改管理员
	User alterManager(User user);
	
	

}
