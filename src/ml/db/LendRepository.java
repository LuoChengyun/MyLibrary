package ml.db;

import ml.domain.Lend;
import ml.web.PaginationSupport;

public interface LendRepository {
	//获取记录总数
	int getLendCount();
	//通过ID查找一个记录
	Lend findByLendId(int lendId);
	//申请借书
	int applyLend(int bookId,int userId);
	//审核借书申请
	int passApply(int lendId);
	//申请还书
	int backLend(int lendId);
	//审核还书申请
	int passBack(int lendId);
	//取消申请
	int cancleLend(int lendId);
	//删除记录
	int removeLend(int lendId);
	//获取借书记录列表
	PaginationSupport<Lend> findPage_1_3(int pageNo,int pageSize);
	//获取借书申请列表
	PaginationSupport<Lend> findPage_0(int pageNo,int pageSize);
	//获取还书申请列表
	PaginationSupport<Lend> findPage_2(int pageNo,int pageSize);
	//获取用户个人借书记录列表
	PaginationSupport<Lend> findPageByUserId(int pageNo,int pageSize,int userId);
	//获取用户个人申请记录列表
	PaginationSupport<Lend> findPageByUserId_APPLY(int pageNo,int pageSize,int userId);
	//获取用户个人在读列表
	PaginationSupport<Lend> findPageByUserId_READ(int pageNo,int pageSize,int userId);

}
