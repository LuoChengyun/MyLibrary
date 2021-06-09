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

import ml.db.BookRepository;
import ml.domain.Author;
import ml.domain.Book;
import ml.domain.Publishment;
import ml.domain.Type;
import ml.web.PaginationSupport;
/**
 * 书资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcBookRepository implements BookRepository{
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcBookRepository(JdbcTemplate jdbc) {
		this.jdbc =jdbc;
	}
	
	public JdbcBookRepository() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int getBookCount() {
		// TODO 自动生成的方法存根
		return (int)jdbc.queryForLong("select count(book_id) from book ");
	}
	
	@Override
	public Book findByBookName(String bookName) {
		// TODO 自动生成的方法存根
		Book book = null;
		try {
			book=jdbc.queryForObject( SELECT_BOOK + " where book book_name=?",new BookRowMapper() ,bookName);
		}catch (DataAccessException e) {
		}
		return book;
	}
	
	@Override
	public Book findByBookId(int bookId) {
		// TODO 自动生成的方法存根
		Book book = null;
		try {
			book=jdbc.queryForObject( SELECT_BOOK + " where book book_id=?",new BookRowMapper() ,bookId);
		}catch (DataAccessException e) {
		}
		return book;
	}
	

	@Override
	public Book addBook(Book book) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_BOOK,
				book.getBookName(),
				book.getBookISBN(),
				book.getBookDesc(),
				book.getBookPrice(),
				book.getBookRelease(),
				book.getBookLocation(),
				book.getBookState(),
				book.getBookAuthor(),
				book.getBookPublish(),
				book.getBookType());
		return book;
	}


	@Override
	public int alterBookState_0(int bookId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("update book set book_state=0 where book_id=? ",bookId);
		return rows;
	}
	
	@Override
	public int alterBookState_1(int bookId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("update book set book_state=1 where book_id=? ",bookId);
		return rows;
	}
	
	@Override
	public int alterBookState_2(int bookId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("update book set book_state=2 where book_id=? ",bookId);
		return rows;
	}

	@Override
	public int removeByBookId(int bookId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("delete  from book  where book_id=? ",bookId);
		return rows;
	}

	@Override
	public Book  alterBook(Book book) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_BOOK,
				book.getBookName(),
				book.getBookISBN(),
				book.getBookDesc(),
				book.getBookPrice(),
				book.getBookRelease(),
				book.getBookLocation(),
				book.getBookState(),
				book.getBookAuthor(),
				book.getBookPublish(),
				book.getBookType());
		return book;
	}

	@Override
	public PaginationSupport<Book> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int)getBookCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Book>(new ArrayList<Book>(0),0);
		List<Book> items =  jdbc.query(SELECT_PAGE_BOOKS,new BookRowMapper(),pageSize, startIndex);
		PaginationSupport<Book> ps = new PaginationSupport<Book>(items,totalCount,pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<Book> findPageByBookName(int pageNo, int pageSize, String bookName) {
		// TODO 自动生成的方法存根
		int totalCount = (int)getBookCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Book>(new ArrayList<Book>(0),0);
		List<Book> items =  jdbc.query(SELECT_BOOK + " and s1.book_name like ? order by s1.book_id limit ? offset  ?",new BookRowMapper(),"'%"+bookName+"%'",pageSize, startIndex);
		PaginationSupport<Book> ps = new PaginationSupport<Book>(items,totalCount,pageSize, startIndex);
		return ps;
	}
	
	
	private static class BookRowMapper implements RowMapper<Book>{
		public Book mapRow(ResultSet rs,int rowNum) throws SQLException{
			return new Book(rs.getInt("book_id"),
					rs.getString("book_name"),
					rs.getString("book_ISBN"),
					rs.getString("book_desc"),
					rs.getDouble("book_price"),
					rs.getDate("book_release"),
					rs.getString("book_localtion"),
					rs.getInt("book_state"),
					new Author(rs.getInt("author_id"),rs.getString("author_name"),rs.getInt("author_sex"),rs.getString("author_introduct")),
					new Publishment(rs.getInt("publish_id"),rs.getString("publish_name"),rs.getString("publish_local")),
					new Type(rs.getInt("type_id"),rs.getString("type_name")));
		}
	}
	//插入书
	private String INSERT_BOOK = " insert into book (book_name,book_ISBN,book_desc,book_price,book_release,book_localtion,book_state,book_author,book_publish,book_type) values (?,?,?,?,?,?,?,?,?,?)";
	//查询书
	private String SELECT_BOOK = 
	" select s1.book_id,s1.book_name,s1.book_ISBN,s1.book_desc,s1.book_price,s1.book_release,s1.book_localtion,"+
	" s1.book_state,s1.book_author,s1.book_publish,s1.book_type,"+
	" s2.author_id,s2.author_name,s2.author_sex,s2.author_introduct,"+
	" s3.publish_id,s3.publish_name,s3.publish_local,"+
	" s4.type_id,s4.type_name"+
	" from book s1,author s2,publishment s3,type s4 "+
	" where s1.book_author=s2.author_id and s1.book_publish=s3.publish_id and s1.book_type=s4.type_id ";
	//更新书
	private String UPDATE_BOOK = " update book set book_name=?,book_ISBN=?,book_desc=?,book_price=?,book_release=?,book_localtion=?,book_state=?,book_author=?,book_publish=?,book_type=? ";
	//搜书
	private String SELECT_PAGE_BOOKS = SELECT_BOOK + " order by s1.book_id desc limit ? offset  ? ";

	

	
	

}
