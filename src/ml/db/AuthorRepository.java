package ml.db;

import java.util.List;

import ml.domain.Author;
import ml.web.PaginationSupport;

public interface AuthorRepository {
	
	/**
	 * 获取所有作者
	 * @return
	 */
	long authorCount();
	/**
	 * 新建一个作者
	 * @param user
	 * @return
	 */
	Author save(Author author);
	/**
	 * 通过ID查找一个作者
	 * @param id
	 * @return
	 */
	Author findOne(long id);
	/**
	 * 通过名字查找作者
	 * @return
	 */
	Author findByName(String authorName);
	/**
	 * 列出所有作者
	 * @return
	 */
	List<Author> findAuthor();
	/**
	 * 通过ID修改作者信息
	 * @param id
	 * @return
	 */
	Author alterAuthor(long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int deleteAuthor(long id);
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PaginationSupport<Author> findPageByUserName(int pageNo,int pageSize,String authorName);
	

}
