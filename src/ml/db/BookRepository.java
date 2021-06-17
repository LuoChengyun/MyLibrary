package ml.db;

import ml.domain.Book;
import ml.web.PaginationSupport;

public interface BookRepository {
	//获取书的总数
	int getBookCount();
	//通过书名查询一本书
    Book findByBookName(String bookName);
    //通过ID查询一本书
    Book findByBookId(int bookId);
    //增加一本书
    Book addBook(Book book);
    //通过书的ID修改书的状态为0
    int alterBookState_0(int bookId);
  //通过书的ID修改书的状态为1
    int alterBookState_1(int bookId);
    //通过书的ID删除一本书
    int removeByBookId(int bookId);
    //通过ID修改一本书的信息
    Book alterBook(Book book);
    //列出所有的书
    PaginationSupport<Book> findPage(int pageNo,int pageSize);
    //依据页码和指定页面大小，返回指定书的用户列表
    PaginationSupport<Book> findPageByBookName(int pageNo,int pageSize,String bookName);
    //依据页码和指定页面大小，返回指定书的用户列表
    PaginationSupport<Book> findPageByBookId(int pageNo,int pageSize,int bookId);
}
