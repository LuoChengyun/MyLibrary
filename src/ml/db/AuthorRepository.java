package ml.db;

import java.util.List;

import ml.domain.Author;
import ml.web.PaginationSupport;

public interface AuthorRepository {
	
	//获取作者数量
	int getAuthorCount();
	//增加作者
	Author addAuthor(Author author);
	//通过ID查询作者
	Author findByAuthorId(int authorId);
	//通过名字查询作者
	Author findByName(String authorName);
	//修改作者
	Author alterAuthor(Author author);
	//删除作者
	int removeAuthor(int id);
	//通过作者名查询
	PaginationSupport<Author> findPageByAuthorName(int pageNo,int pageSize,String authorName);
	//列出所有作者
	PaginationSupport<Author> findPage(int pageNo,int pageSize);


}
