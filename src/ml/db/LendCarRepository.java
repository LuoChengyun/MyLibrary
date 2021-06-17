package ml.db;

import ml.domain.LendCar;
import ml.web.PaginationSupport;

public interface LendCarRepository {
	//添加一本书到借阅车
	int addBookToCart(int userId,int bookId);
	//从借阅车删除一本书
	int removeBookFromCart(int lendCarId);
	//批量提交借阅车
	int submitLendCar(int userId,int[] bookIdList);
	//获取用户个人借阅车列表
	PaginationSupport<LendCar> findPageByUserId(int pageNo,int pageSize,int userId);
	
}
