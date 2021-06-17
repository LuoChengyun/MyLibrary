package ml.db.jdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ml.db.LendCarRepository;
import ml.domain.LendCar;
import ml.domain.User;
import ml.web.PaginationSupport;
import ml.domain.Book;


@Repository
public class JdbcLendCarRepository implements LendCarRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcLendCarRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}

	@Override
	public int submitLendCar(int userId, int[] bookIdList) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	@Override
	public int addBookToCart(int userId, int bookId) {
		// TODO 自动生成的方法存根
		Date lendCarDay = new Date(System.currentTimeMillis());
		int rows=jdbc.update(INSERT_LENDCAR,userId,bookId,lendCarDay);
		return rows;
	}

	@Override
	public int removeBookFromCart(int lendCarId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update(DELETE_LENDCAR,lendCarId);
		return rows;
	}
	
	@Override
	public PaginationSupport<LendCar> findPageByUserId(int pageNo, int pageSize, int userId) {
		// TODO 自动生成的方法存根
		int totalCount = (int) jdbc.queryForLong("select count(lendcar_id) from lendcar where lendcar_user=?",userId);
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<LendCar>(new ArrayList<LendCar>(0),0);
		List<LendCar> items =  jdbc.query(SELECT_PAGE_LENDCAR_BYUSER,new LendRowMapper(),userId,pageSize, startIndex);
		PaginationSupport<LendCar> ps = new PaginationSupport<LendCar>(items,totalCount,pageSize, startIndex);
		return ps;
	}
	
	
	private static class LendRowMapper implements RowMapper<LendCar> {
		public LendCar mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id=rs.getInt("lendcar_id");
			Book book =	new Book(rs.getInt("book_id"),
							rs.getString("book_name"),
							rs.getString("book_ISBN"),
							rs.getString("book_desc"),
							rs.getDouble("book_price"),
							rs.getDate("book_release"),
							rs.getString("book_localtion"),
							rs.getInt("book_state"));
			User user =	new User(rs.getInt("user_id"),
							rs.getString("user_name"),
							rs.getString("user_account"), 
							rs.getString("user_password"),
							rs.getInt("user_identity"),
							rs.getInt("user_state"),
							rs.getInt("user_remove"));
			Date day =	rs.getDate("lendcar_day");
			return new LendCar(id,user,book,day);
		}
	}
	
	private String INSERT_LENDCAR = "insert into lendcar (lendcar_user,lendcar_book,lendcar_day) values (?,?,?) ";
	private String DELETE_LENDCAR = "delete from lendcar where lendcar_id=? ";
	private String SELECT_LENDCAR = "select s1.lendcar_id,s1.lendcar_user,s1.lendcar_book,s1.lendcar_day, "
			+ "s2.user_id,s2.user_name,s2.user_account,s2.user_password,s2.user_identity,s2.user_state,user_remove, "
			+ "s3.book_id,s3.book_name,s3.book_ISBN,s3.book_desc,s3.book_price,s3.book_release,s3.book_localtion,s3.book_state,s3.book_author,s3.book_publish,s3.book_type "
			+ "from lendcar s1,users s2,book s3 "
			+ "where s1.lendcar_book=s3.book_id and s1.lendcar_user=s2.user_id ";

	private String SELECT_PAGE_LENDCAR_BYUSER = SELECT_LENDCAR+ " and s1.lendcar_user=?  order by s1.lendcar_id desc limit ? offset  ?  ";


}
