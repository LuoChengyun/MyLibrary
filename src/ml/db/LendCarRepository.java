package ml.db;

public interface LendCarRepository {
	//添加一本书到借阅车
	int addBookToCart(int userId,int bookId);
	//从借阅车删除一本书
	int removeBookFromCart(int userId,int bookId);
	

}
