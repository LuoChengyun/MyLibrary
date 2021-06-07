package ml.db.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import ml.db.AuthorRepository;
import ml.domain.Author;
import ml.web.PaginationSupport;
/**
 * 作者资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcAuthorRepository implements AuthorRepository {
	
	
	private String SELECT_AUTHOR = "select author_name,author_sex,author_introduct from author ";

	@Override
	public long authorCount() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Author save(Author author) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Author findOne(long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Author findByName(String authorName) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Author> findAuthor() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Author alterAuthor(long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int deleteAuthor(long id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public PaginationSupport<Author> findPageByUserName(int pageNo, int pageSize, String authorName) {
		// TODO 自动生成的方法存根
		return null;
	}

}
