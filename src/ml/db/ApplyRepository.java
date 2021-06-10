package ml.db;

import ml.domain.Apply;
import ml.web.PaginationSupport;

public interface ApplyRepository {
	//获取数量
	int getApplyCount();
	//增加一个申请
	Apply addApply(Apply apply);
	//删除一个申请
	int removeApply(int appayId);
	//审核一个申请
	int checkApplyById(int applyId);
	//获取申请列表
	PaginationSupport<Apply> findPage(int pageNo,int pageSize);

}
