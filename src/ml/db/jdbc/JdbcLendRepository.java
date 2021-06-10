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

import ml.db.LendRepository;
import ml.domain.Author;
import ml.domain.Book;
import ml.domain.Lend;
import ml.domain.Publishment;
import ml.domain.Type;
import ml.domain.User;
import ml.web.PaginationSupport;
/**
 * 借书记录资源接口实现
 * @author luochengyun
 *
 */
@Repository
public class JdbcLendRepository implements LendRepository {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcLendRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}

	@Override
	public int getLendCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(lend_id) from lend  ");
	}
	
	public int addLend(Lend lend) {
		
		return 0;
		
	}
	
	
	
	@Override
	public int removeLend(int lendId) {
		// TODO 自动生成的方法存根
		Lend lend = null;
		try {
			lend = jdbc.queryForObject(SELECT_LEND+" and lend_id=? ", new LendRowMapper(),lendId);
		}catch(DataAccessException e) {
		}
		int rows ;
		if(lend.getLendBack()==null) {
			rows=0;
		}
		else {
			rows = jdbc.update("delete from lend where lend_id= ?",lendId);
		}
		return rows;
	}
	

	@Override
	public PaginationSupport<Lend> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int)getLendCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Lend>(new ArrayList<Lend>(0),0);
		List<Lend> items =  jdbc.query(SELECT_PAGE_LENDS,new LendRowMapper(),pageSize, startIndex);
		PaginationSupport<Lend> ps = new PaginationSupport<Lend>(items,totalCount,pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<Lend> findPageByName(int pageNo, int pageSize, String userName) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	private static class LendRowMapper implements RowMapper<Lend> {
		public Lend mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Lend(rs.getInt("lend_id"),
					new Book(rs.getInt("book_id"),
							rs.getString("book_name"),
							rs.getString("book_ISBN"),
							rs.getString("book_desc"),
							rs.getDouble("book_price"),
							rs.getDate("book_release"),
							rs.getString("book_localtion"),
							rs.getInt("book_state")),
					new User(rs.getInt("user_id"),
							rs.getString("user_name"),
							rs.getString("user_account"), 
							rs.getString("user_password"),
							rs.getInt("user_identity"),
							rs.getInt("user_state"),
							rs.getInt("user_remove")),
					rs.getDate("lend_day"),
					rs.getDate("lend_back"));
		}
	}
	
	
	private String SELECT_LEND = "select s1.lend_id,s1.lend_book,s1.lend_user,s1.lend_day,s1.lend_back,"
			+ "s2.user_id,s2.user_name,s2.user_account,s2.user_password,s2.user_identity,s2.user_state,user_remove,"
			+ "s3.book_id,s3.book_name,s3.book_ISBN,s3.book_desc,s3.book_price,s3.book_release,s3.book_localtion,s3.book_state "
			+ "from lend s1,book s3,users s2 "
			+ "where s1.lend_book=s3.book_id and s1.lend_user=s2.user_id ";
	private String SELECT_PAGE_LENDS = SELECT_LEND+" order by lend_id desc limit ? offset  ?  ";

	

	

}
