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

import ml.db.AuthorRepository;
import ml.web.PaginationSupport;
import ml.domain.Author;
import ml.web.PaginationSupport;
/**
 * 作者资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcAuthorRepository implements AuthorRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcAuthorRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	@Override
	public int getAuthorCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(author_id) from author");
	}

	@Override
	public Author addAuthor(Author author) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_AUTHOR,author.getAuthorName(),author.getAuthorSex(),author.getAuthorIntroduct());
		return author;
	}

	@Override
	public Author findByAuthorId(int authorId) {
		// TODO 自动生成的方法存根
		Author author = null;
		try {
			author=jdbc.queryForObject(SELECT_AUTHOR +" where author_id=?", new AuthorRowMapper(),authorId);
		}catch(DataAccessException e) {
			
		}
		return author;
	}

	@Override
	public Author findByName(String authorName) {
		// TODO 自动生成的方法存根
		Author author = null;
		try {
			author=jdbc.queryForObject(SELECT_AUTHOR +" where author_name=?", new AuthorRowMapper(),authorName);
		}catch(DataAccessException e) {
			
		}
		return author;
	}

	@Override
	public Author alterAuthor(Author author) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_AUTHOR,author.getAuthorName(),author.getAuthorSex(),author.getAuthorIntroduct(),author.getAuthorId());
		return author;
	}

	@Override
	public int removeAuthor(int authorId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("delete from author where author_id= ?", authorId);
		return rows;
	}

	@Override
	public PaginationSupport<Author> findPageByAuthorName(int pageNo, int pageSize, String authorName) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public PaginationSupport<Author> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) getAuthorCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Author>(new ArrayList<Author>(0), 0);
		List<Author> items = jdbc.query(SELECT_PAGE_AUTHORS, new AuthorRowMapper(), pageSize, startIndex);
		PaginationSupport<Author> ps = new PaginationSupport<Author>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	private static class AuthorRowMapper implements RowMapper<Author> {
		public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Author(rs.getInt("author_id"),
					rs.getString("author_name"),
					rs.getInt("author_sex"),
					rs.getString("author_introduct"));
		}
	}
	
	
	private String INSERT_AUTHOR = " insert into author (author_name,author_sex,author_introduct) values (?,?,?) ";
	private String SELECT_AUTHOR = " select author_id,author_name ,author_sex,author_introduct from author ";
	private String UPDATE_AUTHOR = " update author set author_name=?, author_sex=?,author_introduct=?  where author_id=? ";
	private String SELECT_PAGE_AUTHORS = SELECT_AUTHOR+" order by author_id limit ? offset  ?";

}
