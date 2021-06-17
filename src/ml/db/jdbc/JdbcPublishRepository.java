package ml.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ml.db.PublishmentRepository;
import ml.domain.Author;
import ml.domain.Publishment;
import ml.web.PaginationSupport;
/**
 * 出版社资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcPublishRepository implements PublishmentRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcPublishRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	@Override
	public int getPublishmentCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(publish_id) from publishment");
	}

	@Override
	public Publishment addPublishment(Publishment publishment) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_PUBLISHMENT,publishment.getPublishName(),publishment.getPublishLocal());
		return publishment;
	}

	@Override
	public int removePublishment(int publishId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("delete from publishment where publish_id= ?", publishId);
		return rows;
	}
	@Override
	public Publishment findByPublishId(int publishId) {
		// TODO 自动生成的方法存根
		Publishment publishment = null;
		try {
			publishment = jdbc.queryForObject(SELECT_PUBLISHMENT+" where publish_id=?", new PublishmentRowMapper(),publishId);
		}catch(DataAccessException e) {
			
		}
		return publishment;
	}

	@Override
	public Publishment alterPublishment(Publishment publishment) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_PUBLISHMENT,publishment.getPublishName(),publishment.getPublishLocal(),publishment.getPublishId());
		return publishment;
	}

	@Override
	public Publishment findByPublishmentName(String publishName) {
		// TODO 自动生成的方法存根
		Publishment publishment = null;
		try {
			publishment=jdbc.queryForObject(SELECT_PUBLISHMENT +" where publish_name=?", new PublishmentRowMapper(),publishName);
		}catch(DataAccessException e) {
			
		}
		return publishment;
	}

	@Override
	public PaginationSupport<Publishment> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) getPublishmentCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Publishment>(new ArrayList<Publishment>(0), 0);
		List<Publishment> items = jdbc.query(SELECT_PAGE_PUBLISHMENTS, new PublishmentRowMapper(), pageSize, startIndex);
		PaginationSupport<Publishment> ps = new PaginationSupport<Publishment>(items, totalCount, pageSize, startIndex);
		return ps;
	}

	@Override
	public PaginationSupport<Publishment> findPageByUserName(int pageNo, int pageSize, String publishName) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	private static class PublishmentRowMapper implements RowMapper<Publishment> {
		public Publishment mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Publishment(rs.getInt("publish_id"),
					rs.getString("publish_name"),
					rs.getString("publish_local"));
		}
	}
	
	
	private String INSERT_PUBLISHMENT = " insert into publishment (publish_name,publish_local) values (?,?)";
	private String SELECT_PUBLISHMENT = " select publish_id,publish_name ,publish_local from publishment ";
	private String UPDATE_PUBLISHMENT = " update publishment set publish_name=? ,publish_local=? where publish_id=?";
	private String SELECT_PAGE_PUBLISHMENTS = SELECT_PUBLISHMENT+" order by publish_id limit ? offset  ?";

	

	
}
