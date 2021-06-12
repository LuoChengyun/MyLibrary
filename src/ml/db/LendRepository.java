package ml.db;

import ml.domain.Lend;
import ml.web.PaginationSupport;

public interface LendRepository {
	//获取记录总数
	int getLendCount();
	//申请借书
	int applyLend(int bookId,int userId);
	//审核申请
	int passApply(int lendId);
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
		

}
