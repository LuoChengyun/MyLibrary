package ml.db;

import ml.domain.Book;

public interface BookRepository {
	//通过书名查询一本书
    Book findByBookName(String bookName);
    //增加一本书
    Book addBook(Book book);
    //通过书的ID修改一本书的数量
    int alterBookCount(int bookId);
    //通过书的ID修改书的状态
    int alterBookState(int bookId);
    //通过书的ID删除一本书
    int removeByBookId(int bookId);
    //通过ID修改一本书的信息
    int alterByBookId(int bookId);

}
