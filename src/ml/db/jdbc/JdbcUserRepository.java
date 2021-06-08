package ml.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ml.db.UserRepository;
import ml.domain.User;
import ml.web.PaginationSupport;

/**
 * 用户资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcUserRepository implements UserRepository {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}

	public JdbcUserRepository() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int getUserCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(user_id) from Users where user_remove=0 ");
	}

	@Override
	public User addUser(User user) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_USER,user.getUserName(),user.getUserAccount(),
				user.getUserPassword());
		return user;
	}

	@Override
	public User findByUserId(int userId) {
		// TODO 自动生成的方法存根
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_USER + " where user_id=?", new UserRowMapper(), userId);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		// TODO 自动生成的方法存根
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_USER + " where user_name=? ", new UserRowMapper(),userName);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public User findByAccount(String userAccount, String userPassword) {
		// TODO 自动生成的方法存根
		User user = null;
		try {
			user = jdbc.queryForObject(SELECT_USER + " where user_account=? and user_password=? ", new UserRowMapper(),
					userAccount,userPassword);
		} catch (DataAccessException e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public int removeUser(int id) {
		// TODO 自动生成的方法存根
		int rows=jdbc.update("update users set user_remove=1 where user_id=?",id);	
		  return rows;
	}
	
	@Override
	public int checkUserById(int id) {
		// TODO 自动生成的方法存根
		int rows=jdbc.update("update users set user_state=1 where user_id=?",id);
		return rows;
	}
	
	@Override
	public int backUserById(int id) {
		// TODO 自动生成的方法存根
		int rows=jdbc.update("update users set user_state=0 where user_id=?",id);
		return rows;
	}

	@Override
	public User alterUserByUserId(User user) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_USER,
				user.getUserName(),
				user.getUserAccount(),
				user.getUserPassword(),
				user.getUserIdentity(),
				user.getUserState(),
				user.getUserRemove());
		return user;
	}

	@Override
	public PaginationSupport<User> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) getUserCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<User>(new ArrayList<User>(0), 0);
		List<User> items = jdbc.query(SELECT_PAGE_USERS, new UserRowMapper(), pageSize, startIndex);
		PaginationSupport<User> ps = new PaginationSupport<User>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<User> findPageByUserName(int pageNo, int pageSize, String userName) {
		// TODO 自动生成的方法存根
		int totalCount = (int) getUserCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<User>(new ArrayList<User>(0), 0);

		List<User> items = jdbc.query(SELECT_USER+" where user_remove=0 and user_name like ? order by user_id  limit ? offset  ?", new UserRowMapper(), "%"+userName+"%",pageSize, startIndex);
		PaginationSupport<User> ps = new PaginationSupport<User>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public User alterManager(User user) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	private static class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getInt("user_id"),
					rs.getString("user_name"),
					rs.getString("user_account"), 
					rs.getString("user_password"),
					rs.getInt("user_identity"),
					rs.getInt("user_state"),
					rs.getInt("user_remove"));
		}
	}
	
	
	private String INSERT_USER = "insert into users (user_name,user_account,user_password) values (?,?,?)";
	private String SELECT_USER = "select user_id,user_name,user_account,user_password,user_identity,user_state,user_remove from users ";
	private String UPDATE_USER = "update users set user_name=?,user_account=?,user_password=? where user_id=? ";
	private String SELECT_PAGE_USERS = SELECT_USER+" where user_remove=0 order by user_id  limit ? offset  ?";


	

	
}
