package ml.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ml.db.BackRepository;
import ml.domain.Back;
import ml.web.PaginationSupport;


@Repository
public class JdbcBackRepository implements BackRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcBackRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	public JdbcBackRepository() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int getBackCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(back_id) from back");
	}

	@Override
	public int addBack(Back back) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int removeBackById(int backId) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int checkBackById(int backId) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public PaginationSupport<Back> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		return null;
	}

}
