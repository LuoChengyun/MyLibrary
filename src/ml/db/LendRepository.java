package ml.db;

import ml.domain.Lend;
import ml.web.PaginationSupport;

public interface LendRepository {
	//获取记录总数
	int getLendCount();
	//删除记录
	int removeLend(int lendId);
	//获取记录列表
	PaginationSupport<Lend> findPage(int pageNo,int pageSize);
	//通过用户姓名查询记录
	PaginationSupport<Lend> findPageByName(int pageNo,int pageSize,String userName);
	

}
