package ml.db.jdbc;

import java.sql.Date;
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
	
	public int applyLend(int bookId,int userId) {
		int lendstate = 0;
		int rows = jdbc.update(INSERT_LEND_0,bookId,userId,lendstate);
		return rows;
		
	}
	
	public int passApply(int lendId) {
		int lendState = 1;
		Date lendDay = new Date(System.currentTimeMillis());
		int rows = jdbc.update(UPDATE_LEND_STATE,lendState,lendDay,lendId);
		return rows;
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
		if(lend.getLendState()==1) {
			rows=0;
		}
		else {
			rows = jdbc.update("delete from lend where lend_id= ?",lendId);
		}
		return rows;
	}
	

	@Override
	public PaginationSupport<Lend> findPage_1_3(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) jdbc.queryForLong("select count(lend_id) from lend where lend_state=1 or lend_state=3  ");
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Lend>(new ArrayList<Lend>(0),0);
		List<Lend> items =  jdbc.query(SELECT_PAGE_LENDS_1_3,new LendRowMapper(),pageSize, startIndex);
		PaginationSupport<Lend> ps = new PaginationSupport<Lend>(items,totalCount,pageSize, startIndex);
		return ps;
	}
	
	@Override
	public PaginationSupport<Lend> findPage_0(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) jdbc.queryForLong("select count(lend_id) from lend  where lend_state=0 ");
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Lend>(new ArrayList<Lend>(0),0);
		List<Lend> items =  jdbc.query(SELECT_PAGE_LENDS_0,new LendRowMapper(),pageSize, startIndex);
		PaginationSupport<Lend> ps = new PaginationSupport<Lend>(items,totalCount,pageSize, startIndex);
		return ps;
	}
	
	
	@Override
	public PaginationSupport<Lend> findPage_2(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) jdbc.queryForLong("select count(lend_id) from lend where lend_state=2  ");
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Lend>(new ArrayList<Lend>(0),0);
		List<Lend> items =  jdbc.query(SELECT_PAGE_LENDS_2,new LendRowMapper(),pageSize, startIndex);
		PaginationSupport<Lend> ps = new PaginationSupport<Lend>(items,totalCount,pageSize, startIndex);
		return ps;
	}
	
	@Override
	public PaginationSupport<Lend> findPageByUserId(int userId,int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int)getLendCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Lend>(new ArrayList<Lend>(0),0);
		List<Lend> items =  jdbc.query(SELECT_PAGE_LENDS_BYUSER,new LendRowMapper(),userId,pageSize, startIndex);
		PaginationSupport<Lend> ps = new PaginationSupport<Lend>(items,totalCount,pageSize, startIndex);
		return ps;
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
					rs.getInt("lend_state"),
					rs.getDate("lend_day"),
					rs.getDate("lend_back"));
		}
	}
	
	
	private String INSERT_LEND_0 = "insert into lend (lend_book,lend_user,lend_state) values (?,?,?)" ;
	private String UPDATE_LEND_STATE = " update lend set lend_state=? ,lend_day=? where lend_id=? ";
	private String SELECT_LEND = "select s1.lend_id,s1.lend_book,s1.lend_user,s1.lend_state,s1.lend_day,s1.lend_back,"
			+ "s2.user_id,s2.user_name,s2.user_account,s2.user_password,s2.user_identity,s2.user_state,user_remove,"
			+ "s3.book_id,s3.book_name,s3.book_ISBN,s3.book_desc,s3.book_price,s3.book_release,s3.book_localtion,s3.book_state "
			+ "from lend s1,book s3,users s2 "
			+ "where s1.lend_book=s3.book_id and s1.lend_user=s2.user_id ";
	private String SELECT_PAGE_LENDS_1_3 = SELECT_LEND+" and s1.lend_state=1 or s1.lend_state=3 order by s1.lend_id desc limit ? offset  ?  ";
	private String SELECT_PAGE_LENDS_0 = SELECT_LEND+" and s1.lend_state=0  order by s1.lend_id desc limit ? offset  ?  ";
	private String SELECT_PAGE_LENDS_2 = SELECT_LEND+" and s1.lend_state=2  order by s1.lend_id desc limit ? offset  ?  ";
	private String SELECT_PAGE_LENDS_BYUSER = SELECT_LEND+ " and s1.lend_user=? order by s1.lend_id desc limit ? offset  ?  ";

	

	

}
