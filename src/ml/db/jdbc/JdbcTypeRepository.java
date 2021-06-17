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

import ml.db.TypeRepository;
import ml.domain.Type;
import ml.domain.User;
import ml.web.PaginationSupport;
/**
 * 分类资源接口实现类
 * @author luochengyun
 *
 */
@Repository
public class JdbcTypeRepository implements TypeRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcTypeRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	@Override
	public Type addType(Type type) {
		// TODO 自动生成的方法存根
		jdbc.update(INSERT_TYPE,type.getTypeName());
		return type;
	}

	@Override
	public int getTypeCount() {
		// TODO 自动生成的方法存根
		return (int) jdbc.queryForLong("select count(type_id) from type");
	}

	@Override
	public Type findByTypeId(int typeId) {
		// TODO 自动生成的方法存根
		Type type = null;
		try {
			type=jdbc.queryForObject(SELECT_TYPE +" where type_id=?", new TypeRowMapper(),typeId);
		}catch(DataAccessException e) {
			
		}
		return type;
	}

	@Override
	public int removeType(int typeId) {
		// TODO 自动生成的方法存根
		int rows = jdbc.update("delete from type where type_id= ?", typeId);
		return rows;
	}

	@Override
	public Type alterType(Type type) {
		// TODO 自动生成的方法存根
		jdbc.update(UPDATE_TYPE,type.getTypeName(),type.getTypeId());
		return type;
	}

	@Override
	public PaginationSupport<Type> findPage(int pageNo, int pageSize) {
		// TODO 自动生成的方法存根
		int totalCount = (int) getTypeCount();
		int startIndex = PaginationSupport.convertFromPageToStartIndex(pageNo, pageSize);
		if (totalCount < 1)
			return new PaginationSupport<Type>(new ArrayList<Type>(0), 0);
		List<Type> items = jdbc.query(SELECT_PAGE_TYPES, new TypeRowMapper(), pageSize, startIndex);
		PaginationSupport<Type> ps = new PaginationSupport<Type>(items, totalCount, pageSize, startIndex);
		return ps;
	}
	
	private static class TypeRowMapper implements RowMapper<Type> {
		public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Type(rs.getInt("type_id"),
					rs.getString("type_name"));
		}
	}
	
	
	private String INSERT_TYPE = " insert into type (type_name) values (?)";
	private String SELECT_TYPE = " select type_id,type_name from type ";
	private String UPDATE_TYPE = " update type set type_name=? where type_id=?";
	private String SELECT_PAGE_TYPES = SELECT_TYPE+" order by type_id limit ? offset  ?";

}
