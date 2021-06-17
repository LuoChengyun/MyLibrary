package ml.db;

import ml.domain.Publishment;
import ml.web.PaginationSupport;

public interface PublishmentRepository {
	//获取出版商数量
	int getPublishmentCount();
	//增加出版社
	Publishment addPublishment(Publishment publishment);
	//查询出版社
	Publishment findByPublishId(int publishId);
	//删除出版商
	int removePublishment(int publishId);
	//修改出版商
	Publishment alterPublishment(Publishment publishment);
	//通过出版社名字查询出版社
	Publishment findByPublishmentName(String publishName);
	//依据页码和指定页面大小，返回用户列表
	PaginationSupport<Publishment> findPage(int pageNo,int pageSize);
	//依据页码和指定页面大小，返回指定用户名的用户列表
	PaginationSupport<Publishment> findPageByUserName(int pageNo,int pageSize,String publishName);

}
