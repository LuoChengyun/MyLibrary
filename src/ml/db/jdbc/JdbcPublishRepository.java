package ml.db.jdbc;

import org.springframework.stereotype.Repository;

import ml.db.PublishmentRepository;
import ml.domain.Publishment;
/**
 * 出版社资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcPublishRepository implements PublishmentRepository {

	@Override
	public Publishment addPublishment() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Publishment findByPublishmentName(String publishName) {
		// TODO 自动生成的方法存根
		return null;
	}

}
