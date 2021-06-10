package ml.db.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ml.db.ApplyRepository;
import ml.domain.Apply;
import ml.web.PaginationSupport;

@Repository
public class JdbcApplyRepository implements ApplyRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcApplyRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	public JdbcApplyRepository() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	public int getApplyCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(apply_id) from apply");
	}

	@Override
	public Apply addApply(Apply apply) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int removeApply(int appayId) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int checkApplyById(int applyId) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public PaginationSupport<Apply> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		return null;
	}

}
