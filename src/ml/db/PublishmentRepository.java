package ml.db;

import ml.domain.Publishment;

public interface PublishmentRepository {
	//增加出版社
	Publishment addPublishment();
	//通过出版社名字查询出版社
	Publishment findByPublishmentName(String publishName);

}
