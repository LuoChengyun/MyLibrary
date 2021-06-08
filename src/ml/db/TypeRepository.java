package ml.db;

import ml.domain.Type;
import ml.web.PaginationSupport;

public interface TypeRepository {
	//获取分类数量
	int getTypeCount();
	//增加分类
	Type addType(Type type);
	//查询分类
	Type findByTypeName(String typeName);
	//删除分类
	int removeType(int typeId);
	//修改分类
	Type alterByTypeId(Type type);
	//获取分类列表
	PaginationSupport<Type> findPage(int pageNo,int pageSize);
	
	

}
