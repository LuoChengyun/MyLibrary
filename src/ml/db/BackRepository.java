package ml.db;

import ml.domain.Back;
import ml.web.PaginationSupport;

public interface BackRepository {
	//获取还书表数量
	int getBackCount();
	//增加一个还书申请
	int addBack(Back back);
	//删除一个还书申请
	int removeBackById(int backId);
	//审核还书
	int checkBackById(int backId);
	//获取还书申请列表
	PaginationSupport<Back> findPage(int pageNo,int pageSize);

}
