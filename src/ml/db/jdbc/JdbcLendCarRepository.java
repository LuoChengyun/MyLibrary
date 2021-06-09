package ml.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ml.db.LendCarRepository;
import ml.domain.LendCar;
import ml.domain.User;
import ml.domain.Book;

@Repository
public class JdbcLendCarRepository implements LendCarRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcLendCarRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}

	@Override
	public int addBookToCart(int userId, int bookId) {
		// TODO 自动生成的方法存根
		LendCar lendCar = new LendCar();
		lendCar.setLendCarUser(new JdbcUserRepository().findByUserId(userId));
		lendCar.setLendCarBook(new JdbcBookRepository().findByBookId(bookId));
		int rows=jdbc.update(INSERT_LENDCAR,lendCar.getLendCarUser(),lendCar.getLendCarBook());
		return rows;
	}

	@Override
	public int removeBookFromCart(int userId, int bookId) {
		// TODO 自动生成的方法存根
		return 0;
	}
	
	
	private String INSERT_LENDCAR = "insert into lendcar (lendcar_user,lendcar_book) values (?,?) ";
	private String SELECT_LENDCAR = "select s1.lendcar_id,s1.lendcar_user,s1.lendcar_book,"
			+ "s2.user_id,s2.user_name,s2.user_account,s2.user_password,s2.user_identity,s2.user_state,user_remove,"
			+ "s3.book_id,s3.book_name,s3.book_ISBN,s3.book_desc,s3.book_price,s3.book_release,s3.book_localtion,s3.book_count,s3.book_state,s3.book_author,s3.book_publish,s3.book_type "
			+ "from lendcar s1,users s2,book s3 "
			+ "where lendcar_id=? ";

}
